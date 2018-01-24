package com.atsistema.formacion.Clinic.exception;

public class NotFoundException extends Exception{

	private static final long serialVersionUID = 3638255389892618099L;
	
	private static final String MSG = "La Entidad no existe";
	
	public NotFoundException(String message) {
		super(message);
	}
	
	public NotFoundException() {
		super(MSG);
	}
}
