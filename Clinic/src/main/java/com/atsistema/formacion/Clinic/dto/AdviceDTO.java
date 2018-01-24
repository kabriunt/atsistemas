package com.atsistema.formacion.Clinic.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AdviceDTO implements Serializable{

	private static final long serialVersionUID = -1953460089971009907L;
	
	private Integer code;

	private String msg;

	public AdviceDTO(int i, String message) {
		super();
		code = i;
		msg = message;
	}

}
