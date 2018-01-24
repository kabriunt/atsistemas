package com.atsistema.formacion.Clinic.service;

import java.util.List;

import com.atsistema.formacion.Clinic.dto.ClinicDTO;
import com.atsistema.formacion.Clinic.dto.RoomDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
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
	 * @param idClinic
	 * @return
	 */
	public ClinicDTO findById(Integer idClinic) throws NotFoundException;
	
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
	public void delete(Integer idClinic) throws NotFoundException;
	
	/**
	 * 
	 * @param idClinic
	 * @return
	 */
	public List<RoomDTO> findRoomsByIdClinic(Integer idClinic);
	
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
	public ClinicDTO map(Clinic c);


}
