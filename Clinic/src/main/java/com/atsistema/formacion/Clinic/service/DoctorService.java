package com.atsistema.formacion.Clinic.service;

import java.util.Date;
import java.util.List;

import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.dto.DoctorApiDTO;
import com.atsistema.formacion.Clinic.dto.DoctorDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Consultation;
import com.atsistema.formacion.Clinic.model.Doctor;

public interface DoctorService {
	
	/**
	 * Realiza la busqueda de todos los Doctores existentes (con paginacion)
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<DoctorDTO> findAll(Integer page, Integer size);

	/**
	 * Busca por Id
	 * 
	 * @param idDoctor
	 * @return
	 */
	public DoctorDTO findById(Integer idDoctor) throws NotFoundException;
	
	/**
	 * Busca por Id
	 * 
	 * @param idDoctor
	 * @return
	 * @throws NotFoundException
	 */
	public Doctor findOne(Integer idDoctor) throws NotFoundException;

	
	/**
	 * Busca por Nombre
	 * 
	 * @param name
	 * @return
	 */
	public List<DoctorDTO> findByName(String name);
	
	/**
	 * Recupera todas las Consultas de un Doctor
	 * 
	 * @param idDoctor
	 * @return
	 */
	public List<ConsultationDTO> findConsultationsByIdDoctor(Integer idDoctor);
	
	/**
	 * Recupera los n Doctores con mas Pacientes
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<DoctorDTO> find5OrderByPatientsDesc(Integer page, Integer size);

	/**
	 * Recupera los N Doctores que han realizado consultas entre las fechas dadas
	 * 
	 * @param ini
	 * @param end
	 * @return
	 */
	public List<DoctorDTO> findByDate(Date iniDate, Date endDate);
	
	/**
	 * Devuelve una lista de Doctores con consultas en una fecha dada,
	 * el numero de consultas y sus ganancias
	 * 
	 * @param iniDate
	 * @param endDate
	 * @return
	 */
	public List<DoctorApiDTO> findStatsByDate(Date iniDate, Date endDate);
	
	/**
	 * 
	 * @param c
	 * @param doctors
	 */
	public void FillStats(Consultation c, List<DoctorApiDTO> doctors);
	
	/**
	 * Devuelve el precio de un Doctor
	 * 
	 * @param id
	 * @return
	 */
	public Double getDoctorPrice(String id);

	/**
	 * Crea un Doctor
	 * 
	 * @param d
	 * @return
	 */
	public DoctorDTO create(DoctorDTO d);

	/**
	 * Modifica un Doctor
	 * 
	 * @param d
	 */
	public void update(DoctorDTO d);

	/**
	 * Borra un Doctor
	 * 
	 * @param d
	 */
	public void delete(Integer d) throws NotFoundException;

}
