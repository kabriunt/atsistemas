package com.atsistema.formacion.Clinic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Patient {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String lastname;

}
