package com.atsistema.formacion.Clinic.controller.consultation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.service.ConsultationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="api/consultation")
public class ConsultationController {
	
	@Autowired
	private ConsultationService consultationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ConsultationDTO> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		log.info("Recuperando toda la lista de Consultas");
		return consultationService.findAll(page,size);		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{idConsultation}")
	public ConsultationDTO findOneById(@PathVariable Integer idConsultation) throws NotFoundException {
		log.info("Recuperando Consulta con Id = " + idConsultation);
		return consultationService.findById(idConsultation);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idConsultation}/appointments")
	public List<AppointmentDTO> findAppointmentsByIdConsultation(@PathVariable Integer idConsultation) {
		log.info("Recuperando todas las Citas de la Consulta con id = " + idConsultation);
		return consultationService.findAppointmentsByIdConsultation(idConsultation);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ConsultationDTO create(@RequestBody ConsultationDTO c) throws NotFoundException {
		log.info("Creando Consulta = " + c);
		return consultationService.create(c);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{idConsultation}")
	public void update(@PathVariable Integer idConsultation, @RequestBody ConsultationDTO c) throws NotFoundException {
		log.info("Modificando Consulta = " + c);
		consultationService.update(c);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idConsultation}")
	public void delete(@PathVariable Integer idConsultation) throws NotFoundException {
		log.info("Borrando Consulta con Id = " + idConsultation);
		consultationService.delete(idConsultation);
	}
}
