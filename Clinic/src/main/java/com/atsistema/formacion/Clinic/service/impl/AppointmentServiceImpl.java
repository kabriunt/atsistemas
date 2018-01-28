package com.atsistema.formacion.Clinic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.AppointmentDao;
import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Appointment;
import com.atsistema.formacion.Clinic.model.Consultation;
import com.atsistema.formacion.Clinic.model.Patient;
import com.atsistema.formacion.Clinic.service.AppointmentService;
import com.atsistema.formacion.Clinic.service.ConsultationService;
import com.atsistema.formacion.Clinic.service.PatientService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentDao appointmentDao;

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private ConsultationService consultationService;
	
	@Override
	public List<AppointmentDTO> findAll(Integer page, Integer size) {
		List<Appointment> appointments = (List<Appointment>) appointmentDao.findAll(new PageRequest(page, size)).getContent();
		return appointments.stream().map(u->map(u)).collect(Collectors.toList());
	}

	@Override
	public AppointmentDTO findById(Integer idAppointment) throws NotFoundException{
		Appointment find = appointmentDao.findOne(idAppointment);
		return map(Optional.ofNullable(find).orElseThrow(NotFoundException::new));
	}

	@Override
	public AppointmentDTO create(AppointmentDTO a) throws NotFoundException {
		final Appointment appointment = appointmentDao.save(map(a));
		return map(appointment);
	}

	@Override
	public void update(AppointmentDTO a) throws NotFoundException {
		final Appointment appointment = appointmentDao.save(map(a));
		map(appointment);
	}

	@Override
	public void delete(Integer idAppointment) throws NotFoundException {
		appointmentDao.delete(idAppointment);
	}

	@Override
	public Appointment map(AppointmentDTO dto) throws NotFoundException {
		final Appointment appointment;
		final Consultation consultation = consultationService.findOne(dto.getIdConsultation());
		final Patient patient = patientService.findOne(dto.getIdPatient());
		
		if (appointmentDao.exists(dto.getIdAppointment())) {
			appointment = appointmentDao.findOne(dto.getIdAppointment());			
		} else {
			appointment = new Appointment();
		}
		appointment.setConsultation(consultation);
		appointment.setPatient(patient);
		return appointment;
	}

	@Override
	public AppointmentDTO map(Appointment a) {
		final AppointmentDTO dto = new AppointmentDTO();
		dto.setIdAppointment(a.getId());
		dto.setIdConsultation(a.getConsultation().getId());
		dto.setIdPatient(a.getPatient().getId());
		return dto;
	}	
}
