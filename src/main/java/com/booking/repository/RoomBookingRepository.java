package com.booking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entity.RoomBooking;

public interface RoomBookingRepository extends JpaRepository<RoomBooking, Integer>{

	List<RoomBooking> findByRoomId(Integer id);
	List<RoomBooking> findByDayAndRoomId(LocalDate day,Integer roomId);
}
