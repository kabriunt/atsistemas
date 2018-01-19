package com.atsistema.formacion.Clinic.service;

import java.util.List;

import com.atsistema.formacion.Clinic.dto.ClinicDTO;
import com.atsistema.formacion.Clinic.model.Clinic;

public interface ClinicService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Clinic findById(Integer id);
	
	/**
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Clinic> findAll(Integer page, Integer size);
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public Clinic create(Clinic c);
	
	/**
	 * 
	 * @param c
	 */
	public void update(Clinic c);

	/**
	 * 
	 * @param c
	 */
	public void delete(Clinic c);
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public Clinic map(ClinicDTO dto);
	
	/**
	 * 
	 * @param clinic
	 * @return
	 */
	public ClinicDTO map(Clinic clinic);


}
