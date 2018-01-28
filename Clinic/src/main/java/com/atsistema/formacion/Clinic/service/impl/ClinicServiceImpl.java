package com.atsistema.formacion.Clinic.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.ClinicDao;
import com.atsistema.formacion.Clinic.dto.ClinicDTO;
import com.atsistema.formacion.Clinic.dto.RoomDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Clinic;
import com.atsistema.formacion.Clinic.service.ClinicService;
import com.atsistema.formacion.Clinic.service.RoomService;

@Service
public class ClinicServiceImpl implements ClinicService{
	
	@Autowired
	private ClinicDao clinicDao;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public List<ClinicDTO> findAll(Integer page, Integer size) {
		List<Clinic> clinics = (List<Clinic>) clinicDao.findAll(new PageRequest(page, size)).getContent();
		return clinics.stream().map(u->map(u)).collect(Collectors.toList());
	}
	
	@Override
	public ClinicDTO findById(Integer idClinic) throws NotFoundException{
		Clinic find = clinicDao.findOne(idClinic);
		return map(Optional.ofNullable(find).orElseThrow(NotFoundException::new));
	}
	
	@Override
	public List<ClinicDTO> finByName(String nameClinic) {
		List<Clinic> clinics = clinicDao.findByName(nameClinic);
		return clinics.stream().map(u->map(u)).collect(Collectors.toList());
	}
	
	@Override
	public List<RoomDTO> findRoomsByIdClinic(Integer idClinic) {
		final Clinic clinic = clinicDao.findOne(idClinic);
		final List<RoomDTO> rooms = new ArrayList<>();
		clinic.getRooms().forEach(a -> rooms.add(roomService.map(a)));
		return rooms;
	}

	@Override
	public ClinicDTO create(ClinicDTO c) {
		final Clinic clinic = clinicDao.save(map(c));
		return map(clinic);
	}

	@Override
	public void update(ClinicDTO c) {
		final Clinic clinic = clinicDao.save(map(c));
		map(clinic);
	}

	@Override
	public void delete(Integer idClinic) throws NotFoundException{
		clinicDao.delete(idClinic);
	}

	@Override
	public Clinic map(ClinicDTO dto) {
		return mapper.map(dto, Clinic.class);
	}

	@Override
	public ClinicDTO map(Clinic c) {
		return mapper.map(c, ClinicDTO.class);
	}
}
