package com.back.end.service.flight;

import com.back.end.model.jpa.FlightJpa;

/**
 * Created by dmitry on 07.04.2017.
 */
public interface FlightSvr {

	FlightJpa getFlightByNumber(String flightNum);

}
