package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class UserController {
	
	@Autowired
	IRoomService roomService;
	
	@Autowired
	ISeatService seatService;
	
	@Autowired
	IRoomBookingService roomBookingService;
	
	@Autowired
	ISeatBookingService seatBookingService;
	
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		List<SeatDto> seats = seatService.getAll();
		List<RoomDto> rooms = roomService.getAll();
		mav.addObject("rooms", rooms);
		mav.addObject("seats", seats);
		return mav;
	}
	@RequestMapping(value = "/booking/{type}/{id}", method = RequestMethod.GET)
	public ModelAndView booking(@PathVariable Integer id, @PathVariable String type) {
		ModelAndView mav = new ModelAndView("booking");
		if(type.equalsIgnoreCase("room")) {
			RoomDto room = roomService.findOne(id);
			List<RoomBookingDto> roomBookingDtos = roomBookingService.findByRoomId(id);
			mav.addObject("model", room);
			mav.addObject("models", roomBookingDtos);
		} else {
			SeatDto seat = seatService.findOne(id);
			List<SeatBookingDto> saetBookingDtos = seatBookingService.findByRoomId(id);
			mav.addObject("model", seat);
			mav.addObject("models", saetBookingDtos);
		}
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {

		return "loginPage";
	}

//	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
//	public String logoutSuccessfulPage(Model model) {
//		model.addAttribute("title", "Logout");
//		return "home";
//	}
}
