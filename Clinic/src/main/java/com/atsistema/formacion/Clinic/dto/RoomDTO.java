package com.atsistema.formacion.Clinic.dto;

import java.io.Serializable;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class RoomDTO implements Serializable{
	
	private static final long serialVersionUID = 1926613149283931855L;
	
	@Mapping(value = "id")
	private Integer idRoom;
	
	@Mapping(value = "name")
	private String nameRoom;
}
