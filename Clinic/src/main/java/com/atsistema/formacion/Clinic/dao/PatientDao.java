package com.atsistema.formacion.Clinic.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.atsistema.formacion.Clinic.model.Patient;

@Repository
public interface PatientDao extends PagingAndSortingRepository<Patient, Integer>{
	
	public List<Patient> findByName(String name);

}
