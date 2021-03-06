package com.atsistema.formacion.Clinic.service;

import java.util.Date;
import java.util.List;

import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Consultation;

public interface ConsultationService {

	/**
	 * Realiza la busqueda de todas las Consultas existentes (con paginacion)
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<ConsultationDTO> findAll(Integer page, Integer size);

	/**
	 * Busca por Id
	 * 
	 * @param idConsultation
	 * @return
	 */
	public ConsultationDTO findById(Integer idConsultation) throws NotFoundException;
	
	/**
	 * Busca por Id
	 * 
	 * @param idConsultation
	 * @return
	 * @throws NotFoundException 
	 */
	public Consultation findOne(Integer idConsultation) throws NotFoundException;
	
	/**
	 * Recupera todas las Citas de una Consulta
	 * 
	 * @param idConsultation
	 * @return
	 */
	public List<AppointmentDTO> findAppointmentsByIdConsultation(Integer idConsultation);
	
	/**
	 * Recupera Consultas entre dos fechas
	 * 
	 * @param iniDate
	 * @param endDate
	 * @return
	 */
	public List<Consultation> findByDate(Date iniDate, Date endDate);

	/**
	 * Crea una Consulta
	 * 
	 * @param a
	 * @return
	 * @throws NotFoundException 
	 */
	public ConsultationDTO create(ConsultationDTO c) throws NotFoundException;

	/**
	 * Modificar una Consulta
	 * 
	 * @param a
	 * @throws NotFoundException 
	 */
	public void update(ConsultationDTO c) throws NotFoundException;

	/**
	 * Borrar una Consulta
	 * 
	 * @param idConsultation
	 */
	public void delete(Integer idConsultation) throws NotFoundException;

}
