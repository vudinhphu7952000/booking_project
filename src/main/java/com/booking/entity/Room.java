package com.booking.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room extends SeatAndRoom{

	@OneToMany(mappedBy="room")
	private List<RoomBooking> bookingRooms = new ArrayList<>();

	public List<RoomBooking> getBookingRooms() {
		return bookingRooms;
	}

	public void setBookingRooms(List<RoomBooking> bookingRooms) {
		this.bookingRooms = bookingRooms;
	}
}
