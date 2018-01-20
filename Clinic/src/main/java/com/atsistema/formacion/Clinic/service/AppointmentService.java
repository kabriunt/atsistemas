package com.atsistema.formacion.Clinic.service;

import java.util.List;

import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.model.Appointment;

public interface AppointmentService {

	/**
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<AppointmentDTO> findAll(Integer page, Integer size);

	/**
	 * 
	 * @param idAppointment
	 * @return
	 */
	public AppointmentDTO findById(Integer idAppointment);

	/**
	 * 
	 * @param a
	 * @return
	 */
	public AppointmentDTO create(AppointmentDTO a);

	/**
	 * 
	 * @param a
	 */
	public void update(AppointmentDTO a);

	/**
	 * 
	 * @param a
	 */
	public void delete(Integer a);
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public Appointment map(AppointmentDTO dto);
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	public AppointmentDTO map(Appointment a);
}
