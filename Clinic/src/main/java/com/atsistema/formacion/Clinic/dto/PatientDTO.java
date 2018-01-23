package com.atsistema.formacion.Clinic.dto;

import java.io.Serializable;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class PatientDTO implements Serializable{

	private static final long serialVersionUID = 2529806075459477438L;

	@Mapping(value = "id")
	private Integer idPatient;
	
	@Mapping(value = "name")
	private String namePatient;
	
	@Mapping(value = "lastname")
	private String lastnamePatient;

	//@Mapping(value = "appointments")
	//private List<Appointment> idAppointements = new ArrayList<>();
}
