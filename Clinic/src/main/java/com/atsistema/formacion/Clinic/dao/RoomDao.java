package com.atsistema.formacion.Clinic.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.atsistema.formacion.Clinic.model.Room;

@Repository
public interface RoomDao extends PagingAndSortingRepository<Room, Integer>{

}
