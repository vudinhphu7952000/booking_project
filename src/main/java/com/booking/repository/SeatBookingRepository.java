package com.booking.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.booking.entity.SeatBooking;

public interface SeatBookingRepository extends JpaRepository<SeatBooking, Integer>{

	List<SeatBooking> findBySeatId(Integer id);
	List<SeatBooking> findByDayAndSeatId(LocalDate day, Integer seatId);

}
