package com.booking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.converter.SeatBookingConverter;
import com.booking.dto.SeatBookingDto;
import com.booking.dto.SeatBookingDto;
import com.booking.entity.SeatBooking;
import com.booking.entity.Seat;
import com.booking.entity.SeatBooking;
import com.booking.repository.SeatBookingRepository;
import com.booking.repository.SeatRepository;
import com.booking.service.ISeatBookingService;

@Service
public class SeatBookingService implements ISeatBookingService {

	@Autowired
	SeatBookingRepository seatBookingRepository;

	@Autowired
	SeatBookingConverter seatBookingConverter;

	@Autowired
	SeatRepository seatRepository;

	@Override
	public List<SeatBookingDto> getAll() {
		List<SeatBooking> entities = seatBookingRepository.findAll();
		List<SeatBookingDto> dtos = new ArrayList<>();
		for (SeatBooking r : entities) {
			dtos.add(seatBookingConverter.toDto(r));
		}
		return dtos;
	}

	@Override
	public SeatBookingDto save(SeatBookingDto dto) {
		try {
			List<SeatBooking> rbs = seatBookingRepository.findByDayAndSeatId(dto.getDay(), dto.getSeatId());
			for(SeatBooking rb: rbs) {
				SeatBookingDto rbDto = seatBookingConverter.toDto(rb);
				boolean check1 = dto.getStartTime().isAfter(rbDto.getEndTime());
				boolean check2 = dto.getEndTime().isBefore(rbDto.getStartTime());			
				if(check1 == false && check2 == false) {	
					throw new Exception("dupicated time");
				}
			}
		} catch (Exception e) {
			return null;
		}
		Seat seat = seatRepository.getOne(dto.getSeatId());
		dto.calculatePrice(seat.getPricePerHour());
		SeatBooking entity = seatBookingConverter.toEntity(dto);
		entity.setSeat(seat);
		return seatBookingConverter.toDto(seatBookingRepository.save(entity));
	}

	@Override
	public List<SeatBookingDto> findBySeatId(Integer id) {
		List<SeatBooking> entities = seatBookingRepository.findBySeatId(id);
		List<SeatBookingDto> dtos = new ArrayList<>();
		for (SeatBooking entity : entities) {
			SeatBookingDto dto = seatBookingConverter.toDto(entity);
			dtos.add(dto);
		}
		return dtos;
	}

}
