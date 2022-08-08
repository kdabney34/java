package com.maruthi.springdata.patientscheduling;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.maruthi.springdata.patientscheduling.Service.RoomService;
import com.maruthi.springdata.patientscheduling.entities.Room;
import com.maruthi.springdata.patientscheduling.repos.RoomRepository;



@SpringBootTest
public class ServiceTests {

	@Mock
	private RoomRepository roomRepo;
	
	@Mock
	@Autowired
	private Validator validator;
	
	@InjectMocks
	@Autowired
	private RoomService roomServ;
	
	@Test
	public Boolean testServiceMethodAddRoom(Room room) {
        
		roomServ.addRoom(room);
		return true; // if this method fails at any point it will be marked as test failure, else, success
        
    }
	
	
	public Boolean testGetRooms(Room room) {
    	return (List<Room>) roomRepo.findAll() instanceof List<?>;
    }
    
    
    public Boolean testExistsbyId(Long id) {
    	if (roomRepo.exists(id)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public void testDeleteArrayOfRoom(Room[] rooms) {
    	for (Room r : rooms) {
    		roomRepo.delete(r);
    	}
    }
	
	
	
	

}
