package com.atsistema.formacion.Clinic.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Appointment {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Patient patient;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Consultation consultation;
	
	@GeneratedValue//(generator o strategy) Estrategia
	private Integer order;

}
