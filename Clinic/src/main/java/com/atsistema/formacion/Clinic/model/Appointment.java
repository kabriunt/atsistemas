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
	/*
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order_generator")
	@SequenceGenerator(name="order_generator", sequenceName = "order_seq", allocationSize=10)
	private Integer order;
	*/
}
