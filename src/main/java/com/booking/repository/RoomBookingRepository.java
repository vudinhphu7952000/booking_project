package com.booking.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.booking.entity.RoomBooking;

public interface RoomBookingRepository extends JpaRepository<RoomBooking, Integer>{

	List<RoomBooking> findByRoomId(Integer id);
	
	@Query(value="SELECT r FROM RoomBooking r WHERE r.day=:day AND ( "
			+ "(r.startTime <=:startTime AND r.endTime>:startTime) "
			+ "OR (r.startTime <=:endTime AND r.endTime>=:endTime)) ")
	RoomBooking checkBooking(@Param("day") LocalDate day,@Param("startTime") LocalTime startTime,@Param("endTime") LocalTime endTime);
}
