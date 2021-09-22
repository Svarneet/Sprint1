package com.brs.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Route {
	@Id
	@Pattern(regexp = "^[1-10]{4}$", message = "Route ID should be of four num between 1 to 10 ")
	// Bean validation to check The Id.
	private long routeId;
	
	@Column(name = "RouteTo", nullable = false, length = 20)
	@NotBlank(message = "RouteTo cannot be blank")
	@Pattern(regexp = "^[A-Za-z ]{3,20}$", message = "RouteTo must only be alphabets and whitespaces from 3 to 20 characters")
	private String routeTo;
	
	@Column(name = "RouteFrom", nullable = false, length = 20)
	@NotBlank(message = "RouteFrom cannot be blank")
	@Pattern(regexp = "^[A-Za-z ]{3,20}$", message = "RouteFrom must only be alphabets and whitespaces from 3 to 20 characters")
	private String routeFrom;
	
	@NotNull(message = "distance cannot be null")
	@Column(name = "distance", nullable = false, unique = true, length = 2)
	@Pattern(regexp = "^[0-9] {3}", message = "distance should be between 1 to 10 ")
	// Bean validation to check The driver rating.
	private int distance;
	
	@OneToMany(targetEntity = Bus.class)
	private List<Bus> bus;
	public long getRouteId() {
		return routeId;
	}
	public void setRouteId(long l) {
		this.routeId = l;
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
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public List<Bus> getBus() {
		return bus;
	}
	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}
	
	public Route(long routeId, String routeFrom, String routeTo, int distance, List<Bus> bus) {
		super();
		this.routeId = routeId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.distance = distance;
		this.bus = bus;
	}
}