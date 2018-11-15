package com.warren.bootstrap.spittr.data;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/13 9:26
 */
public class Spittle {

	private final Long id;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longitude;

	public Spittle(String message, Date time) {
		this(null, message, time, null, null);
	}

	public Spittle(Long id, String message, Date time, Double longitude, Double latitude) {
		this.id = id;
		this.message = message;
		this.time = time;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	@Override
	public boolean equals(Object that) {
		//通过特定的字段比较两个对象是否相等
		return EqualsBuilder.reflectionEquals(this, that, "id", "time");
	}

	@Override
	public int hashCode() {
		//通过特定的字段比较两个对象HashCode是否相等
		return HashCodeBuilder.reflectionHashCode(this, "id", "time");
	}

}
