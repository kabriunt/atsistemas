package com.atsistema.formacion.Clinic.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atsistema.formacion.Clinic.model.Consultation;

@Repository
public interface ConsultationDao extends PagingAndSortingRepository<Consultation, Integer>{

	@Query(value = "select c from Consultation as c  "
			+ " 	where c.date BETWEEN :iniDate AND :endDate")
	List<Consultation> findByDate(@Param(value = "iniDate") Date iniDate, @Param(value = "endDate") Date endDate);
}
