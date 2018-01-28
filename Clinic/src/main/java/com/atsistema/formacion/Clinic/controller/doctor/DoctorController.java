package com.atsistema.formacion.Clinic.controller.doctor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.dto.DoctorApiDTO;
import com.atsistema.formacion.Clinic.dto.DoctorDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.service.DoctorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<DoctorDTO> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		log.info("Recuperando toda la lista de Doctores");
		return doctorService.findAll(page,size);		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{idDoctor}")
	public DoctorDTO findOneById(@PathVariable Integer idDoctor) throws NotFoundException {
		log.info("Recuperando Doctor con Id = " + idDoctor);
		return doctorService.findById(idDoctor);
	}
	
	@RequestMapping(value = "/name={name}", method = { RequestMethod.GET })
	public List<DoctorDTO> findByName(@PathVariable String name) {
		return doctorService.findByName(name);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idDoctor}/consultations")
	public List<ConsultationDTO> findConsultationsByIdDoctor(@PathVariable Integer idDoctor) {
		log.info("Recuperando todas las Consultas del Doctor con id = " + idDoctor);
		return doctorService.findConsultationsByIdDoctor(idDoctor);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/rest")
	public List<DoctorDTO> findAPI(){
		log.info("Recuperando toda la lista de Doctores REST");
		List<DoctorDTO> resultado = restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor?size=20", List.class);
		return resultado.stream().collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/ranking")
	public List<DoctorDTO> find5ByNameOrderByPatientsDesc(){
		log.info("Recuperando lista de Doctores con más Pacientes");
		return doctorService.find5ByNameOrderByPatientsDesc();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/stats")
	public List<DoctorApiDTO> findByDate(@RequestParam(required=false, defaultValue="2018-01-01") String ini, @RequestParam(required=false, defaultValue="2018-12-31") String end) throws ParseException {
		log.info("Recuperando lista de Doctores con número de Citas y Beneficios en intervalo de Fechas");
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date iniDate = formato.parse(ini);
        Date endDate = formato.parse(end);
        final List<DoctorApiDTO> doctors = doctorService.findByDate(iniDate,endDate);
		return doctors;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public DoctorDTO create(@RequestBody DoctorDTO d) {
		log.info("Creando Doctor = " + d);
		return doctorService.create(d);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{idDoctor}")
	public void update(@PathVariable Integer idDoctor, @RequestBody DoctorDTO d) {
		log.info("Modificando Doctor = " + d);
		doctorService.update(d);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idDoctor}")
	public void delete(@PathVariable Integer idDoctor) throws NotFoundException {
		log.info("Borrando Doctor con Id = " + idDoctor);
		doctorService.delete(idDoctor);
	}	
}
