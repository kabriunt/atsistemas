package com.atsistema.formacion.Clinic.controller.appointment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.service.AppointmentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="api/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<AppointmentDTO> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		log.info("Recuperando toda la lista de Citas");
		return appointmentService.findAll(page,size);		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{idAppointment}")
	public AppointmentDTO findOneById(@PathVariable Integer idAppointment) throws NotFoundException {
		return appointmentService.findById(idAppointment);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public AppointmentDTO create(@RequestBody AppointmentDTO a) {
		return appointmentService.create(a);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{idAppointment}")
	public void update(@PathVariable Integer idAppointment, @RequestBody AppointmentDTO a) {
		appointmentService.update(a);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idAppointment}")
	public void delete(@PathVariable Integer idAppointment, @RequestBody AppointmentDTO a) throws NotFoundException {
		appointmentService.delete(idAppointment);
	}
}
