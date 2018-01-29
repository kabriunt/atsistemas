package com.atsistema.formacion.Clinic.service;

import java.util.List;

import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.dto.RoomDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Room;

public interface RoomService {

	/**
	 * Realiza la busqueda de todos los Doctores existentes (con paginacion)
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<RoomDTO> findAll(Integer page, Integer size);

	/**
	 * Busca por Id
	 * 
	 * @param idRoom
	 * @return
	 */
	public RoomDTO findById(Integer idRoom) throws NotFoundException;

	/**
	 * Busca por Id
	 * 
	 * @param idRoom
	 * @return
	 * @throws NotFoundException 
	 */
	public Room findOne(Integer idRoom) throws NotFoundException;
	
	/**
	 * Recupera todas las Consultas de un Sala
	 * 	
	 * @param idRoom
	 * @return
	 */
	public List<ConsultationDTO> findConsultationsByIdRoom(Integer idRoom);

	/**
	 * Crea una Sala
	 * 
	 * @param r
	 * @return
	 */
	public RoomDTO create(RoomDTO r);

	/**
	 * Modifica una Sala
	 * 
	 * @param r
	 */
	public void update(RoomDTO r);

	/**
	 * Borra una Sala
	 * 
	 * @param idRoom
	 */
	public void delete(Integer idRoom) throws NotFoundException;
}
