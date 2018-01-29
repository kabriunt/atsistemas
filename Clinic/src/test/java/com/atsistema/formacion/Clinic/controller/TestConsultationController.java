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

import com.atsistema.formacion.Clinic.controller.consultation.ConsultationController;
import com.atsistema.formacion.Clinic.dto.ConsultationDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.model.Turn;
import com.atsistema.formacion.Clinic.service.ConsultationService;

@RunWith(MockitoJUnitRunner.class)
public class TestConsultationController {

	private static final Integer ID = 1;
	private static final Integer IDException = -1;
	private static final Turn T = Turn.M;
	private static final Integer PAGE = 0;
	private static final Integer SIZE = 10;
	private ConsultationDTO consultationDTO = new ConsultationDTO();
	private ConsultationDTO consultationDTOException = new ConsultationDTO();
	private List<ConsultationDTO> listDTO = new ArrayList<>();
	@Mock
	private ConsultationService consultationService;
	
	@InjectMocks 
	private ConsultationController consultationController = new ConsultationController();
	
	@Before
	public void init() throws NotFoundException {
		consultationDTO.setIdConsultation(ID);
		consultationDTO.setIdDoctor(ID);
		consultationDTO.setIdRoom(ID);
		consultationDTO.setTurn(T);
		
		consultationDTOException.setIdConsultation(IDException);
		consultationDTOException.setIdDoctor(IDException);
		
		listDTO.add(consultationDTO);
		Mockito.when(consultationService.findAll(PAGE, SIZE)).thenReturn(listDTO);
		Mockito.when(consultationService.findById(ID)).thenReturn(consultationDTO);
		Mockito.when(consultationService.findById(IDException)).thenThrow(new NotFoundException());
		Mockito.when(consultationService.create(consultationDTO)).thenReturn(consultationDTO);
		Mockito.when(consultationService.create(consultationDTOException)).thenThrow(new NotFoundException());
		Mockito.doNothing().when(consultationService).update(consultationDTO);
		Mockito.doNothing().when(consultationService).delete(ID);
	}
	
	@Test
	public void testFindAll(){
		List<ConsultationDTO> result = consultationController.findAll(PAGE, SIZE);
		Assert.assertEquals(result.get(0).getIdConsultation(),listDTO.get(0).getIdConsultation());
	}
	
	@Test(expected = NotFoundException.class)
	public void TestfindOneByIdException() throws NotFoundException {
		consultationController.findOneById(IDException);
	}
	
	@Test
	public void TestfindOneById() throws NotFoundException{
		ConsultationDTO result = consultationController.findOneById(ID);	
		Assert.assertNotNull(result);
		Assert.assertEquals(result.getIdConsultation(),ID);
	}
	
	@Test
	public void TestCreate() throws NotFoundException{
		ConsultationDTO result = consultationController.create(consultationDTO);
		Assert.assertNotNull(result);
		Assert.assertEquals(result.getIdConsultation(), ID);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestCreateException() throws NotFoundException{
		consultationController.create(consultationDTOException);
	}
	
	@Test
	public void TestUpdate() throws NotFoundException{
		consultationController.update(ID, consultationDTO);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestUpdateException() throws NotFoundException {
		consultationController.delete(IDException);
	}
	
	@Test
	public void TestDelete() throws NotFoundException {
		consultationController.delete(ID);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestDeleteException() throws NotFoundException {
		consultationController.delete(IDException);
	}
}
