package com.atsistema.formacion.Clinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.atsistema.formacion.Clinic.dto.AdviceDTO;
import com.atsistema.formacion.Clinic.exception.InvalidDataException;
import com.atsistema.formacion.Clinic.exception.NotFoundException;

@ControllerAdvice(basePackages = "com.atsistema.formacion.Clinic.controller")
public class AdviceController {
	
	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public AdviceDTO error(NotFoundException e) {
		return new AdviceDTO(404, e.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(InvalidDataException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public AdviceDTO error(InvalidDataException e) {
		return new AdviceDTO(400, e.getMessage());
	}
}
