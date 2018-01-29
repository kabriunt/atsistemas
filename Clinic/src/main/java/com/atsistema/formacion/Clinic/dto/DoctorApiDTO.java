package com.atsistema.formacion.Clinic.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DoctorApiDTO implements Serializable{

	private static final long serialVersionUID = 5121253142925658040L;

	private String id;
	
	private Integer idInternal;

	private String name;
	
	private Double price;
	
	private Integer appointments;
	
	private Double benefits;
}
