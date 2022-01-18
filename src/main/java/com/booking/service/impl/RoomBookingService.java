package com.booking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.converter.RoomBookingConverter;
import com.booking.dto.RoomBookingDto;
import com.booking.entity.Room;
import com.booking.entity.RoomBooking;
import com.booking.repository.RoomBookingRepository;
import com.booking.repository.RoomRepository;
import com.booking.service.IRoomBookingService;

@Service
public class RoomBookingService implements IRoomBookingService {

	@Autowired
	RoomBookingRepository roomBookingRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	RoomBookingConverter roomBookingConverter;

	@Override
	public List<RoomBookingDto> getAll() {
		List<RoomBooking> entities = roomBookingRepository.findAll();
		List<RoomBookingDto> dtos = new ArrayList<>();
		for (RoomBooking r : entities) {
			dtos.add(roomBookingConverter.toDto(r));
		}
		return dtos;
	}

	@Override
	public RoomBookingDto save(RoomBookingDto dto) {
		try {
			RoomBooking rb = roomBookingRepository.checkBooking(dto.getDay(), dto.getStartTime(),
					dto.getEndTime());
			if (rb != null) {
				throw new Exception("dupicated time");
			}
		} catch (Exception e) {
			return null;
		}
		Room room = roomRepository.getOne(dto.getRoomId());
		dto.calculatePrice(room.getPricePerHour());
		RoomBooking entity = roomBookingConverter.toEntity(dto);
		entity.setRoom(room);
		return roomBookingConverter.toDto(roomBookingRepository.save(entity));
	}

	@Override
	public List<RoomBookingDto> findByRoomId(Integer id) {
		List<RoomBooking> entities = roomBookingRepository.findByRoomId(id);
		List<RoomBookingDto> dtos = new ArrayList<>();
		for (RoomBooking entity : entities) {
			RoomBookingDto dto = roomBookingConverter.toDto(entity);
			dtos.add(dto);
		}
		return dtos;
	}

}
