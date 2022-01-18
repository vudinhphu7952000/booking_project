package com.booking.service;

import java.util.List;

import com.booking.dto.SeatBookingDto;

public interface ISeatBookingService {
	List<SeatBookingDto> getAll();
	SeatBookingDto save(SeatBookingDto dto);
	List<SeatBookingDto> findByRoomId(Integer id);
}
