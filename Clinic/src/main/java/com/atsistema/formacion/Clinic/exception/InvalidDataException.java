package com.atsistema.formacion.Clinic.exception;

public class InvalidDataException extends Exception {

	private static final long serialVersionUID = -148166637669033028L;
	
	private static final String MSG = "Los Datos no son válidos";

	public InvalidDataException(String message) {
		super(message);
	}
	
	public InvalidDataException() {
		super(MSG);
	}

}
