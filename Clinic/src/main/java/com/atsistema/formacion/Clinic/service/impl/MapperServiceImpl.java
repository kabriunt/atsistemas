package com.atsistema.formacion.Clinic.service.impl;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistema.formacion.Clinic.dao.AppointmentDao;
import com.atsistema.formacion.Clinic.dao.ConsultationDao;
import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.dto.ClinicDTO;
import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.dto.DoctorDTO;
import com.atsistema.formacion.Clinic.dto.PatientDTO;
import com.atsistema.formacion.Clinic.dto.RoomDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Appointment;
import com.atsistema.formacion.Clinic.model.Clinic;
import com.atsistema.formacion.Clinic.model.Consultation;
import com.atsistema.formacion.Clinic.model.Doctor;
import com.atsistema.formacion.Clinic.model.Patient;
import com.atsistema.formacion.Clinic.model.Room;
import com.atsistema.formacion.Clinic.service.ConsultationService;
import com.atsistema.formacion.Clinic.service.DoctorService;
import com.atsistema.formacion.Clinic.service.MapperService;
import com.atsistema.formacion.Clinic.service.PatientService;
import com.atsistema.formacion.Clinic.service.RoomService;

@Service
public class MapperServiceImpl implements MapperService{

	@Autowired
	private DozerBeanMapper mapper;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private ConsultationService consultationService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private ConsultationDao consultationDao;
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Override
	public Appointment map(AppointmentDTO dto) throws NotFoundException {
		final Appointment appointment;
		final Consultation consultation = consultationService.findOne(dto.getIdConsultation());
		final Patient patient = patientService.findOne(dto.getIdPatient());
		
		if (dto.getIdAppointment() != null && appointmentDao.exists(dto.getIdAppointment())) {
			appointment = appointmentDao.findOne(dto.getIdAppointment());			
		} else {
			appointment = new Appointment();
		}
		appointment.setConsultation(consultation);
		appointment.setPatient(patient);
		return appointment;
	}

	@Override
	public AppointmentDTO map(Appointment a) {
		final AppointmentDTO dto = new AppointmentDTO();
		dto.setIdAppointment(a.getId());
		dto.setIdConsultation(a.getConsultation().getId());
		dto.setIdPatient(a.getPatient().getId());
		return dto;
	}	

	@Override
	public Clinic map(ClinicDTO dto) {
		return mapper.map(dto, Clinic.class);
	}

	@Override
	public ClinicDTO map(Clinic c) {
		return mapper.map(c, ClinicDTO.class);
	}

	@Override
	public Consultation map(ConsultationDTO dto) throws NotFoundException {
		final Consultation consultation;
		final Doctor doctor = doctorService.findOne(dto.getIdDoctor());
		final Room room = roomService.findOne(dto.getIdRoom());
		
		if (dto.getIdConsultation()!=null && consultationDao.exists(dto.getIdConsultation())) {
			consultation = consultationDao.findOne(dto.getIdConsultation());			
		} else {
			consultation = new Consultation();
		}
		consultation.setId(dto.getIdConsultation());
		consultation.setTurn(dto.getTurn());
		consultation.setDate(dto.getDate());
		consultation.setDoctor(doctor);
		consultation.setRoom(room);		
		return consultation;
	}

	@Override
	public ConsultationDTO map(Consultation c) {
		final ConsultationDTO dto =new ConsultationDTO();
		dto.setIdConsultation(c.getId());
		dto.setTurn(c.getTurn());
		dto.setDate(c.getDate());
		dto.setIdRoom(c.getRoom().getId());
		dto.setIdDoctor(c.getDoctor().getId());
		return dto;
	}

	@Override
	public Doctor map(DoctorDTO dto) {
		final Doctor doctor = new Doctor();
		doctor.setId(dto.getIdDoctor());
		doctor.setIdApi(dto.getIdApi());
		doctor.setName(dto.getNameDoctor());
		doctor.setLastname(dto.getLastnameDoctor());
		return doctor;
	}

	@Override
	public DoctorDTO map(Doctor d) {
		final DoctorDTO doctor = new DoctorDTO();
		doctor.setIdDoctor(d.getId());
		doctor.setNameDoctor(d.getName());
		doctor.setLastnameDoctor(d.getLastname());
		if(d.getIdApi()!=null) {
			doctor.setIdApi(d.getIdApi());
			doctor.setPrice(doctorService.getDoctorPrice(d.getIdApi()));
		}
		return doctor;
	}

	@Override
	public Patient map(PatientDTO dto) {
		return mapper.map(dto, Patient.class);
	}

	@Override
	public PatientDTO map(Patient p) {
		return mapper.map(p, PatientDTO.class);
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
