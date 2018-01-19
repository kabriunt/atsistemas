package com.atsistema.formacion.Clinic.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.atsistema.formacion.Clinic.model.Consultation;

@Repository
public interface ConsultationDao extends PagingAndSortingRepository<Consultation, Integer>{

}
