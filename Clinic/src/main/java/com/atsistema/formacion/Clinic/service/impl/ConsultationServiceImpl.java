package com.atsistema.formacion.Clinic.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.ConsultationDao;
import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Consultation;
import com.atsistema.formacion.Clinic.service.ConsultationService;
import com.atsistema.formacion.Clinic.service.MapperService;


@Service
public class ConsultationServiceImpl implements ConsultationService{

	@Autowired
	private ConsultationDao consultationDao;
	
	@Autowired
	private MapperService mp;
	
	@Override
	public List<ConsultationDTO> findAll(Integer page, Integer size) {
		List<Consultation> consultations = (List<Consultation>) consultationDao.findAll(new PageRequest(page, size)).getContent();
		return consultations.stream().map(u->mp.map(u)).collect(Collectors.toList());
	}

	@Override
	public ConsultationDTO findById(Integer idConsultation) throws NotFoundException {
		Consultation find = consultationDao.findOne(idConsultation);
		return mp.map(Optional.ofNullable(find).orElseThrow(NotFoundException::new));
	}
	
	@Override
	public Consultation findOne(Integer idConsultation) throws NotFoundException {
		Consultation find = consultationDao.findOne(idConsultation);
		return Optional.ofNullable(find).orElseThrow(NotFoundException::new);
	}	
	
	@Override
	public List<AppointmentDTO> findAppointmentsByIdConsultation(Integer idConsultation) {
		final Consultation consultation = consultationDao.findOne(idConsultation);
		final List<AppointmentDTO> appointments = new ArrayList<>();
		consultation.getAppointments().forEach(a -> appointments.add(mp.map(a)));
		return appointments;
	}
	
	@Override
	public List<Consultation> findByDate(Date iniDate, Date endDate){
		List<Consultation> consultations = consultationDao.findByDate(iniDate,endDate);
		return consultations;
	}

	@Override
	public ConsultationDTO create(ConsultationDTO c) throws NotFoundException {
		final Consultation consultation = consultationDao.save(mp.map(c));
		return mp.map(consultationDao.save(consultation));
	}

	@Override
	public void update(ConsultationDTO c) throws NotFoundException {
		final Consultation consultation = consultationDao.save(mp.map(c));
		mp.map(consultation);
	}

	@Override
	public void delete(Integer idConsultation) throws NotFoundException {
		consultationDao.delete(idConsultation);
	}
}
