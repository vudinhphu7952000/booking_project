package com.booking.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="roombooking")
public class RoomBooking extends Booking{
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="room_id")
	private Room room;

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
}
