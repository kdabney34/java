package com.maruthi.springdata.patientscheduling.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maruthi.springdata.patientscheduling.entities.Room;

// EXTENDS CrudRepo<tuple of ( model & id# ) > "passes model and id 
@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
	
	
	  List<Room> findByOccupantNameStartingWith(String prefix);
	  
	  List<Room> findBySmoking(char smoke); // = 'y' for all smoking rooms, 'n' for smoke-free rooms
	  
	  //void deleteByRoomNum(Long roomNum);

}

