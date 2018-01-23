package com.atsistema.formacion.Clinic.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

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
	
	@SequenceGenerator(initialValue=1, allocationSize=10, name = "sequence")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequence")
	private Integer order;
}
