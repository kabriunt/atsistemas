package com.atsistema.formacion.Clinic.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.atsistema.formacion.Clinic.model.Doctor;

@Repository
public interface DoctorDao extends PagingAndSortingRepository<Doctor, Integer>{
	
	public List<Doctor> findByName(String name);
	
	//@Query("select ...")
	//public List<Doctor> find5ByNameOrderByPatientDesc();

}
