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

import com.atsistema.formacion.Clinic.controller.room.RoomController;
import com.atsistema.formacion.Clinic.dto.RoomDTO;
import com.atsistema.formacion.Clinic.exception.NotFoundException;
import com.atsistema.formacion.Clinic.service.RoomService;

@RunWith(MockitoJUnitRunner.class)
public class TestRoomController {

	private static final Integer ID = 1;
	private static final Integer IDException = -1;
	private static final Integer PAGE = 0;
	private static final Integer SIZE = 10;
	private RoomDTO roomDTO = new RoomDTO();
	private RoomDTO roomDTOException = new RoomDTO();
	private List<RoomDTO> listDTO = new ArrayList<>();
	
	@Mock
	private RoomService roomService;
	
	@InjectMocks 
	private RoomController roomController = new RoomController();
	
	@Before
	public void initRoom() throws NotFoundException {
		roomDTO.setIdRoom(ID);
		roomDTOException.setIdRoom(IDException);
		
		listDTO.add(roomDTO);
		Mockito.when(roomService.findAll(PAGE, SIZE)).thenReturn(listDTO);
		Mockito.when(roomService.findById(ID)).thenReturn(roomDTO);
		Mockito.when(roomService.findById(IDException)).thenThrow(new NotFoundException());
		Mockito.when(roomService.create(roomDTO)).thenReturn(roomDTO);
		Mockito.doNothing().when(roomService).update(roomDTO);
		Mockito.doNothing().when(roomService).delete(ID);
	}
	
	@Test
	public void testFindAll(){
		List<RoomDTO> result = roomController.findAll(PAGE, SIZE);
		Assert.assertEquals(result.get(0).getIdRoom(),listDTO.get(0).getIdRoom());
	}
	
	@Test(expected = NotFoundException.class)
	public void TestfindOneByIdException() throws NotFoundException {
		roomController.findOneById(IDException);
	}
	
	@Test
	public void TestfindOneById() throws NotFoundException{
		RoomDTO result = roomController.findOneById(ID);
		Assert.assertNotNull(result);
		Assert.assertEquals(result.getIdRoom(), ID);
	}
	
	@Test
	public void TestCreate() throws NotFoundException {
		RoomDTO result = roomController.create(roomDTO);
		
		Assert.assertNotNull(result);
		Assert.assertEquals(result.getIdRoom(), ID);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestCreateException() {
		roomController.create(roomDTOException);
	}
	
	
	@Test
	public void TestUpdate() throws NotFoundException{
		roomController.update(ID, roomDTO);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestUpdateException() throws NotFoundException{
		roomController.update(IDException,roomDTOException);
	}
	
	@Test
	public void TestDelete() throws NotFoundException {
		roomController.delete(ID);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestDeleteException() throws NotFoundException {
		roomController.delete(IDException);
	}
}
