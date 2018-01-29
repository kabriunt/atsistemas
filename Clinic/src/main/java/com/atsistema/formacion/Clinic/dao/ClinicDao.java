package com.atsistema.formacion.Clinic.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.atsistema.formacion.Clinic.model.Clinic;

@Repository
public interface ClinicDao extends PagingAndSortingRepository<Clinic, Integer>{
	
	public List<Clinic> findByName(String name);
}
