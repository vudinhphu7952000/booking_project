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
	@Query(value="SELECT s FROM SeatBooking s WHERE s.day=:day AND ( "
			+ "(s.startTime <=:startTime AND endTime>:startTime) "
			+ "OR (startTime <=:endTime AND endTime>=:endTime)) ")	
	SeatBooking checkBooking(@Param("day") LocalDate day,@Param("startTime") LocalTime startTime,@Param("endTime") LocalTime endTime);

}
