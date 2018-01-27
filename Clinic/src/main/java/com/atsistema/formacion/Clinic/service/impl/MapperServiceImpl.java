package com.atsistema.formacion.Clinic.service.impl;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.dto.ClinicDTO;
import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.dto.DoctorDTO;
import com.atsistema.formacion.Clinic.dto.PatientDTO;
import com.atsistema.formacion.Clinic.dto.RoomDTO;
import com.atsistema.formacion.Clinic.model.Appointment;
import com.atsistema.formacion.Clinic.model.Clinic;
import com.atsistema.formacion.Clinic.model.Consultation;
import com.atsistema.formacion.Clinic.model.Doctor;
import com.atsistema.formacion.Clinic.model.Patient;
import com.atsistema.formacion.Clinic.model.Room;
import com.atsistema.formacion.Clinic.service.MapperService;

@Service
public class MapperServiceImpl implements MapperService{

	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public Appointment map(AppointmentDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppointmentDTO map(Appointment a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clinic map(ClinicDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClinicDTO map(Clinic c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consultation map(ConsultationDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConsultationDTO map(Consultation c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor map(DoctorDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorDTO map(Doctor d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient map(PatientDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientDTO map(Patient p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room map(RoomDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomDTO map(Room r) {
		// TODO Auto-generated method stub
		return null;
	}

}
