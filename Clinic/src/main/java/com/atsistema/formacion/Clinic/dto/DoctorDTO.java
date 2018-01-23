package com.atsistema.formacion.Clinic.dto;

import java.io.Serializable;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class DoctorDTO implements Serializable{

	private static final long serialVersionUID = -4699796476722187752L;
	
	@Mapping("id")
	private Integer idDoctor;
	
	@Mapping(value="name")
	private String nameDoctor;
	
	@Mapping(value="lastname")
	private String lastnameDoctor;
	
	//@Mapping(value = "consultations")
	//private List<Consultation> idConsultations = new ArrayList<>();
}
