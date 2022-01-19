package com.booking.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="seat")
public class Seat extends SeatAndRoom{
	
	@OneToMany(mappedBy = "seat")
	private List<SeatBooking> bookingSeats = new ArrayList<>();

	public List<SeatBooking> getBookingSeats() {
		return bookingSeats;
	}

	public void setBookingSeats(List<SeatBooking> bookingSeats) {
		this.bookingSeats = bookingSeats;
	}
	
}
