package com.atsistema.formacion.Clinic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.DoctorDao;
import com.atsistema.formacion.Clinic.dto.DoctorDTO;
import com.atsistema.formacion.Clinic.model.Doctor;
import com.atsistema.formacion.Clinic.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public List<DoctorDTO> findAll(Integer page, Integer size) {
		/*final Iterable<Doctor> findAll = doctorDao.findAll();
		final List<DoctorDTO> res = new ArrayList<>();
		findAll.forEach(d -> {
			final DoctorDTO dDTO = map(d);
			res.add(dDTO);
		});
		return res;*/
		List<Doctor> doctors = (List<Doctor>) doctorDao.findAll();
		return doctors.stream().map(u->map(u)).collect(Collectors.toList());
	}

	@Override
	public DoctorDTO findById(Integer idDoctor) {
		/*final Doctor d = doctorDao.findOne(idDoctor);
		return map(d);*/
		Doctor find = doctorDao.findOne(idDoctor);
		return map(Optional.ofNullable(find).orElseThrow(IllegalStateException::new));
	}

	@Override
	public DoctorDTO create(DoctorDTO d) {
		final Doctor save = doctorDao.save(map(d));
		return map(save);
	}

	@Override
	public void update(DoctorDTO d) {
		final Doctor save = doctorDao.save(map(d));
		map(save);
		
	}

	@Override
	public void delete(Integer d) {
		//doctorDao.delete(map(d));
		doctorDao.delete(d);
		
	}
	
	@Override
	public Doctor map(DoctorDTO dto) {
		return mapper.map(dto, Doctor.class);
	}

	@Override
	public DoctorDTO map(Doctor doctor) {
		return mapper.map(doctor, DoctorDTO.class);
	}

}
