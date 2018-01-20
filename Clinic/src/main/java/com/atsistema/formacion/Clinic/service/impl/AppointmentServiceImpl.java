package com.atsistema.formacion.Clinic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.AppointmentDao;
import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.model.Appointment;
import com.atsistema.formacion.Clinic.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentDao appointmentDao;

	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public List<AppointmentDTO> findAll(Integer page, Integer size) {
		List<Appointment> appointments = (List<Appointment>) appointmentDao.findAll();
		return appointments.stream().map(u->map(u)).collect(Collectors.toList());
	}

	@Override
	public AppointmentDTO findById(Integer idAppointment) {
		Appointment find = appointmentDao.findOne(idAppointment);
		return map(Optional.ofNullable(find).orElseThrow(IllegalStateException::new));
	}

	@Override
	public AppointmentDTO create(AppointmentDTO a) {
		final Appointment save = appointmentDao.save(map(a));
		return map(save);
	}

	@Override
	public void update(AppointmentDTO a) {
		final Appointment save = appointmentDao.save(map(a));
		map(save);
		
	}

	@Override
	public void delete(Integer a) {
		appointmentDao.delete(a);
		
	}

	@Override
	public Appointment map(AppointmentDTO dto) {
		return mapper.map(dto, Appointment.class);
	}

	@Override
	public AppointmentDTO map(Appointment a) {
		return mapper.map(a, AppointmentDTO.class);
	}
	
	
}
