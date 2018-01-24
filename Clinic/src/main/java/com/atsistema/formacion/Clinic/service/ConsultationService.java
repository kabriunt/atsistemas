package com.atsistema.formacion.Clinic.service;

import java.util.List;

import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Consultation;

public interface ConsultationService {

	/**
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<ConsultationDTO> findAll(Integer page, Integer size);

	/**
	 * 
	 * @param idConsultation
	 * @return
	 */
	public ConsultationDTO findById(Integer idConsultation) throws NotFoundException;

	/**
	 * 
	 * @param a
	 * @return
	 */
	public ConsultationDTO create(ConsultationDTO c);

	/**
	 * 
	 * @param a
	 */
	public void update(ConsultationDTO c);

	/**
	 * 
	 * @param idConsultation
	 */
	public void delete(Integer idConsultation) throws NotFoundException;
	
	/**
	 * 
	 * @param idConsultation
	 * @return
	 */
	public List<AppointmentDTO> findAppointmentsByIdConsultation(Integer idConsultation);

	/**
	 * 
	 * @param dto
	 * @return
	 */
	public Consultation map(ConsultationDTO dto);
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public ConsultationDTO map(Consultation c);

}
