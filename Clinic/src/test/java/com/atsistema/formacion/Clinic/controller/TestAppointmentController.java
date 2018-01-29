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

import com.atsistema.formacion.Clinic.controller.appointment.AppointmentController;
import com.atsistema.formacion.Clinic.dto.AppointmentDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.service.AppointmentService;

@RunWith(MockitoJUnitRunner.class)
public class TestAppointmentController {

	private static final Integer ID = 1;
	private static final Integer IDEXCEPTION = 999;
	private static final Integer PAGE = 0;
	private static final Integer SIZE = 10;
	private AppointmentDTO appointmentDTO = new AppointmentDTO();
	private AppointmentDTO appointmentDTOException = new AppointmentDTO();
	private List<AppointmentDTO> listDTO = new ArrayList<>();
	
	@Mock
	private AppointmentService appointmentService;
	
	@InjectMocks 
	private AppointmentController appointmentController = new AppointmentController();
	
	@Before
	public void init() throws NotFoundException {
		appointmentDTO.setIdAppointment(ID);
		appointmentDTO.setIdPatient(ID);
		appointmentDTO.setIdConsultation(ID);
		
		appointmentDTOException.setIdAppointment(ID);
		appointmentDTOException.setIdPatient(IDEXCEPTION);
		
		listDTO.add(appointmentDTO);
		Mockito.when(appointmentService.findAll(PAGE, SIZE)).thenReturn(listDTO);
		Mockito.when(appointmentService.findById(ID)).thenReturn(appointmentDTO);
		Mockito.when(appointmentService.findById(IDEXCEPTION)).thenThrow(new NotFoundException());
		Mockito.when(appointmentService.create(appointmentDTO)).thenReturn(appointmentDTO);
		Mockito.when(appointmentService.create(appointmentDTOException)).thenThrow(new NotFoundException());
		Mockito.doNothing().when(appointmentService).update(appointmentDTO);
		Mockito.doNothing().when(appointmentService).delete(ID);
	}
	
	@Test
	public void testFindAll(){
		List<AppointmentDTO> result = appointmentController.findAll(PAGE, SIZE);
		Assert.assertEquals(result.get(0).getIdAppointment(),ID);
	}
	
	@Test
	public void TestfindOneById() throws NotFoundException{
		AppointmentDTO result = appointmentController.findOneById(ID);
		Assert.assertNotNull(result);
		Assert.assertEquals(result.getIdAppointment(), ID);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestfindOneByIdException() throws NotFoundException {
		appointmentController.findOneById(IDEXCEPTION);
	}
	
	@Test
	public void TestCreate() throws NotFoundException {
		AppointmentDTO result = appointmentController.create(appointmentDTO);
		Assert.assertNotNull(result);
		Assert.assertEquals(result.getIdAppointment(), ID);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestCreateException() throws NotFoundException {
		appointmentController.create(appointmentDTOException);
	}
	
	@Test
	public void TestUpdate() throws NotFoundException{
		appointmentController.update(ID, appointmentDTO);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestUpdateException() throws NotFoundException{
		appointmentController.update(IDEXCEPTION, appointmentDTOException);
	}
	
	@Test
	public void TestDelete() throws NotFoundException {
		appointmentController.delete(ID);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestDeleteException() throws NotFoundException {
		appointmentController.delete(IDEXCEPTION);
	}
}
