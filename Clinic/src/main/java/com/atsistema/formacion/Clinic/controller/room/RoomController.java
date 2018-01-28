package com.atsistema.formacion.Clinic.controller.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.dto.RoomDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.service.RoomService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<RoomDTO> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		log.info("Recuperando toda la lista de Salas");
		return roomService.findAll(page,size);		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{idRoom}")
	public RoomDTO findOneById(@PathVariable Integer idRoom) throws NotFoundException {
		log.info("Recuperando Sala con Id = " + idRoom);
		return roomService.findById(idRoom);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idRoom}/consultations")
	public List<ConsultationDTO> findConsultationsByIdRoom(@PathVariable Integer idRoom) {
		log.info("Recuperando todas las Consultas de la Sala con id = " + idRoom);
		return roomService.findConsultationsByIdRoom(idRoom);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public RoomDTO create(@RequestBody RoomDTO r) {
		log.info("Creando Sala = " + r);
		return roomService.create(r);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{idRoom}")
	public void update(@PathVariable Integer idRoom, @RequestBody RoomDTO r) {
		log.info("Modificando Sala = " + r);
		roomService.update(r);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idRoom}")
	public void delete(@PathVariable Integer idRoom) throws NotFoundException {
		log.info("Borrando Sala con id =" + idRoom);
		roomService.delete(idRoom);
	}
}
