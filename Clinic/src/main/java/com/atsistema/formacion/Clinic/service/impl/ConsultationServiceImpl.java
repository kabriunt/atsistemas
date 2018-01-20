package com.atsistema.formacion.Clinic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.ConsultationDao;
import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.model.Consultation;
import com.atsistema.formacion.Clinic.service.ConsultationService;

@Service
public class ConsultationServiceImpl implements ConsultationService{

	@Autowired
	private ConsultationDao consultationDao;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public List<ConsultationDTO> findAll(Integer page, Integer size) {
		List<Consultation> consultations = (List<Consultation>) consultationDao.findAll();
		return consultations.stream().map(u->map(u)).collect(Collectors.toList());
	}

	@Override
	public ConsultationDTO findById(Integer idConsultation) {
		Consultation find = consultationDao.findOne(idConsultation);
		return map(Optional.ofNullable(find).orElseThrow(IllegalStateException::new));
	}

	@Override
	public ConsultationDTO create(ConsultationDTO c) {
		final Consultation save = consultationDao.save(map(c));
		return map(save);
	}

	@Override
	public void update(ConsultationDTO c) {
		final Consultation save = consultationDao.save(map(c));
		map(save);
		
	}

	@Override
	public void delete(Integer idConsultation) {
		consultationDao.delete(idConsultation);
		
	}

	@Override
	public Consultation map(ConsultationDTO dto) {
		return mapper.map(dto, Consultation.class);
	}

	@Override
	public ConsultationDTO map(Consultation c) {
		return mapper.map(c, ConsultationDTO.class);
	}

	
}
