package com.atsistema.formacion.Clinic.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atsistema.formacion.Clinic.model.Doctor;

@Repository
public interface DoctorDao extends PagingAndSortingRepository<Doctor, Integer>{
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Doctor> findByName(String name);
	
	/**
	 * select doctor.id_api, COUNT(DISTINCT appointment.patient_id) as Pacientes 
	 * from doctor 
	 * JOIN consultation ON doctor.id = consultation.doctor_id 
	 * JOIN appointment ON consultation.id = appointment.consultation_id 
	 * GROUP BY doctor.id 
	 * ORDER BY Pacientes DESC;
	 * @param pageRequest 
	 * @return
	 */
	@Query(value = "select d from Doctor as d  "
			+ " INNER JOIN d.consultations as c "
			+ " INNER JOIN c.appointments as a"
			+ " GROUP BY d.id"
			+ " ORDER BY COUNT(DISTINCT a.patient) DESC")
	public List<Doctor> find5ByNameOrderByPatientsDesc(Pageable pageRequest);

	/**
	 * @Query(value = "select d from Doctor as d  "
	 *		+ " INNER JOIN d.consultations as c "
	 *		+ " INNER JOIN c.appointments as a"
	 * 		+ " GROUP BY d.id"
	 *		+ " HAVING c.date BETWEEN :iniDate AND :endDate")
	 * 
	 * @param iniDate
	 * @param endDate
	 * @return
	 */
	@Query(value = "select d from Doctor as d  "
			+ " INNER JOIN d.consultations as c "
			+ " where c.date BETWEEN :iniDate AND :endDate")
	public List<Doctor> findByDate(@Param(value = "iniDate") Date iniDate, @Param(value = "endDate") Date endDate);

	@Query(value="select COUNT(appointment.consultation_id) "
			+ " from doctor "
			+ "	JOIN consultation ON doctor.id = consultation.doctor_id "
			+ "	JOIN appointment ON consultation.id = appointment.consultation_id "
			+ "	GROUP BY doctor.id "
			+ "	HAVING doctor.id = ?1;", nativeQuery=true)
	public Integer findByNumAppointments(@Param(value = "idDoctor") Integer idDoctor);
	
}
