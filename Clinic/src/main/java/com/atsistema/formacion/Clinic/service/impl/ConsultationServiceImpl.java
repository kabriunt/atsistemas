package com.atsistema.formacion.Clinic.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.ConsultationDao;
import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Consultation;
import com.atsistema.formacion.Clinic.service.AppointmentService;
import com.atsistema.formacion.Clinic.service.ConsultationService;

@Service
public class ConsultationServiceImpl implements ConsultationService{

	@Autowired
	private ConsultationDao consultationDao;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public List<ConsultationDTO> findAll(Integer page, Integer size) {
		List<Consultation> consultations = (List<Consultation>) consultationDao.findAll();
		return consultations.stream().map(u->map(u)).collect(Collectors.toList());
	}

	@Override
	public ConsultationDTO findById(Integer idConsultation) throws NotFoundException {
		Consultation find = consultationDao.findOne(idConsultation);
		return map(Optional.ofNullable(find).orElseThrow(NotFoundException::new));
	}

	@Override
	public ConsultationDTO create(ConsultationDTO c) {
		//final Consultation consultation = consultationDao.save(map(c));
		//return map(consultation);
		final Consultation consultation = map(c);
		consultation.setDate(new Date());
		return map(consultationDao.save(consultation));
	}

	@Override
	public void update(ConsultationDTO c) {
		final Consultation consultation = consultationDao.save(map(c));
		map(consultation);
		
	}

	@Override
	public void delete(Integer idConsultation) throws NotFoundException {
		consultationDao.delete(idConsultation);
		
	}
	
	@Override
	public List<AppointmentDTO> findAppointmentsByIdConsultation(Integer idConsultation) {
		final Consultation consultation = consultationDao.findOne(idConsultation);
		final List<AppointmentDTO> appointments = new ArrayList<>();
		//clinic.getRooms().forEach(a -> rooms.add(mapper.map(a,RoomDTO.class)));
		consultation.getAppointments().forEach(a -> appointments.add(appointmentService.map(a)));
		return appointments;
	}

	@Override
	public Consultation map(ConsultationDTO dto) {
		return mapper.map(dto, Consultation.class);
	}

	@Override
	public ConsultationDTO map(Consultation c) {
		return mapper.map(c, ConsultationDTO.class);
	}	
}
