package com.atsistema.formacion.Clinic.dto;

import java.io.Serializable;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class DoctorDTO implements Serializable{

	private static final long serialVersionUID = -4699796476722187752L;
/*
	private String id;

	private String name;
	
	private Double price;
*/

	@Mapping("id")
	private Integer idDoctor;
	
	@Mapping("idApi")
	private String idApi;
	
	@Mapping(value="name")
	private String nameDoctor;
	
	@Mapping(value="lastname")
	private String lastnameDoctor;
	
	private Double price;

	
	//@Mapping(value = "consultations")
	//private List<Consultation> idConsultations = new ArrayList<>();
}
