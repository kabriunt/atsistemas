package com.atsistema.formacion.Clinic.dto;

import java.io.Serializable;

import org.dozer.Mapping;

import com.atsistema.formacion.Clinic.model.Turn;

import lombok.Data;

@Data
public class ConsultationDTO implements Serializable{

	private static final long serialVersionUID = 8347458855524851831L;
	
	@Mapping(value = "id")
	private Integer idConsultation;
	
	private String date;
	
	private Turn turn;
	/*
	@Mapping(value = "appointments")
	private List<Appointment> idAppointments = new ArrayList<>();
	*/
	@Mapping(value = "doctor")
	private Integer idDoctor;

	@Mapping(value = "room")
	private Integer idRoom;
	
}
