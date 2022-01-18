package com.booking.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="seatbooking")
public class SeatBooking extends Booking{
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="seat_id")
	private Seat seat;

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

}
