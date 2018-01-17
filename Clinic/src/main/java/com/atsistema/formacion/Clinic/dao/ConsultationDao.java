package com.atsistema.formacion.Clinic.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.atsistema.formacion.Clinic.model.Consultation;

public interface ConsultationDao extends PagingAndSortingRepository<Consultation, Integer>{

}
