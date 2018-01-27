package com.atsistema.formacion.Clinic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.atsistema.formacion.Clinic.model.Doctor;

@Repository
public interface DoctorDao extends PagingAndSortingRepository<Doctor, Integer>{
	
	public List<Doctor> findByName(String name);
	
	@Query(value = "select d from Doctor d  "
			+ " join d.consultations c "
			+ " join c.appointments a"
			+ " group by d.id"
			+ " order by count(distinct a.patient) desc")
	public List<Doctor> find5ByNameOrderByPatientsDesc();
}
