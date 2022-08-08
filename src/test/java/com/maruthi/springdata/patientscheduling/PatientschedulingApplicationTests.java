package com.maruthi.springdata.patientscheduling;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.maruthi.springdata.patientscheduling.entities.Room;

import com.maruthi.springdata.patientscheduling.repos.RoomRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientschedulingApplicationTests {
	@Autowired 
	RoomRepository roomRepo;
	
	@Test
	public void testRoomRepo1()
	{
		Room r = new Room();
		r.setRoomNum(258);
		r.setBedType("queen");
		r.setSmoking('y');
		r.setRate(100);
		r.setOccupantName("Correctina");
		r.setOccupied(true);
		roomRepo.save(r);
	}
	
	@Test
	public void testRoomRepo3()
	{
		Room r = new Room();
		r.setRoomNum(2);
		r.setBedType("baby bed");
		r.setSmoking('y');
		r.setRate(100);
		r.setOccupantName("Nobody");
		r.setOccupied(false);
		roomRepo.save(r);
	}
	
	@Test
	public void testRoomRepo2()
	{
		Room r = new Room();
		r.setRoomNum(250);
		r.setBedType("king!");
		r.setSmoking('n');
		r.setRate(990);
		r.setOccupantName("Lousina");
		r.setOccupied(true);
		roomRepo.save(r);
	}
	
	@Test
	public void testFindAll() 
	{
		System.out.println("here is the result of CrudRepository's findAll() method on our model 'Room'" + roomRepo.findAll()); // comes as an Array of type room
	}
	
	@Test
	public void testFindById() 
	{
		System.out.println("here is the room with ID = 1:  "+ roomRepo.findOne(new Long(1))); // comes as an Array of type room
	}
	
	
	  @Test 
	  public void testFindByOccupantNameStartWith() 
	  {
		  System.out.println("here is the room with Correctina in it:  " +
		  roomRepo.findByOccupantNameStartingWith("Correct")); // comes as an Array of type room 
	  }
	 
	  @Test 
	  public void testFindSmokerOrSmokeFreeRooms() 
	  {
		  System.out.println("here's the smoker rooms:  " +
		  roomRepo.findBySmoking('y') + '\n' + "And here's the Smoke-free rooms: " + roomRepo.findBySmoking('n')); // comes as an Array of type room 
		  
	  }	  
	
}







