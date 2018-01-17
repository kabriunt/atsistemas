package com.atsistema.formacion.Clinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="patient")
	private List<Appointment> appointements = new ArrayList<>();


}
