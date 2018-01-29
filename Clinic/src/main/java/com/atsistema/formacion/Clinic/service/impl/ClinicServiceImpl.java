package com.atsistema.formacion.Clinic.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.ClinicDao;
import com.atsistema.formacion.Clinic.dto.ClinicDTO;
import com.atsistema.formacion.Clinic.dto.RoomDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Clinic;
import com.atsistema.formacion.Clinic.service.ClinicService;
import com.atsistema.formacion.Clinic.service.MapperService;

@Service
public class ClinicServiceImpl implements ClinicService{
	
	@Autowired
	private ClinicDao clinicDao;
	
	@Autowired
	private MapperService mp;

	@Override
	public List<ClinicDTO> findAll(Integer page, Integer size) {
		List<Clinic> clinics = (List<Clinic>) clinicDao.findAll(new PageRequest(page, size)).getContent();
		return clinics.stream().map(u->mp.map(u)).collect(Collectors.toList());
	}
	
	@Override
	public ClinicDTO findById(Integer idClinic) throws NotFoundException{
		Clinic find = clinicDao.findOne(idClinic);
		return mp.map(Optional.ofNullable(find).orElseThrow(NotFoundException::new));
	}
	
	@Override
	public List<ClinicDTO> findByName(String nameClinic) {
		List<Clinic> clinics = clinicDao.findByName(nameClinic);
		return clinics.stream().map(u->mp.map(u)).collect(Collectors.toList());
	}
	
	@Override
	public List<RoomDTO> findRoomsByIdClinic(Integer idClinic) {
		final Clinic clinic = clinicDao.findOne(idClinic);
		final List<RoomDTO> rooms = new ArrayList<>();
		clinic.getRooms().forEach(a -> rooms.add(mp.map(a)));
		return rooms;
	}

	@Override
	public ClinicDTO create(ClinicDTO c) {
		final Clinic clinic = clinicDao.save(mp.map(c));
		return mp.map(clinic);
	}

	@Override
	public void update(ClinicDTO c) {
		final Clinic clinic = clinicDao.save(mp.map(c));
		mp.map(clinic);
	}

	@Override
	public void delete(Integer idClinic) throws NotFoundException{
		clinicDao.delete(idClinic);
	}
}
