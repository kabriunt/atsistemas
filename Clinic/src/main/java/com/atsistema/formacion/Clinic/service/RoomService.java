package com.atsistema.formacion.Clinic.service;

import java.util.List;

import com.atsistema.formacion.Clinic.dto.RoomDTO;
import com.atsistema.formacion.Clinic.model.Room;

public interface RoomService {

	/**
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<RoomDTO> findAll(Integer page, Integer size);

	/**
	 * 
	 * @param idRoom
	 * @return
	 */
	public RoomDTO findById(Integer idRoom);

	/**
	 * 
	 * @param r
	 * @return
	 */
	public RoomDTO create(RoomDTO r);

	/**
	 * 
	 * @param r
	 */
	public void update(RoomDTO r);

	/**
	 * 
	 * @param idRoom
	 */
	public void delete(Integer idRoom);
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public Room map(RoomDTO dto);
	
	/**
	 * 
	 * @param r
	 * @return
	 */
	public RoomDTO map(Room r);

}
