package com.booking.converter;

import org.springframework.stereotype.Component;

import com.booking.dto.RoomDto;
import com.booking.entity.Room;

@Component
public class RoomConverter {
	// convert Dto -> Entity
	public Room toEntity(RoomDto dto) {
		Room result = new Room();
		result.setId(dto.getId());
		result.setCode(dto.getCode());
		result.setName(dto.getName());
		result.setNote(dto.getNote());
		result.setPricePerHour(dto.getPricePerHour());
		return result;
	}
	
	// convert Entity -> Dto 
	public RoomDto toDto(Room entity) {
		RoomDto result = new RoomDto();
		result.setId(entity.getId());
		result.setCode(entity.getCode());
		result.setName(entity.getName());
		result.setNote(entity.getNote());
		result.setPricePerHour(entity.getPricePerHour());
		return result;
	}
}
