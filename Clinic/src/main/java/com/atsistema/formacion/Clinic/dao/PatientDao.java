package com.atsistema.formacion.Clinic.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.atsistema.formacion.Clinic.model.Patient;

public interface PatientDao extends PagingAndSortingRepository<Patient, Integer>{
	
	public List<Patient> findByName(String name);

}
