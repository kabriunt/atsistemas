package com.atsistema.formacion.Clinic.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.DoctorDao;
import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.dto.DoctorApiDTO;
import com.atsistema.formacion.Clinic.dto.DoctorDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Doctor;
import com.atsistema.formacion.Clinic.service.ConsultationService;
import com.atsistema.formacion.Clinic.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private ConsultationService consultationService;
	
	//@Autowired
	//private RestTemplate restTemplate;
	
	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public List<DoctorDTO> findAll(Integer page, Integer size) {
		List<Doctor> doctors = (List<Doctor>) doctorDao.findAll(new PageRequest(page, size)).getContent();
		return doctors.stream().map(u->map(u)).collect(Collectors.toList());
	}

	@Override
	public DoctorDTO findById(Integer idDoctor) throws NotFoundException {
		Doctor find = doctorDao.findOne(idDoctor);
		return map(Optional.ofNullable(find).orElseThrow(NotFoundException::new));
	}
	
	@Override
	public Doctor findOne(Integer idDoctor) throws NotFoundException {
		Doctor find = doctorDao.findOne(idDoctor);
		return Optional.ofNullable(find).orElseThrow(NotFoundException::new);
	}

	@Override
	public List<DoctorDTO> findByName(String name) {
		List<Doctor> doctors = doctorDao.findByName(name);
		return doctors.stream().map(u->map(u)).collect(Collectors.toList());
	}
	
	@Override
	public List<ConsultationDTO> findConsultationsByIdDoctor(Integer idDoctor) {
		final Doctor doctor = doctorDao.findOne(idDoctor);
		final List<ConsultationDTO> consultations = new ArrayList<>();
		doctor.getConsultations().forEach(a -> consultations.add(consultationService.map(a)));
		return consultations;
	}
	
	@Override
	public List<DoctorDTO> find5ByNameOrderByPatientsDesc(){
		final List<Doctor> doctors = doctorDao.find5ByNameOrderByPatientsDesc();
		return doctors.stream().map(u->map(u)).collect(Collectors.toList());
	}
	
	@Override
	public List<DoctorApiDTO> findByDate(Date iniDate, Date endDate){
		//final HashMap<Doctor, Double> doctors = doctorDao.findByDate(iniDate, endDate);
		//final List<Doctor> dto = doctors.forEac
		//return dto.stream().map(u->map(u)).collect(Collectors.toList());
		List<Doctor> doctors = doctorDao.findByDate(iniDate,endDate);
		return doctors.stream().map(u->mapApi(u)).collect(Collectors.toList());
	}

	@Override
	public DoctorDTO create(DoctorDTO d) {
		final Doctor doctor = doctorDao.save(map(d));
		return map(doctor);
	}

	@Override
	public void update(DoctorDTO d) {
		final Doctor doctor = doctorDao.save(map(d));
		map(doctor);
	}

	@Override
	public void delete(Integer d) throws NotFoundException{
		doctorDao.delete(d);
	}
	
	@Override
	public Doctor map(DoctorDTO dto) {
		return mapper.map(dto, Doctor.class);
	}

	@Override
	public DoctorDTO map(Doctor d) {
		return mapper.map(d, DoctorDTO.class);
	}
	
	@Override
	public DoctorApiDTO mapApi(Doctor d) {
		final DoctorApiDTO doctorApi = new DoctorApiDTO();
		doctorApi.setIdDoctor(d.getId());
		doctorApi.setIdDoctorApi(d.getIdApi());
		//doctorApi.setAppointments(d.getConsultations());
		//doctorApi.setPrice(restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor/"+doctorApi.getIdDoctorApi(), Double.class));
		return doctorApi;
	}
}
