package com.atsistema.formacion.Clinic.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.atsistema.formacion.Clinic.dao.DoctorDao;
import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.dto.DoctorApiDTO;
import com.atsistema.formacion.Clinic.dto.DoctorDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Consultation;
import com.atsistema.formacion.Clinic.model.Doctor;
import com.atsistema.formacion.Clinic.service.ConsultationService;
import com.atsistema.formacion.Clinic.service.DoctorService;
import com.atsistema.formacion.Clinic.service.MapperService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private ConsultationService consultationService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MapperService mp;

	@Override
	public List<DoctorDTO> findAll(Integer page, Integer size) {
		List<Doctor> doctors = (List<Doctor>) doctorDao.findAll(new PageRequest(page, size)).getContent();
		return doctors.stream().map(u->mp.map(u)).collect(Collectors.toList());
	}

	@Override
	public DoctorDTO findById(Integer idDoctor) throws NotFoundException {
		Doctor find = doctorDao.findOne(idDoctor);
		return mp.map(Optional.ofNullable(find).orElseThrow(NotFoundException::new));
	}
	
	@Override
	public Doctor findOne(Integer idDoctor) throws NotFoundException {
		Doctor find = doctorDao.findOne(idDoctor);
		return Optional.ofNullable(find).orElseThrow(NotFoundException::new);
	}

	@Override
	public List<DoctorDTO> findByName(String name) {
		List<Doctor> doctors = doctorDao.findByName(name);
		return doctors.stream().map(u->mp.map(u)).collect(Collectors.toList());
	}
	
	@Override
	public List<ConsultationDTO> findConsultationsByIdDoctor(Integer idDoctor) {
		final Doctor doctor = doctorDao.findOne(idDoctor);
		final List<ConsultationDTO> consultations = new ArrayList<>();
		doctor.getConsultations().forEach(a -> consultations.add(mp.map(a)));
		return consultations;
	}

	@Override
	public List<DoctorDTO> find5OrderByPatientsDesc(Integer page, Integer size){
		List<Doctor> doctors =  doctorDao.find5ByNameOrderByPatientsDesc(new PageRequest(0, size));
		return doctors.stream().map(u->mp.map(u)).collect(Collectors.toList());
	}

	@Override
	public List<DoctorDTO> findByDate(Date iniDate, Date endDate){
		List<Doctor> doctors = doctorDao.findByDate(iniDate,endDate);
		return doctors.stream().map(u->mp.map(u)).collect(Collectors.toList());
	}
	
	@Override
	public List<DoctorApiDTO> findStatsByDate(Date iniDate, Date endDate){
		List<Consultation> consultations = consultationService.findByDate(iniDate,endDate);
		List<DoctorApiDTO> doctors = new ArrayList<>();
		for(Consultation c : consultations){
			FillStats(c,doctors);
		}
		return doctors;
	}
	
	@Override
	public void FillStats(Consultation c, List<DoctorApiDTO> doctors){
		DoctorApiDTO dto = new DoctorApiDTO();
		dto.setIdInternal(c.getDoctor().getId());
		dto.setId(c.getDoctor().getIdApi());
		dto.setAppointments(c.getAppointments().size());
		if (dto.getId() != null ) {
			dto.setPrice(getDoctorPrice(dto.getId()));
			dto.setBenefits(dto.getPrice()*dto.getAppointments());
		}
		doctors.add(dto);
	}
	
	@Override
	public Double getDoctorPrice(String id){
		DoctorApiDTO priceDTO = restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor/"+id, DoctorApiDTO.class);
		return priceDTO.getPrice();
	}

	@Override
	public DoctorDTO create(DoctorDTO d) {
		final Doctor doctor = doctorDao.save(mp.map(d));
		return mp.map(doctor);
	}

	@Override
	public void update(DoctorDTO d) {
		final Doctor doctor = doctorDao.save(mp.map(d));
		mp.map(doctor);
	}

	@Override
	public void delete(Integer d) throws NotFoundException{
		doctorDao.delete(d);
	}
}
