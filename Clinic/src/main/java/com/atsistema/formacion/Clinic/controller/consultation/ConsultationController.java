package com.atsistema.formacion.Clinic.controller.consultation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.service.ConsultationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="api/consultation")
public class ConsultationController {
	
	@Autowired
	private ConsultationService consultationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ConsultationDTO> findAll(@RequestParam(required=false) Integer page, @RequestParam(required=false) Integer size){
		log.info("Recuperando toda la lista de consultas");
		return consultationService.findAll(page,size);		
	}
	
	//poner los log.info(GlobalString)
	@RequestMapping(method = RequestMethod.GET, value = "/{idConsultation}")
	public ConsultationDTO findOneById(@PathVariable Integer idConsultation) {
		return consultationService.findById(idConsultation);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ConsultationDTO create(@RequestBody ConsultationDTO a) {
		return consultationService.create(a);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{idConsultation}")
	public void update(@PathVariable Integer idConsultation, @RequestBody ConsultationDTO a) {
		consultationService.update(a);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idconsultation}")
	public void delete(@PathVariable Integer idConsultation, @RequestBody ConsultationDTO a) {
		consultationService.delete(idConsultation);
	}

}
