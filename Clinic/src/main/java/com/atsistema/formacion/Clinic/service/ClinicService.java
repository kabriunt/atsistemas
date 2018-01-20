package com.atsistema.formacion.Clinic.service;

import java.util.List;

import com.atsistema.formacion.Clinic.dto.ClinicDTO;
import com.atsistema.formacion.Clinic.model.Clinic;

public interface ClinicService {
	
	/**
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<ClinicDTO> findAll(Integer page, Integer size);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ClinicDTO findById(Integer id);
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public ClinicDTO create(ClinicDTO c);
	
	/**
	 * 
	 * @param c
	 */
	public void update(ClinicDTO c);

	/**
	 * 
	 * @param c
	 */
	public void delete(ClinicDTO c);
	
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
