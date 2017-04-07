package com.back.end.service.flight.impl;

import com.back.end.dao.FlightDao;
import com.back.end.model.jpa.FlightJpa;
import com.back.end.service.flight.FlightSvr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dmitry on 07.04.2017.
 */
@Service
public class FlightSvrImpl implements FlightSvr {

	@Autowired
	private FlightDao flightDao;

	@Override
	public FlightJpa getFlightByNumber(String flightNum) {
		return flightDao.getFlightByNumber(flightNum);
	}
}
