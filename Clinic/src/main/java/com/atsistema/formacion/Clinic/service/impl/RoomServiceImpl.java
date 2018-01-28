package com.atsistema.formacion.Clinic.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.RoomDao;
import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.dto.RoomDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Room;
import com.atsistema.formacion.Clinic.service.ConsultationService;
import com.atsistema.formacion.Clinic.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private ConsultationService consultationService;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public List<RoomDTO> findAll(Integer page, Integer size) {
		List<Room> Rooms = (List<Room>) roomDao.findAll(new PageRequest(page, size)).getContent();
		return Rooms.stream().map(u->map(u)).collect(Collectors.toList());
	}

	@Override
	public RoomDTO findById(Integer idRoom) throws NotFoundException {
		Room find = roomDao.findOne(idRoom);
		return map(Optional.ofNullable(find).orElseThrow(NotFoundException::new));
	}
	

	@Override
	public Room findOne(Integer idRoom) throws NotFoundException {
		Room find = roomDao.findOne(idRoom);
		return Optional.ofNullable(find).orElseThrow(NotFoundException::new);
	}
		
	@Override
	public List<ConsultationDTO> findConsultationsByIdRoom(Integer idRoom) {
		final Room room = roomDao.findOne(idRoom);
		final List<ConsultationDTO> consultations = new ArrayList<>();
		room.getConsultations().forEach(a -> consultations.add(consultationService.map(a)));
		return consultations;
	}

	@Override
	public RoomDTO create(RoomDTO r) {
		final Room room = roomDao.save(map(r));
		return map(room);
	}

	@Override
	public void update(RoomDTO r) {
		final Room room = roomDao.save(map(r));
		map(room);		
	}

	@Override
	public void delete(Integer idRoom) throws NotFoundException{
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
