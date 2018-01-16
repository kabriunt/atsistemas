package com.atsistema.formacion.Clinic.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.atsistema.formacion.Clinic.model.Doctor;

public interface DoctorDao extends PagingAndSortingRepository<Doctor, Integer>{
	
	public List<Doctor> findByName(String name);

}
