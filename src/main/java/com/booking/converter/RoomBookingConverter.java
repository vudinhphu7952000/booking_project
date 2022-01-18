package com.booking.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.booking.dto.RoomBookingDto;
import com.booking.entity.RoomBooking;

@Component
public class RoomBookingConverter {
	
	@Autowired 
	RoomConverter roomConverter;
	public RoomBooking toEntity(RoomBookingDto dto) {
		RoomBooking result = new RoomBooking();
		if(dto.getId() != null) {
			result.setId(dto.getId());
		}	
		result.setDay(dto.getDay());
		result.setStartTime(dto.getStartTime());
		result.setEndTime(dto.getEndTime());
		result.setPrice(dto.getPrice());
		return result;
	}
	public RoomBookingDto toDto(RoomBooking entity) {
		RoomBookingDto result = new RoomBookingDto();
		result.setId(entity.getId());
		result.setDay(entity.getDay());
		result.setStartTime(entity.getStartTime());
		result.setEndTime(entity.getEndTime());
		result.setPrice(entity.getPrice());
		result.setRoomDto(roomConverter.toDto(entity.getRoom()));
		return result;
	}
}
