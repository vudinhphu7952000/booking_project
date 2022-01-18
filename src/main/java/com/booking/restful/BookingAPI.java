package com.booking.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dto.RoomBookingDto;
import com.booking.dto.SeatBookingDto;
import com.booking.service.IRoomBookingService;
import com.booking.service.ISeatBookingService;

@RestController
public class BookingAPI {
	
	@Autowired
	IRoomBookingService roomBookingService;
	
	@Autowired
	ISeatBookingService seatBookingService;
	
	@PostMapping("/room/roombooking")
	public RoomBookingDto insert(@RequestBody RoomBookingDto dto) {
		return roomBookingService.save(dto);
	}
	
	@PostMapping("/seat/seatbooking")
	public SeatBookingDto insert(@RequestBody SeatBookingDto dto) {
		return seatBookingService.save(dto);
	}
}
