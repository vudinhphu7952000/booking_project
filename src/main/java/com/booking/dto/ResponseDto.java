package com.booking.dto;

import java.util.List;

public class ResponseDto {
	private String status;
	private List<Object> models;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Object> getModels() {
		return models;
	}
	public void setModels(List<Object> models) {
		this.models = models;
	}
}
