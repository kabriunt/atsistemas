package com.atsistema.formacion.Clinic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.PatientDao;
import com.atsistema.formacion.Clinic.dto.PatientDTO;
import com.atsistema.formacion.Clinic.model.Patient;
import com.atsistema.formacion.Clinic.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientDao patientDao;

	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public List<PatientDTO> findAll(Integer page, Integer size) {
		List<Patient> patients = (List<Patient>) patientDao.findAll();
		return patients.stream().map(u->map(u)).collect(Collectors.toList());
	}

	@Override
	public PatientDTO findById(Integer idPatient) {
		Patient find = patientDao.findOne(idPatient);
		return map(Optional.ofNullable(find).orElseThrow(IllegalStateException::new));
	}

	@Override
	public PatientDTO create(PatientDTO d) {
		final Patient save = patientDao.save(map(d));
		return map(save);
	}

	@Override
	public void update(PatientDTO d) {
		final Patient save = patientDao.save(map(d));
		map(save);
	}

	@Override
	public void delete(Integer idPatient) {
		patientDao.delete(idPatient);		
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
