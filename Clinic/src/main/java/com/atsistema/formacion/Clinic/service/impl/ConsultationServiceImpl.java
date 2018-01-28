package com.atsistema.formacion.Clinic.service.impl;

import java.util.ArrayList;
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
import com.atsistema.formacion.Clinic.model.Doctor;
import com.atsistema.formacion.Clinic.model.Room;
import com.atsistema.formacion.Clinic.service.AppointmentService;
import com.atsistema.formacion.Clinic.service.ConsultationService;
import com.atsistema.formacion.Clinic.service.DoctorService;
import com.atsistema.formacion.Clinic.service.RoomService;

@Service
public class ConsultationServiceImpl implements ConsultationService{

	@Autowired
	private ConsultationDao consultationDao;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private RoomService roomService;
	
	@Override
	public List<ConsultationDTO> findAll(Integer page, Integer size) {
		List<Consultation> consultations = (List<Consultation>) consultationDao.findAll(new PageRequest(page, size)).getContent();
		return consultations.stream().map(u->map(u)).collect(Collectors.toList());
	}

	@Override
	public ConsultationDTO findById(Integer idConsultation) throws NotFoundException {
		Consultation find = consultationDao.findOne(idConsultation);
		return map(Optional.ofNullable(find).orElseThrow(NotFoundException::new));
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
		consultation.getAppointments().forEach(a -> appointments.add(appointmentService.map(a)));
		return appointments;
	}

	@Override
	public ConsultationDTO create(ConsultationDTO c) throws NotFoundException {
		final Consultation consultation = consultationDao.save(map(c));
		return map(consultationDao.save(consultation));
	}

	@Override
	public void update(ConsultationDTO c) throws NotFoundException {
		final Consultation consultation = consultationDao.save(map(c));
		map(consultation);
	}

	@Override
	public void delete(Integer idConsultation) throws NotFoundException {
		consultationDao.delete(idConsultation);
	}

	@Override
	public Consultation map(ConsultationDTO dto) throws NotFoundException {
		final Consultation consultation;
		final Doctor doctor = doctorService.findOne(dto.getIdDoctor());
		final Room room = roomService.findOne(dto.getIdRoom());
		
		if (consultationDao.exists(dto.getIdConsultation())) {
			consultation = consultationDao.findOne(dto.getIdConsultation());			
		} else {
			consultation = new Consultation();
		}
		consultation.setTurn(dto.getTurn());
		consultation.setDate(dto.getDate());
		consultation.setDoctor(doctor);
		consultation.setRoom(room);		
		return consultation;
	}

	@Override
	public ConsultationDTO map(Consultation c) {
		final ConsultationDTO dto =new ConsultationDTO();
		dto.setIdConsultation(c.getId());
		dto.setTurn(c.getTurn());
		dto.setDate(c.getDate());
		dto.setIdRoom(c.getRoom().getId());
		dto.setIdDoctor(c.getDoctor().getId());
		return dto;
	}
}
