package com.booking.dto;

public class SeatBookingDto extends BookingDto {
	private Integer seatId;
	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	private SeatDto seatDto;
	private String TYPE = "seatBooking";

	

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public SeatDto getSeatDto() {
		return seatDto;
	}

	public void setSeatDto(SeatDto seatDto) {
		this.seatDto = seatDto;
	}
}
