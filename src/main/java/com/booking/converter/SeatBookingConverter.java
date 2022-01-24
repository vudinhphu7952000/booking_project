package com.booking.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.booking.dto.SeatBookingDto;
import com.booking.entity.SeatBooking;

@Component
public class SeatBookingConverter {
	
	@Autowired 
	SeatConverter seatConverter;
	
	// convert Dto -> Entity 
	public SeatBooking toEntity(SeatBookingDto dto) {
		SeatBooking result = new SeatBooking();
		if(dto.getId() != null) {
			result.setId(dto.getId());
		}
		result.setDay(dto.getDay());
		result.setStartTime(dto.getStartTime());
		result.setEndTime(dto.getEndTime());
		result.setPrice(dto.getPrice());
		return result;
	}
	
	// convert Entity -> Dto 
	public SeatBookingDto toDto(SeatBooking entity) {
		SeatBookingDto result = new SeatBookingDto();
		result.setId(entity.getId());
		result.setDay(entity.getDay());
		result.setStartTime(entity.getStartTime());
		result.setEndTime(entity.getEndTime());
		result.setPrice(entity.getPrice());
		result.setSeatDto(seatConverter.toDto(entity.getSeat()));
		return result;
	}
}
