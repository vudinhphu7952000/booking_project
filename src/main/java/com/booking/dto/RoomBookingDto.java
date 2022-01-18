package com.booking.dto;

public class RoomBookingDto extends BookingDto{
	private Integer roomId;
	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	private RoomDto roomDto;
	private String TYPE = "roomBooking";

	

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public RoomDto getRoomDto() {
		return roomDto;
	}

	public void setRoomDto(RoomDto roomDto) {
		this.roomDto = roomDto;
	}
}
