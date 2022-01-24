package com.booking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.converter.RoomConverter;
import com.booking.dto.RoomBookingDto;
import com.booking.dto.RoomDto;
import com.booking.entity.Room;
import com.booking.entity.RoomBooking;
import com.booking.repository.RoomBookingRepository;
import com.booking.repository.RoomRepository;
import com.booking.service.IRoomService;

@Service
public class RoomService implements IRoomService {

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	RoomConverter roomConverter;

	@Autowired
	RoomBookingRepository roomBookingRepository;

	@Override
	public List<RoomDto> getAll() {
		List<Room> entities = roomRepository.findAll();
		List<RoomDto> dtos = new ArrayList<>();
		for (Room r : entities) {
			RoomDto dto = roomConverter.toDto(r);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public RoomDto findOne(Integer id) {
		Room room = roomRepository.findById(id).orElse(null);
		if (room != null) {
			return roomConverter.toDto(room);
		}
		return null;
	}

	@Override
	public RoomDto save(RoomDto roomDto) {
		Room entity = roomConverter.toEntity(roomDto);
		return roomConverter.toDto(roomRepository.save(entity));
	}

	@Override
	public String delete(Integer[] ids) {
		String result = "";
		for (Integer id : ids) {
			List<RoomBooking> rbs = roomBookingRepository.findByRoomId(id);
			if (rbs.size() > 0) {
				result += id + " ";
				continue;
			}
			roomRepository.deleteById(id);
		}
		return result;
	}

}
