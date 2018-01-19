package com.atsistema.formacion.Clinic.service.impl;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.ClinicDao;
import com.atsistema.formacion.Clinic.dto.ClinicDTO;
import com.atsistema.formacion.Clinic.model.Clinic;
import com.atsistema.formacion.Clinic.service.ClinicService;

@Service
public class ClinicServiceImpl implements ClinicService{
	
	@Autowired
	ClinicDao clinicDao;
	
	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public Clinic findById(Integer id) {
		// TODO Auto-generated method stub
		return clinicDao.findOne(id);
		//return Optional
	}

	@Override
	public List<Clinic> findAll(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return clinicDao.findAll(new PageRequest(page, size)).getContent();
		//final List<Clinic> clinics = clinicDao.findAll(new PageRequest(page, size)).getContent();
		//return clinics.Stream().map(u->map(u)).collect(Collectors.toList();
	}

	@Override//ClinicDTO en Clinic, en ambos
	public Clinic create(Clinic c) {
		// TODO Auto-generated method stub
		return clinicDao.save(c);
		//final Clinic save = clinicDao.save(map(c));
		//return map(save);
	}

	@Override
	public void update(Clinic c) {
		clinicDao.save(c);
		
	}

	@Override
	public void delete(Clinic c) {
		clinicDao.delete(c);
		
	}

	@Override
	public Clinic map(ClinicDTO dto) {
		// TODO Auto-generated method stub
		return dozer.map(dto, Clinic.class);
	}

	@Override
	public ClinicDTO map(Clinic clinic) {
		// TODO Auto-generated method stub
		return dozer.map(clinic, ClinicDTO.class);
	}
	
	

}
