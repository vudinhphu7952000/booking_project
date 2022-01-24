package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.booking.dto.RoomBookingDto;
import com.booking.dto.RoomDto;
import com.booking.dto.SeatBookingDto;
import com.booking.dto.SeatDto;
import com.booking.service.IRoomBookingService;
import com.booking.service.IRoomService;
import com.booking.service.ISeatBookingService;
import com.booking.service.ISeatService;

@Controller
public class AdminController {
	@Autowired
	IRoomService roomService;
	
	@Autowired
	ISeatService seatService;
	
	@Autowired
	ISeatBookingService seatBookingService;
	
	@Autowired
	IRoomBookingService roomBookingService;

	@GetMapping("/admin")
	public ModelAndView adminHome() {
		ModelAndView mav = new ModelAndView("adminHome");
		return mav;
	}

	// hiển thị trang danh sách các room
	@GetMapping(value = "/admin/list-room")
	public ModelAndView listRoom() {
		ModelAndView mav = new ModelAndView("listRoom");
		List<RoomDto> rooms = roomService.getAll();
		mav.addObject("models", rooms);
		return mav;
	}
	
	// hiển thị trang để nhập và lưu thông tin room
	@GetMapping(value = "/admin/save-room")
	public ModelAndView saveRoom(@RequestParam(value="id", required=false) Integer id) {
		ModelAndView mav = new ModelAndView("saveRoom");
		if(id!=null) {
			RoomDto dto = roomService.findOne(id);
			mav.addObject("model", dto);
		}
		return mav;
	}
	
	// hiển thị trang danh sách các seat
	@GetMapping(value = "/admin/list-seat")
	public ModelAndView listSeat() {
		ModelAndView mav = new ModelAndView("listSeat");
		List<SeatDto> seats = seatService.getAll();
		mav.addObject("models", seats);
		return mav;
	}
	
	// hiển thị trang để nhập và lưu thông tin seat
	@GetMapping(value = "/admin/save-seat")
	public ModelAndView saveSeat(@RequestParam(value="id", required=false) Integer id) {
		ModelAndView mav = new ModelAndView("saveSeat");
		if(id!=null) {
			SeatDto dto = seatService.findOne(id);
			mav.addObject("model", dto);
		}
		return mav;
	}
	
	// hiển thị trang các room đã đặt
	@GetMapping(value = "/admin/room-booking")
	public ModelAndView roomBooking() {
		ModelAndView mav = new ModelAndView("listBooking");
		List<RoomBookingDto> rooms = roomBookingService.getAll();
		mav.addObject("models", rooms);
		return mav;
	}
	
	// hiển thị trang các seat đã đặt
	@GetMapping(value = "/admin/seat-booking")
	public ModelAndView seatBooking() {
		ModelAndView mav = new ModelAndView("listBooking");
		List<SeatBookingDto> seats = seatBookingService.getAll();
		mav.addObject("models", seats);
		return mav;
	}
	
}
