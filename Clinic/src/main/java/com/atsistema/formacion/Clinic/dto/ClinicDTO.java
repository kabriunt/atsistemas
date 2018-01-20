package com.atsistema.formacion.Clinic.dto;


import java.io.Serializable;

import lombok.Data;


@Data
public class ClinicDTO implements Serializable{

	private static final long serialVersionUID = -2215759703326698623L;
	
	//@Mapping(value="id")
	private Integer id;
	
	private String name;
	
	private String adress;
	
	

}
