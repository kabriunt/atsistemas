package com.atsistema.formacion.Clinic.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.atsistema.formacion.Clinic.model.Appointment;

public interface AppointmentDao  extends PagingAndSortingRepository<Appointment, Integer>{

}
