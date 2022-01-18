package com.booking.service;

import java.util.List;

import com.booking.dto.SeatDto;

public interface ISeatService {
	List<SeatDto> getAll();
	SeatDto findOne(Integer id);
	SeatDto save(SeatDto roomDto);
	void delete(Integer[] ids);
}
