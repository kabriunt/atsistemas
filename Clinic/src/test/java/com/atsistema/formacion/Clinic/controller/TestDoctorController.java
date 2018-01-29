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

import com.atsistema.formacion.Clinic.controller.doctor.DoctorController;
import com.atsistema.formacion.Clinic.dto.DoctorDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.service.DoctorService;

@RunWith(MockitoJUnitRunner.class)
public class TestDoctorController {

	private static final Integer ID = 1;
	private static final Integer IDException = -1;
	private static final Integer PAGE = 0;
	private static final Integer SIZE = 10;
	private static final String NAME = "name";
	private DoctorDTO doctorDTO = new DoctorDTO();
	private DoctorDTO doctorDTOException = new DoctorDTO();
	private List<DoctorDTO> listDTO = new ArrayList<>();
	
	@Mock
	private DoctorService doctorService;
	
	@InjectMocks 
	private DoctorController doctorController = new DoctorController();
	
	@Before
	public void initDoctor() throws NotFoundException {
		doctorDTO.setIdDoctor(ID);
		doctorDTO.setNameDoctor(NAME);
		doctorDTOException.setIdDoctor(IDException);
		doctorDTOException.setNameDoctor(NAME);
		
		listDTO.add(doctorDTO);
		Mockito.when(doctorService.findAll(PAGE, SIZE)).thenReturn(listDTO);
		Mockito.when(doctorService.findById(ID)).thenReturn(doctorDTO);
		Mockito.when(doctorService.findById(IDException)).thenThrow(new NotFoundException());
		Mockito.when(doctorService.find5OrderByPatientsDesc(PAGE,SIZE)).thenReturn(listDTO);
		Mockito.when(doctorService.findByName(NAME)).thenReturn(listDTO);
		Mockito.when(doctorService.create(doctorDTO)).thenReturn(doctorDTO);
		Mockito.doNothing().when(doctorService).update(doctorDTO);
		Mockito.doNothing().when(doctorService).delete(ID);
	}
	
	@Test
	public void testFindAll(){
		List<DoctorDTO> result = doctorController.findAll(PAGE, SIZE);
		Assert.assertEquals(result.get(0).getNameDoctor(),NAME);
	}
	
	@Test
	public void TestfindOneById() throws NotFoundException{
		DoctorDTO result = doctorController.findOneById(ID);
		Assert.assertNotNull(result);
		Assert.assertEquals(result.getNameDoctor(), NAME);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestfindOneByIdException() throws NotFoundException {
		doctorController.findOneById(IDException);
	}
	
	@Test
	public void TestRankingDoctors() {
		List<DoctorDTO> result = doctorController.find5OrderByPatientsDesc(SIZE);
		Assert.assertEquals(result.get(0).getNameDoctor(), NAME);
	}
	
	@Test
	public void TestfindByName() {
		List<DoctorDTO> result = doctorController.findByName(NAME);
		Assert.assertEquals(result.get(0).getIdDoctor(), ID);
	}
	
	@Test
	public void TestCreate() {
		DoctorDTO result = doctorController.create(doctorDTO);
		Assert.assertNotNull(result);
		Assert.assertEquals(result.getNameDoctor(), NAME);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestCreateException() throws NotFoundException{
		doctorController.create(doctorDTOException);
	}
	
	@Test
	public void TestUpdate() throws NotFoundException{
		doctorController.update(ID, doctorDTO);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestUpdateException() throws NotFoundException{
		doctorController.update(IDException,doctorDTOException);
	}
	
	@Test
	public void TestDelete() throws NotFoundException {
		doctorController.delete(ID);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestDeleteException() throws NotFoundException {
		doctorController.delete(IDException);
	}
}
