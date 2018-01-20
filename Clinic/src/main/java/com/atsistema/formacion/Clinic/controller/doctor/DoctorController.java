package com.atsistema.formacion.Clinic.controller.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atsistema.formacion.Clinic.dto.DoctorDTO;
import com.atsistema.formacion.Clinic.service.DoctorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<DoctorDTO> findAll(@RequestParam(required=false) Integer page, @RequestParam(required=false) Integer size){
		log.info("Recuperando toda la lista de clinicas");
		return doctorService.findAll(page,size);		
	}
	
	//poner los log.info(GlobalString)
	@RequestMapping(method = RequestMethod.GET, value = "/{idDoctor}")
	public DoctorDTO findOneById(@PathVariable Integer idDoctor) {
		return doctorService.findById(idDoctor);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public DoctorDTO create(@RequestBody DoctorDTO d) {
		return doctorService.create(d);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{idDoctor}")
	public void update(@PathVariable Integer idDoctor, @RequestBody DoctorDTO d) {
		doctorService.update(d);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idDoctor}")
	public void delete(@PathVariable Integer idDoctor/*, @RequestBody DoctorDTO d*/) {
		doctorService.delete(idDoctor);
	}

}
