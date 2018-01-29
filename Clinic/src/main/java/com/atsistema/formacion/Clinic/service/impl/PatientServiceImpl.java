package com.atsistema.formacion.Clinic.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.PatientDao;
import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.dto.PatientDTO;
import com.atsistema.formacion.Clinic.exception.InvalidDataException;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Patient;
import com.atsistema.formacion.Clinic.service.MapperService;
import com.atsistema.formacion.Clinic.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientDao patientDao;

	@Autowired
	private MapperService mp;
	
	@Override
	public List<PatientDTO> findAll(Integer page, Integer size) {
		List<Patient> patients = (List<Patient>) patientDao.findAll(new PageRequest(page, size)).getContent();
		return patients.stream().map(u->mp.map(u)).collect(Collectors.toList());
	}

	@Override
	public PatientDTO findById(Integer idPatient) throws NotFoundException {
		Patient find = patientDao.findOne(idPatient);
		return mp.map(Optional.ofNullable(find).orElseThrow(NotFoundException::new));
	}
	
	@Override
	public Patient findOne(Integer idPatient) throws NotFoundException {
		Patient find = patientDao.findOne(idPatient);
		return Optional.ofNullable(find).orElseThrow(NotFoundException::new);
	}
	
	@Override
	public List<PatientDTO> finByName(String namePatient) {
		List<Patient> patients = patientDao.findByName(namePatient);
		return patients.stream().map(u->mp.map(u)).collect(Collectors.toList());
	}

	@Override
	public List<AppointmentDTO> findAppointmentsByIdPatient(Integer idPatient) {
		final Patient patient = patientDao.findOne(idPatient);
		final List<AppointmentDTO> appointments = new ArrayList<>();
		patient.getAppointements().forEach(a -> appointments.add(mp.map(a)));
		return appointments;
	}

	@Override
	public PatientDTO create(PatientDTO p) throws InvalidDataException{
		Patient patient = mp.map(p);
		patientDao.save(mp.map(p));
		return mp.map(Optional.ofNullable(patient).orElseThrow(InvalidDataException::new));
	}

	@Override
	public void update(PatientDTO p) {
		final Patient patient = patientDao.save(mp.map(p));
		mp.map(patient);
	}

	@Override
	public void delete(Integer idPatient) throws NotFoundException {
		final Patient patient = patientDao.findOne(idPatient);
		Optional.ofNullable(patient).orElseThrow(NotFoundException::new);
		patientDao.delete(idPatient);		
	}
}
