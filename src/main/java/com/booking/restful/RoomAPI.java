package com.booking.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dto.RoomDto;
import com.booking.service.IRoomService;

@RestController
@RequestMapping("/admin/api/room")
public class RoomAPI {

	@Autowired
	IRoomService roomService;

	@PostMapping("/insert")
	public RoomDto insert(@RequestBody RoomDto dto) {
		return roomService.save(dto);
	}

	@PutMapping("/update")
	public RoomDto update(@RequestBody RoomDto dto) {
		return roomService.save(dto);
	}

	@DeleteMapping("/delete")
	public String update(@RequestBody Integer[] ids) {
		return roomService.delete(ids);
	}
}
