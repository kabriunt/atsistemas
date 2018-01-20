package com.atsistema.formacion.Clinic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.RoomDao;
import com.atsistema.formacion.Clinic.dto.RoomDTO;
import com.atsistema.formacion.Clinic.model.Room;
import com.atsistema.formacion.Clinic.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public List<RoomDTO> findAll(Integer page, Integer size) {
		List<Room> Rooms = (List<Room>) roomDao.findAll();
		return Rooms.stream().map(u->map(u)).collect(Collectors.toList());
	}

	@Override
	public RoomDTO findById(Integer idRoom) {
		Room find = roomDao.findOne(idRoom);
		return map(Optional.ofNullable(find).orElseThrow(IllegalStateException::new));
	}

	@Override
	public RoomDTO create(RoomDTO r) {
		final Room save = roomDao.save(map(r));
		return map(save);
	}

	@Override
	public void update(RoomDTO r) {
		final Room save = roomDao.save(map(r));
		map(save);		
	}

	@Override
	public void delete(Integer idRoom) {
		roomDao.delete(idRoom);
		
	}

	@Override
	public Room map(RoomDTO dto) {
		return mapper.map(dto, Room.class);
	}

	@Override
	public RoomDTO map(Room r) {
		return mapper.map(r, RoomDTO.class);
	}

}
