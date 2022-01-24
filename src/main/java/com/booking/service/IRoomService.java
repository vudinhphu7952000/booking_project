package com.booking.service;

import java.util.List;

import com.booking.dto.RoomDto;

public interface IRoomService {
	List<RoomDto> getAll();
	RoomDto findOne(Integer id);
	RoomDto save(RoomDto roomDto);
	String delete(Integer[] ids);
}
