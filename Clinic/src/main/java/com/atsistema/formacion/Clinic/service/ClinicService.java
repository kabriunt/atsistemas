package com.atsistema.formacion.Clinic.service;

import java.util.List;

import com.atsistema.formacion.Clinic.dto.ClinicDTO;
import com.atsistema.formacion.Clinic.dto.RoomDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Clinic;

public interface ClinicService {
	
	/**
	 * Realiza la busqueda de todas las Clinicas existentes (con paginacion)
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<ClinicDTO> findAll(Integer page, Integer size);
	
	/**
	 * Busca por Id
	 * 
	 * @param idClinic
	 * @return
	 */
	public ClinicDTO findById(Integer idClinic) throws NotFoundException;
	
	/**
	 * Busca por Nombre
	 * 
	 * @param nameRoom
	 * @return
	 */
	public List<ClinicDTO> finByName(String nameRoom);
	
	/**
	 * Recupera todas las Salas de una Clinica 
	 * 
	 * @param idClinic
	 * @return
	 */
	public List<RoomDTO> findRoomsByIdClinic(Integer idClinic);
	
	/**
	 * Crea una Clinica
	 * 
	 * @param c
	 * @return
	 */
	public ClinicDTO create(ClinicDTO c);
	
	/**
	 * Modifica una Clinica
	 * 
	 * @param c
	 */
	public void update(ClinicDTO c);

	/**
	 * Borra una Clinica
	 * 
	 * @param c
	 */
	public void delete(Integer idClinic) throws NotFoundException;
	
	/**
	 * Transforma una ClinicaDTO en una Clinica
	 * 
	 * @param dto
	 * @return
	 */
	public Clinic map(ClinicDTO dto);
	
	/**
	 * Transforma una Clinica en una ClinicaDTO
	 * 
	 * @param clinic
	 * @return
	 */
	public ClinicDTO map(Clinic c);

}
