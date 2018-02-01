package com.atsistema.formacion.Clinic.service;

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

public interface MapperService {

	/**
	 * Transforma una CitaDTO en una Cita
	 * 
	 * @param dto
	 * @return
	 * @throws NotFoundException 
	 */
	public Appointment map(AppointmentDTO dto) throws NotFoundException;
	
	/**
	 * Transforma una Cita en una CitaDTO
	 * 
	 * @param a
	 * @return
	 */
	public AppointmentDTO map(Appointment a);
	
	/**
	 * Transforma una ClinicaDTO en una Clinica
	 * 
	 * @param dto
	 * @return
	 */
	public Clinic map(ClinicDTO dto);
	
	/**
	 * Transforma una Clinica en una ClinicaDTO
	 * 
	 * @param clinic
	 * @return
	 */
	public ClinicDTO map(Clinic c);
	
	/**
	 * Transforma una ConsultaDTO en una Consulta
	 * 
	 * @param dto
	 * @return
	 * @throws NotFoundException 
	 */
	public Consultation map(ConsultationDTO dto) throws NotFoundException;
	
	/**
	 * Transforma una Consulta en una ConsultaDTO
	 * 
	 * @param c
	 * @return
	 */
	public ConsultationDTO map(Consultation c);
	
	/**
	 * Transforma un DoctorDTO en un Doctor
	 * 
	 * @param dto
	 * @return
	 */
	public Doctor map(DoctorDTO dto);
	
	/**
	 * Transforma un Doctor en un DoctorDTO
	 * 
	 * @param doctor
	 * @return
	 */
	public DoctorDTO map(Doctor d);
	
	/**
	 * 
	 * @param d
	 * @return
	 */
	//public DoctorDTO map(DoctorApiDTO d);
	
	/**
	 * Transforma un PacienteDTO en un Paciente
	 * 
	 * @param dto
	 * @return
	 */
	public Patient map(PatientDTO dto);
	
	/**
	 * Transforma un Paciente en un PacienteDTO
	 * 
	 * @param p
	 * @return
	 */
	public PatientDTO map(Patient p);
	
	/**
	 * Transforma una SalaDTO en una Sala
	 * 
	 * @param dto
	 * @return
	 */
	public Room map(RoomDTO dto);
	
	/**
	 * Transforma una Sala en una SalaDTO
	 * 
	 * @param r
	 * @return
	 */
	public RoomDTO map(Room r);

}
