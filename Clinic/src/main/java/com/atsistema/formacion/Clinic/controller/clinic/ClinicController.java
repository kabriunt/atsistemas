package com.atsistema.formacion.Clinic.controller.clinic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atsistema.formacion.Clinic.dto.ClinicDTO;
import com.atsistema.formacion.Clinic.dto.RoomDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.service.ClinicService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/clinic")
public class ClinicController {
	
	@Autowired
	private ClinicService clinicService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ClinicDTO> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		log.info("Recuperando toda la lista de Clinicas");
		return clinicService.findAll(page,size);		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{idClinic}")
	public ClinicDTO findOneById(@PathVariable Integer idClinic) throws NotFoundException {
		return clinicService.findById(idClinic);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ClinicDTO create(@RequestBody ClinicDTO c) {
		return clinicService.create(c);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{idClinic}")
	public void update(@PathVariable Integer idClinic, @RequestBody ClinicDTO c) {
		clinicService.update(c);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idClinic}")
	public void delete(@PathVariable Integer idClinic, @RequestBody ClinicDTO c) throws NotFoundException {
		clinicService.delete(idClinic);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idClinic}/rooms")
	public List<RoomDTO> findRoomById(@PathVariable Integer idClinic) {
		return clinicService.findRoomsByIdClinic(idClinic);
	}
}
