package com.atsistema.formacion.Clinic.service;

import java.util.List;

import com.atsistema.formacion.Clinic.dto.PatientDTO;
import com.atsistema.formacion.Clinic.model.Patient;

public interface PatientService {

	/**
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<PatientDTO> findAll(Integer page, Integer size);

	/**
	 * 
	 * @param idPatient
	 * @return
	 */
	public PatientDTO findById(Integer idPatient);

	/**
	 * 
	 * @param d
	 * @return
	 */
	public PatientDTO create(PatientDTO d);

	/**
	 * 
	 * @param d
	 */
	public void update(PatientDTO d);

	/**
	 * 
	 * @param idPatient
	 */
	public void delete(Integer idPatient);
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public Patient map(PatientDTO dto);
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public PatientDTO map(Patient p);

}
