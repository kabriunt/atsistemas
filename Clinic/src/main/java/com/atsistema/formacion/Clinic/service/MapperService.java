package com.atsistema.formacion.Clinic.service;

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

public interface MapperService {

	/**
	 * 
	 * @param dto
	 * @return
	 */
	public Appointment map(AppointmentDTO dto);
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	public AppointmentDTO map(Appointment a);
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public Clinic map(ClinicDTO dto);
	
	/**
	 * 
	 * @param clinic
	 * @return
	 */
	public ClinicDTO map(Clinic c);
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public Consultation map(ConsultationDTO dto);
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public ConsultationDTO map(Consultation c);
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public Doctor map(DoctorDTO dto);
	
	/**
	 * 
	 * @param doctor
	 * @return
	 */
	public DoctorDTO map(Doctor d);
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public Patient map(PatientDTO dto);
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public PatientDTO map(Patient p);
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public Room map(RoomDTO dto);
	
	/**
	 * 
	 * @param r
	 * @return
	 */
	public RoomDTO map(Room r);
}
