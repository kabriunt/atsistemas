package com.atsistema.formacion.Clinic.dto;

import java.io.Serializable;
import java.util.Date;

import org.dozer.Mapping;

import com.atsistema.formacion.Clinic.model.Turn;

import lombok.Data;

@Data
public class ConsultationDTO implements Serializable{

	private static final long serialVersionUID = 8347458855524851831L;
	
	@Mapping(value = "id")
	private Integer idConsultation;

	@Mapping(value = "doctor")
	private Integer idDoctor;

	@Mapping(value = "room")
	private Integer idRoom;
	
	private Date date;
	
	private Turn turn;
	
}
