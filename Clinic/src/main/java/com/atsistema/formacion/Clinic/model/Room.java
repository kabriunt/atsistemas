package com.atsistema.formacion.Clinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Room {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(unique=true)
	private String roomName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Clinic clinic;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="room")
	private List<Consultation> consultations = new ArrayList<>();

}
