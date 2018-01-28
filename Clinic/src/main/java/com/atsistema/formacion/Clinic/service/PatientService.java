package com.atsistema.formacion.Clinic.service;

import java.util.List;

import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.dto.PatientDTO;
import com.atsistema.formacion.Clinic.exception.InvalidDataException;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Patient;

public interface PatientService {

	/**
	 * Realiza la busqueda de todos los Doctores existentes (con paginacion)
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<PatientDTO> findAll(Integer page, Integer size);

	/**
	 * Busca por Id
	 * 
	 * @param idPatient
	 * @return
	 */
	public PatientDTO findById(Integer idPatient) throws NotFoundException;
	
	/**
	 * Busca por Id
	 * @param idPatient
	 * @return
	 * @throws NotFoundException 
	 */
	public Patient findOne(Integer idPatient) throws NotFoundException;
	
	/**
	 * Recupera todas la Citas de un Paciente
	 * 
	 * @param idPatient
	 * @return
	 */
	public List<AppointmentDTO> findAppointmentsByIdPatient(Integer idPatient);

	/**
	 * Crea un Paciente
	 * 
	 * @param d
	 * @return
	 * @throws InvalidDataException 
	 */
	public PatientDTO create(PatientDTO p) throws InvalidDataException;

	/**
	 * Modifica un Paciente
	 * 
	 * @param d
	 */
	public void update(PatientDTO p);

	/**
	 * Borra un Paciente
	 * 
	 * @param idPatient
	 */
	public void delete(Integer idPatient) throws NotFoundException;
	
	/**
	 * Transforma un PacienteDTO en un Paciente
	 * 
	 * @param dto
	 * @return
	 */
	public Patient map(PatientDTO dto);
	
	/**
	 * Transforma un Paciente en un PacienteDTO
	 * 
	 * @param p
	 * @return
	 */
	public PatientDTO map(Patient p);

}
