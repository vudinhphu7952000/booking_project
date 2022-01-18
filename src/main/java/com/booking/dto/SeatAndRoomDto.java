package com.booking.dto;

public class SeatAndRoomDto {

	private Integer id;
	private String name;
	private String code;
	private float pricePerHour;
	private String note;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public float getPricePerHour() {
		return pricePerHour;
	}
	public void setPricePerHour(float pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
