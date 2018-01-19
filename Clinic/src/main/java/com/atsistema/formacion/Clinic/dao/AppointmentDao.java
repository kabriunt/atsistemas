package com.atsistema.formacion.Clinic.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.atsistema.formacion.Clinic.model.Appointment;

@Repository
public interface AppointmentDao  extends PagingAndSortingRepository<Appointment, Integer>{

}
