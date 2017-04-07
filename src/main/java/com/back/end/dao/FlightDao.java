package com.back.end.dao;

import com.back.end.model.jpa.FlightJpa;
import com.back.end.model.jpa.UserJpa;

import java.util.List;

/**
 * Created by dmitry on 07.04.2017.
 */
public interface FlightDao {

	List<FlightJpa> getUserFlights(UserJpa userJpa);

	FlightJpa getFlightByNumber(String flightNum);

	FlightJpa getAllFlights(String flightNum);
}
