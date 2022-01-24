package com.booking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.converter.SeatConverter;
import com.booking.dto.SeatDto;
import com.booking.entity.Seat;
import com.booking.entity.SeatBooking;
import com.booking.repository.SeatBookingRepository;
import com.booking.repository.SeatRepository;
import com.booking.service.ISeatService;

@Service
public class SeatService implements ISeatService{

	@Autowired
	SeatRepository seatRepository;
	
	@Autowired
	SeatConverter seatConverter;
	
	@Autowired
	SeatBookingRepository seatBookingRepository;
	
	@Override
	public List<SeatDto> getAll() {
		List<Seat> entities = seatRepository.findAll();
		List<SeatDto> dtos = new ArrayList<>();
		for(Seat r:entities) {
			SeatDto dto = seatConverter.toDto(r);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public SeatDto findOne(Integer id) {
		Seat seat = seatRepository.findById(id).orElse(null);
		if(seat !=null) {
			return seatConverter.toDto(seat);
		}
		return null;
	}

	@Override
	public SeatDto save(SeatDto seatDto) {
		Seat entity = seatConverter.toEntity(seatDto);
		return seatConverter.toDto(seatRepository.save(entity));
	}

	@Override
	public String delete(Integer[] ids) {
		String result = "";
		for(Integer id:ids) {
			List<SeatBooking> sbt = seatBookingRepository.findBySeatId(id);
			if(sbt.size() > 0) {	
				result += id + " ";
				continue;
			}
			seatRepository.deleteById(id);
		}
		return result;
	}
}
