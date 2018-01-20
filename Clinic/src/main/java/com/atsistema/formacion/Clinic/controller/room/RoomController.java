package com.atsistema.formacion.Clinic.controller.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atsistema.formacion.Clinic.dto.RoomDTO;
import com.atsistema.formacion.Clinic.service.RoomService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<RoomDTO> findAll(@RequestParam(required=false) Integer page, @RequestParam(required=false) Integer size){
		log.info("Recuperando toda la lista de Habitaciones");
		return roomService.findAll(page,size);		
	}
	
	//poner los log.info(GlobalString)
	@RequestMapping(method = RequestMethod.GET, value = "/{idRoom}")
	public RoomDTO findOneById(@PathVariable Integer idRoom) {
		return roomService.findById(idRoom);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public RoomDTO create(@RequestBody RoomDTO r) {
		return roomService.create(r);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{idRoom}")
	public void update(@PathVariable Integer idRoom, @RequestBody RoomDTO r) {
		roomService.update(r);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idRoom}")
	public void delete(@PathVariable Integer idRoom/*, @RequestBody RoomDTO d*/) {
		roomService.delete(idRoom);
	}

}
