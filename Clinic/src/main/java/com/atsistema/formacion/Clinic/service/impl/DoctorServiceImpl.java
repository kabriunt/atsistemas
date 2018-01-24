package com.atsistema.formacion.Clinic.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.DoctorDao;
import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
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
	public List<ConsultationDTO> findConsultationsByIdDoctor(Integer idDoctor) {
		final Doctor doctor = doctorDao.findOne(idDoctor);
		final List<ConsultationDTO> consultations = new ArrayList<>();
		//doctor.getRooms().forEach(a -> consultations.add(mapper.map(a,ConsultationDTO.class)));
		doctor.getConsultations().forEach(a -> consultations.add(consultationService.map(a)));
		return consultations;
	}
	
	@Override
	public Doctor map(DoctorDTO dto) {
		return mapper.map(dto, Doctor.class);
	}

	@Override
	public DoctorDTO map(Doctor d) {
		return mapper.map(d, DoctorDTO.class);
	}
}
