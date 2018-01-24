package com.atsistema.formacion.Clinic.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.PatientDao;
import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.dto.PatientDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Patient;
import com.atsistema.formacion.Clinic.service.AppointmentService;
import com.atsistema.formacion.Clinic.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public List<PatientDTO> findAll(Integer page, Integer size) {
		List<Patient> patients = (List<Patient>) patientDao.findAll();
		return patients.stream().map(u->map(u)).collect(Collectors.toList());
	}

	@Override
	public PatientDTO findById(Integer idPatient) throws NotFoundException {
		Patient find = patientDao.findOne(idPatient);
		return map(Optional.ofNullable(find).orElseThrow(NotFoundException::new));
	}

	@Override
	public PatientDTO create(PatientDTO p) {
		final Patient patient = patientDao.save(map(p));
		return map(patient);
	}

	@Override
	public void update(PatientDTO p) {
		final Patient patient = patientDao.save(map(p));
		map(patient);
	}

	@Override
	public void delete(Integer idPatient) throws NotFoundException {
		patientDao.delete(idPatient);		
	}

	@Override
	public List<AppointmentDTO> findAppointmentsByIdPatient(Integer idPatient) {
		final Patient patient = patientDao.findOne(idPatient);
		final List<AppointmentDTO> appointments = new ArrayList<>();
		//doctor.getRooms().forEach(a -> consultations.add(mapper.map(a,ConsultationDTO.class)));
		patient.getAppointements().forEach(a -> appointments.add(appointmentService.map(a)));
		return appointments;
	}

	@Override
	public Patient map(PatientDTO dto) {
		return mapper.map(dto, Patient.class);
	}

	@Override
	public PatientDTO map(Patient p) {
		return mapper.map(p, PatientDTO.class);
	}
}
