package com.booking.service;

import java.util.List;

import com.booking.dto.RoomBookingDto;

public interface IRoomBookingService {
	List<RoomBookingDto> getAll();
	RoomBookingDto save(RoomBookingDto dto);
	List<RoomBookingDto> findByRoomId(Integer id);
}
