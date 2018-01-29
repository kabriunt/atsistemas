package com.atsistema.formacion.Clinic.controller.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.dto.PatientDTO;
import com.atsistema.formacion.Clinic.exception.InvalidDataException;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.service.PatientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<PatientDTO> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		log.info("Recuperando toda la lista de Pacientes");
		return patientService.findAll(page,size);		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idPatient}")
	public PatientDTO findOneById(@PathVariable Integer idPatient) throws NotFoundException {
		log.info("Recuperando Paciente con Id = " + idPatient);
		return patientService.findById(idPatient);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/name={namePatient}")
	public List<PatientDTO> findByName(@PathVariable String namePatient){
		log.info("Recuperando Clinica con nombre = " + namePatient);
		return patientService.finByName(namePatient);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idPatient}/appointments")
	public List<AppointmentDTO> findAppointmentsByIdPatient(@PathVariable Integer idPatient) {
		log.info("Recuperando Numero de Citas del Paciente con Id = " + idPatient);
		return patientService.findAppointmentsByIdPatient(idPatient);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idPatient}/num")
	public Integer findStringByIdPatient(@PathVariable Integer idPatient) {
		log.info("Recuperando Paciente con Id = " + idPatient);
		return patientService.findAppointmentsByIdPatient(idPatient).size();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public PatientDTO create(@RequestBody PatientDTO p) throws InvalidDataException {
		log.info("Creando Paciente = " + p);
		return patientService.create(p);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{idPatient}")
	public void update(@PathVariable Integer idPatient, @RequestBody PatientDTO p) {
		log.info("Modificando Paciente = " + p);
		patientService.update(p);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idPatient}")
	public void delete(@PathVariable Integer idPatient) throws NotFoundException {
		log.info("Borrando Paciente con Id = " + idPatient);
		patientService.delete(idPatient);
	}
}
