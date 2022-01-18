package com.booking.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dto.SeatDto;
import com.booking.service.ISeatService;

@RestController
@RequestMapping("/admin/api/seat")
public class SeatAPI {
	
	@Autowired
	ISeatService seatService;

	@PostMapping("/insert")
	public SeatDto insert(@RequestBody SeatDto dto) {
		return seatService.save(dto);
	}

	@PutMapping("/update")
	public SeatDto update(@RequestBody SeatDto dto) {
		return seatService.save(dto);
	}

	@DeleteMapping("/delete")
	public void update(@RequestBody Integer[] ids) {
		seatService.delete(ids);
	}
	
}
