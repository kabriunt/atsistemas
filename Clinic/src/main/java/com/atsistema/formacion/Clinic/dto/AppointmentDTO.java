package com.atsistema.formacion.Clinic.dto;

import java.io.Serializable;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class AppointmentDTO implements Serializable{

	private static final long serialVersionUID = -4151494031302587339L;

	@Mapping(value = "id")
	private Integer idAppointment;
	
	@Mapping(value = "patient")
	private Integer idPatient;
	
	@Mapping(value = "consultation") 
	private Integer idConsultation;
}
