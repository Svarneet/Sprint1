package com.brs.entity;

import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "bus")
public class Bus {
	@Id
	@Column(name="busId")
	@NotNull(message = "Id cannot be null")
	private int busId;
	@Column(name = "bus_name", nullable = false, length = 20)
	private String busName;
	@Column(name = "driverName", nullable = false, length = 20)
	private String driverName;
	@Column(name = "bustype", nullable = false, length = 20)
	private String busType;
	@Column(name = "routeFrom", nullable = false, length = 20)
	@NotBlank(message = "routefrom cannot be blank")
	@Pattern(regexp = "^[A-Za-z ]{3,20}$", message = "routefrom must only be alphabets and whitespaces from 3 to 20 characters")
	private String routeFrom;
	@Column(name = "routeTo", nullable = false, length = 20)
	@NotBlank(message = "routeto cannot be blank")
	@Pattern(regexp = "^[A-Za-z ]{3,20}$", message = "routeto must only be alphabets and whitespaces from 3 to 20 characters")
	private String routeTo;
	@JsonProperty("arrivalTime")
	@Column(name = "arrivalTime", nullable = false, length = 20)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime arrivalTime;
	@JsonProperty("depatureTime")
	@Column(name = "departureTime", nullable = false, length = 20)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime departureTime;
	@Column(name = "seats", nullable = false, length = 20)
	@Pattern(regexp = "^[1-50] {2}$" ,message = "seats no should be within 1 to 50 numbers ")
	private int seats;
	@Column(name = "availableSeats", nullable = true, length = 20)
	@NotNull
	@Pattern(regexp = "^[1-4]?[0-9]$" ,message = "availableseats no should be within 1 to 50 numbers ")
	private int avaiableSeats;

	public int getBusId() {
		return busId;
	}
	public Bus(int busId, String busName, String driverName, String busType, String routeFrom, String routeTo,
			LocalTime arrivalTime, LocalTime departureTime, int seats, int avaiableSeats) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.driverName = driverName;
		this.busType = busType;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.seats = seats;
		this.avaiableSeats = avaiableSeats;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getRouteFrom() {
		return routeFrom;
	}
	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}
	public String getRouteTo() {
		return routeTo;
	}
	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public int getAvaiableSeats() {
		return avaiableSeats;
	}
	public void setAvaiableSeats(int avaiableSeats) {
		this.avaiableSeats = avaiableSeats;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + busId;
		return result;
	}
	public Bus() {
		super();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		if (busId != other.busId)
			return false;
		return true;
	}
}