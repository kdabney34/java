package com.maruthi.springdata.patientscheduling.entities;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;

@Entity // DECLLARES CLASS AS AN ENTITY BEAN.
public class Room implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    @NotNull(message = "Room Num must be inputted")
	private int roomNum;
	private String bedType;
	private double rate;
	private String occupantName;
	private char smoking;
	private boolean occupied;

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getOccupantName() {
		return occupantName;
	}

	public void setOccupantName(String occupantName) {
		this.occupantName = occupantName;
	}

	public char getSmoking() {
		return smoking;
	}

	public void setSmoking(char smoking) {
		this.smoking = smoking;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public boolean isOccupied() {
		return occupied;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this) { return true; }
		if(!(o instanceof Room)) { return false; }
		Room r = (Room) o;
		return Integer.compare(roomNum, r.getRoomNum()) == 0
				&& bedType.equalsIgnoreCase(r.getBedType())
				&& Double.compare(rate, r.getRate()) == 0
				&& occupantName.equalsIgnoreCase(r.getOccupantName())
				&& smoking == r.getSmoking()
				&& occupied == r.isOccupied();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nRoom Number: ");
		sb.append(this.getRoomNum());
		sb.append("\nOccupant name: ");
		if(this.occupantName == null) {
			sb.append("Not occupied");
		} else {
			sb.append(this.occupantName);
		}
		sb.append("\nSmoking room: ");
		sb.append(this.smoking);
		sb.append("\nBed Type: ");
		sb.append(this.bedType);
		sb.append("\nRate: ");
		sb.append(this.rate);
		sb.append("\n");
		return sb.toString();
	}
}
