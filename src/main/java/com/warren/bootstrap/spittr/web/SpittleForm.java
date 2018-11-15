package com.warren.bootstrap.spittr.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/13 10:41
 */
public class SpittleForm {
	@NotNull
	@Size(min=1, max=140)
	private String message;

	@Min(-180)
	@Max(180)
	private Double longitude;

	@Min(-90)
	@Max(90)
	private Double latitude;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
}
