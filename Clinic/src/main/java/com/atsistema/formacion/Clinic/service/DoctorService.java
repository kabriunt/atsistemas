package com.atsistema.formacion.Clinic.service;

import java.util.List;

import com.atsistema.formacion.Clinic.dto.DoctorDTO;
import com.atsistema.formacion.Clinic.model.Doctor;

public interface DoctorService {
	
	/**
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<DoctorDTO> findAll(Integer page, Integer size);

	/**
	 * 
	 * @param idDoctor
	 * @return
	 */
	public DoctorDTO findById(Integer idDoctor);

	/**
	 * 
	 * @param d
	 * @return
	 */
	public DoctorDTO create(DoctorDTO d);

	/**
	 * 
	 * @param d
	 */
	public void update(DoctorDTO d);

	/**
	 * 
	 * @param d
	 */
	public void delete(Integer d);
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public Doctor map(DoctorDTO dto);
	
	/**
	 * 
	 * @param doctor
	 * @return
	 */
	public DoctorDTO map(Doctor doctor);

}
