package com.atsistema.formacion.Clinic.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.atsistema.formacion.Clinic.controller.patient.PatientController;
import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.dto.PatientDTO;
import com.atsistema.formacion.Clinic.exception.InvalidDataException;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.service.PatientService;

@RunWith(MockitoJUnitRunner.class)
public class TestPatientController {

	private static final Integer ID = 1;
	private static final Integer IDException = -1;
	private static final Integer PAGE = 0;
	private static final Integer SIZE = 10;
	private static final String NAME = "name";
	private static final String APELLIDO ="lastname";
	private PatientDTO patientDTO = new PatientDTO();
	private PatientDTO patientDTOException = new PatientDTO();
	private AppointmentDTO appointmentDTO = new AppointmentDTO();
	private List<PatientDTO> listDTO = new ArrayList<>();
	private List<AppointmentDTO> listAppointmentDTO = new ArrayList<>();
	
	@Mock
	private PatientService patientService;
	
	@InjectMocks 
	private PatientController patientController = new PatientController();
	
	@Before
	public void initPatient() throws NotFoundException, InvalidDataException {
		patientDTO.setIdPatient(ID);
		patientDTO.setNamePatient(NAME);
		patientDTO.setLastnamePatient(APELLIDO);
		patientDTOException.setIdPatient(IDException);
		patientDTOException.setNamePatient(NAME);
		patientDTOException.setLastnamePatient(APELLIDO);
		appointmentDTO.setIdAppointment(ID);
		listAppointmentDTO.add(appointmentDTO);
		listDTO.add(patientDTO);
		Mockito.when(patientService.findAll(PAGE, SIZE)).thenReturn(listDTO);
		Mockito.when(patientService.findById(ID)).thenReturn(patientDTO);
		Mockito.when(patientService.findById(IDException)).thenThrow(new NotFoundException());
		Mockito.when(patientService.create(patientDTO)).thenReturn(patientDTO);
		Mockito.doNothing().when(patientService).update(patientDTO);
		Mockito.doNothing().when(patientService).delete(ID);
		Mockito.when(patientService.findAppointmentsByIdPatient(ID)).thenReturn(listAppointmentDTO);
	}
	
	@Test
	public void testFindAll(){
		List<PatientDTO> result = patientController.findAll(PAGE, SIZE);
		Assert.assertEquals(result.get(0).getNamePatient(),NAME);
	}
	
	@Test
	public void TestfindOneById() throws NotFoundException{
		PatientDTO result = patientController.findOneById(ID);
		Assert.assertNotNull(result);
		Assert.assertEquals(result.getNamePatient(), NAME);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestfindOneByIdException() throws NotFoundException {
		patientController.findOneById(IDException);
	}
	
	@Test
	public void findAppointments() throws NotFoundException {
		List<AppointmentDTO> result = patientController.findAppointmentsByIdPatient(ID);
		Assert.assertEquals(result.get(0).getIdAppointment(), ID);
	}
	@Test
	public void TestCreate() throws InvalidDataException {
		PatientDTO result = patientController.create(patientDTO);
		Assert.assertNotNull(result);
		Assert.assertEquals(result.getNamePatient(), NAME);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestCreateException() throws InvalidDataException {
		patientController.create(patientDTOException);
	}
	
	@Test
	public void TestUpdate() throws NotFoundException{
		patientController.update(ID,patientDTO);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestUpdateException() throws NotFoundException{
		patientController.update(IDException,patientDTO);
	}
	
	@Test
	public void TestDelete() throws NotFoundException {
		patientController.delete(ID);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestDeleteException() throws NotFoundException {
		patientController.delete(IDException);
	}
}
