package com.atsistema.formacion.Clinic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.ClinicDao;
import com.atsistema.formacion.Clinic.dto.ClinicDTO;
import com.atsistema.formacion.Clinic.model.Clinic;
import com.atsistema.formacion.Clinic.service.ClinicService;

@Service
public class ClinicServiceImpl implements ClinicService{
	
	@Autowired
	private ClinicDao clinicDao;
	
	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public List<ClinicDTO> findAll(Integer page, Integer size) {
		/*
		final Iterable<Clinic> findAll = clinicDao.findAll();
		final List<ClinicDTO> res = new ArrayList<>();
		findAll.forEach(c -> {
			final ClinicDTO cDTO = map(c);
			res.add(cDTO);
		});
		return res;
		*/
		List<Clinic> clinics = (List<Clinic>) clinicDao.findAll();
		return clinics.stream().map(u->map(u)).collect(Collectors.toList());
		//return (List<Clinic>) clinicDao.findAll();
		//final List<Clinic> clinics = clinicDao.findAll(new PageRequest(page, size)).getContent();
		//return clinics.stream().map(u->map(u)).collect(Collectors.toList());
	}
	
	@Override
	public ClinicDTO findById(Integer id){
		//final Clinic d = clinicDao.findOne(id);
		//return map(d);
		//return clinicDao.findOne(id);
		Clinic find = clinicDao.findOne(id);
		return map(Optional.ofNullable(find).orElseThrow(IllegalStateException::new));
	}

	@Override//ClinicDTO en Clinic, en ambos
	public ClinicDTO create(ClinicDTO c) {
		//return clinicDao.save(c);
		final Clinic save = clinicDao.save(map(c));
		return map(save);
	}

	@Override
	public void update(ClinicDTO c) {
		//clinicDao.save(c);
		
		final Clinic clinic = map(c);
		clinicDao.save(clinic);
		
		//final Clinic save = clinicDao.save(map(c));
		//map(save);
	}

	@Override
	public void delete(ClinicDTO c) {
		//clinicDao.delete(c);
		clinicDao.delete(map(c));
	}

	@Override
	public Clinic map(ClinicDTO dto) {
		return mapper.map(dto, Clinic.class);
	}

	@Override
	public ClinicDTO map(Clinic clinic) {
		return mapper.map(clinic, ClinicDTO.class);
	}

	

}
