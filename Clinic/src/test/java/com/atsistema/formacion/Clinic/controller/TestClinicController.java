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

import com.atsistema.formacion.Clinic.controller.clinic.ClinicController;
import com.atsistema.formacion.Clinic.dto.ClinicDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.service.ClinicService;

@RunWith(MockitoJUnitRunner.class)
public class TestClinicController {

	private static final Integer ID = 1;
	private static final Integer IDException = -1;
	private static final Integer PAGE = 0;
	private static final Integer SIZE = 10;
	private ClinicDTO clinicDTO = new ClinicDTO();
	private ClinicDTO clinicDTOException = new ClinicDTO();
	private List<ClinicDTO> listDTO = new ArrayList<>();
	
	@Mock
	private ClinicService clinicService;
	
	@InjectMocks 
	private ClinicController clinicController = new ClinicController();
	
	@Before
	public void initClinic() throws NotFoundException {
		clinicDTO.setIdClinic(ID);
		clinicDTOException.setIdClinic(IDException);
		listDTO.add(clinicDTO);
		Mockito.when(clinicService.findAll(PAGE, SIZE)).thenReturn(listDTO);
		Mockito.when(clinicService.findById(ID)).thenReturn(clinicDTO);
		Mockito.when(clinicService.findById(IDException)).thenThrow(new NotFoundException());
		Mockito.when(clinicService.create(clinicDTO)).thenReturn(clinicDTO);
		Mockito.doNothing().when(clinicService).update(clinicDTO);
		Mockito.doNothing().when(clinicService).delete(ID);
	}
	
	@Test
	public void testFindAll(){
		List<ClinicDTO> result = clinicController.findAll(PAGE, SIZE);
		Assert.assertEquals(result.get(0).getIdClinic(),listDTO.get(0).getIdClinic());
	}
	
	@Test
	public void TestfindOneById() throws NotFoundException{
		ClinicDTO result = clinicController.findOneById(ID);
		Assert.assertNotNull(result);
		Assert.assertEquals(result.getIdClinic(), ID);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestfindOneByIdException() throws NotFoundException {
		clinicController.findOneById(IDException);
	}
	
	@Test
	public void TestCreate() {
		ClinicDTO result = clinicController.create(clinicDTO);
		Assert.assertNotNull(result);
		Assert.assertEquals(result.getIdClinic(), ID);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestCreateException() {
		clinicController.create(clinicDTOException);
	}
	
	@Test
	public void TestUpdate() throws NotFoundException{
		clinicController.update(ID,clinicDTO);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestUpdateException() throws NotFoundException{
		clinicController.update(IDException,clinicDTOException);
	}
	
	@Test
	public void TestDelete() throws NotFoundException {
		clinicController.delete(ID);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestDeleteException() throws NotFoundException {
		clinicController.delete(IDException);
	}
}
