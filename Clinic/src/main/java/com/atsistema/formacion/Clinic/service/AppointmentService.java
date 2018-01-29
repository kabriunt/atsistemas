package com.atsistema.formacion.Clinic.service;

import java.util.List;

import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;

public interface AppointmentService {

	/**
	 * Realiza la busqueda de todas las Citas existentes (con paginacion)
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<AppointmentDTO> findAll(Integer page, Integer size);

	/**
	 * Busca por Id
	 * 
	 * @param idAppointment
	 * @return
	 */
	public AppointmentDTO findById(Integer idAppointment) throws NotFoundException;

	/**
	 * Crea una Cita
	 * 
	 * @param a
	 * @return
	 * @throws NotFoundException 
	 */
	public AppointmentDTO create(AppointmentDTO a) throws NotFoundException;

	/**
	 * Modifica una Cita
	 * 
	 * @param a
	 * @throws NotFoundException 
	 */
	public void update(AppointmentDTO a) throws NotFoundException;

	/**
	 * Borra una Cita
	 * 
	 * @param a
	 */
	public void delete(Integer idAppointment) throws NotFoundException;
	
}
