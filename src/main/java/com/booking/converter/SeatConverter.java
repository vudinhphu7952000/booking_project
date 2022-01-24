package com.booking.converter;

import org.springframework.stereotype.Component;

import com.booking.dto.SeatDto;
import com.booking.entity.Seat;

@Component
public class SeatConverter {
	// convert Dto -> Entity
	public Seat toEntity(SeatDto dto) {
		Seat result = new Seat();
		result.setId(dto.getId());
		result.setCode(dto.getCode());
		result.setName(dto.getName());
		result.setNote(dto.getNote());
		result.setPricePerHour(dto.getPricePerHour());
		return result;
	}
	
	// convert Entity -> Dto 
	public SeatDto toDto(Seat entity) {
		SeatDto result = new SeatDto();
		result.setId(entity.getId());
		result.setCode(entity.getCode());
		result.setName(entity.getName());
		result.setNote(entity.getNote());
		result.setPricePerHour(entity.getPricePerHour());
		return result;
	}
}
