package com.maruthi.springdata.patientscheduling.Service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maruthi.springdata.patientscheduling.entities.Room;
import com.maruthi.springdata.patientscheduling.repos.RoomRepository;

/*
 * public class Service {
 * 
 * public Service() { // TODO Auto-generated constructor stub }
 * 
 * }
 */
@Service
public class RoomService {

    @Autowired
    private Validator validator;
    
    @Autowired
    private RoomRepository roomRepo;
    
    public Room addRoom(Room room) throws ConstraintViolationException {
        
        Set<ConstraintViolation<Room>> violations = validator.validate(room);

        if (!violations.isEmpty()) { // IF VIOLATIONS DETECTED:
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Room> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
        }

        roomRepo.save(room);
        return room;
    }
    
    public List<Room> getRooms(Room room) {
    	return (List<Room>) roomRepo.findAll(); 
    }
    
    
    public Boolean existsbyId(Long id) {
    	if (roomRepo.exists(id)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public void deleteArrayOfRoom(Room[] rooms) {
    	for (Room r : rooms) {
    		roomRepo.delete(r);
    	}
    }
    
    public List<Room> findSmokerOrSmokeFreeRooms(char smoke) 
    {
    		return (List<Room>)roomRepo.findBySmoking(smoke);
    }
    
 }
/*  public void deleteRoomByRoomNum(Long roomNum) {
	roomRepo.deleteByRoomNum(roomNum);
}*/
    
/*
 * Room r = new Room(); r.setRoomNum(007); r.setBedType("california king!");
 * r.setSmoking('n'); r.setRate(100000); r.setOccupantName("Rich Guy!");
 * r.setOccupied(false); roomRepo.save(r);
 */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
