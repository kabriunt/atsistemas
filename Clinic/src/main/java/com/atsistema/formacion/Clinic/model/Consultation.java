package com.atsistema.formacion.Clinic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Consultation {

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy= "consultation")
	private List<Appointment> appointments = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Doctor doctor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Room room;
	
	@Temporal(value=TemporalType.DATE)
	private Date date;
	
	@Enumerated(EnumType.STRING)
	private Turn turn;
	/*
	@Embedded
	@Column(unique=true)
	private CodeConsultation Code; MIRAR COMO HACER EL CODIGO, (CON OTRA CLASE O AQUI MISMO)
	*/
	//FALTA INDICE UNICO DE LOS CUATRO CAMPOS PRINCIPALES
}
