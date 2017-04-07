package com.back.end.model.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Created by dmitry on 07.04.2017.
 */
@Entity
@Table(name = "flight")
public class FlightJpa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY
	private Long id;

	@Column(length = 100, nullable = false)
	private String flightNumber;

	@Column(length = 100, nullable = false)
	private String goesFrom;

	@Column(length = 100, nullable = false)
	private String goesTo;

	@Column(nullable = false)
	private Date departureTime;

	@Column(nullable = false)
	private Date arrivalTime;

	@ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
	@JoinTable(name = "userFlight", joinColumns = {
			@JoinColumn(name = "flightId") }, inverseJoinColumns = {
			@JoinColumn(name = "userId") })
	private List<UserJpa> user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getGoesFrom() {
		return goesFrom;
	}

	public void setGoesFrom(String goesFrom) {
		this.goesFrom = goesFrom;
	}

	public String getGoesTo() {
		return goesTo;
	}

	public void setGoesTo(String goesTo) {
		this.goesTo = goesTo;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public List<UserJpa> getUser() {
		return user;
	}

	public void setUser(List<UserJpa> user) {
		this.user = user;
	}
}
