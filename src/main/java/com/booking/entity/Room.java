package com.booking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room extends SeatAndRoom{

	@OneToMany(mappedBy="room", fetch=FetchType.LAZY)
	private List<RoomBooking> bookingRooms;

	public List<RoomBooking> getBookingRooms() {
		return bookingRooms;
	}

	public void setBookingRooms(List<RoomBooking> bookingRooms) {
		this.bookingRooms = bookingRooms;
	}
}
