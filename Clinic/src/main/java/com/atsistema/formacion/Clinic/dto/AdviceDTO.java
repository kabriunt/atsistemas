package com.atsistema.formacion.Clinic.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AdviceDTO implements Serializable{

	private static final long serialVersionUID = -1953460089971009907L;
	
	private Integer code;

	private String msg;

	public AdviceDTO(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
}
