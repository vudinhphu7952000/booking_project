package com.booking.dto;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookingDto {

	private Integer id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, 
			  pattern = "MM/dd/yyyy")   
	private LocalDate day;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, 
			  pattern = "HH:mm")   
	private LocalTime startTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, 
			  pattern = "HH:mm") 
	private LocalTime endTime;
	private float price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDay() {
		return day;
	}
	public void setDay(LocalDate day) {
		this.day = day;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void calculatePrice(float pricePerHour) {
		Duration duration = Duration.between(this.startTime, this.endTime);
		long hours = duration.toHours();
		long minutes = duration.toMinutes() - hours * 60;
		this.setPrice((float) (hours + (minutes * 1.0 / 60)) * pricePerHour);
	}
}
