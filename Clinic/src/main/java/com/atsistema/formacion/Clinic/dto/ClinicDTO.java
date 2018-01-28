package com.atsistema.formacion.Clinic.dto;


import java.io.Serializable;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class ClinicDTO implements Serializable{

	private static final long serialVersionUID = -2215759703326698623L;
	
	@Mapping(value = "id")
	private Integer idClinic;
	
	@Mapping(value = "name")
	private String nameClinic;
	
	@Mapping(value = "adress")
	private String adressClinic;
}
