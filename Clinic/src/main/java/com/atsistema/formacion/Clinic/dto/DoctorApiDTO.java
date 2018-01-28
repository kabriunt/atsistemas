package com.atsistema.formacion.Clinic.dto;

import java.io.Serializable;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class DoctorApiDTO implements Serializable{

	private static final long serialVersionUID = -4699796476722187752L;
	
	@Mapping("id")
	private Integer idDoctor;
	
	@Mapping(value="id_api")
	private String idDoctorApi;
	
	@Mapping(value="price")
	private Double price;
	
	private Double appointments;
	
	private Double benefice;
	
}
