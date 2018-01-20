package com.atsistema.formacion.Clinic.controller.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atsistema.formacion.Clinic.dto.PatientDTO;
import com.atsistema.formacion.Clinic.service.PatientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<PatientDTO> findAll(@RequestParam(required=false) Integer page, @RequestParam(required=false) Integer size){
		log.info("Recuperando toda la lista de Pacientes");
		return patientService.findAll(page,size);		
	}
	
	//poner los log.info(GlobalString)
	@RequestMapping(method = RequestMethod.GET, value = "/{idPatient}")
	public PatientDTO findOneById(@PathVariable Integer idPatient) {
		return patientService.findById(idPatient);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public PatientDTO create(@RequestBody PatientDTO d) {
		return patientService.create(d);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{idPatient}")
	public void update(@PathVariable Integer idPatient, @RequestBody PatientDTO d) {
		patientService.update(d);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idPatient}")
	public void delete(@PathVariable Integer idPatient/*, @RequestBody PatientDTO d*/) {
		patientService.delete(idPatient);
	}

}
