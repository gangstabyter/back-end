package com.back.end.dao.impl;

import com.back.end.dao.FlightDao;
import com.back.end.model.jpa.FlightJpa;
import com.back.end.model.jpa.UserJpa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by dmitry on 07.04.2017.
 */
@Repository
public class FlightDaoImpl implements FlightDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly=true)
	public List<FlightJpa> getUserFlights(UserJpa userJpa) {
		return em.createQuery("select f from FlightJpa f where f.user = :user", FlightJpa.class).setParameter("user", userJpa).getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public FlightJpa getFlightByNumber(String flightNum) {
		return em.createQuery("select f from FlightJpa f where f.flightNumber = :flightNumber", FlightJpa.class).setParameter("flightNumber", flightNum).getSingleResult();
	}

	@Override
	@Transactional(readOnly=true)
	public FlightJpa getAllFlights(String flightNum) {
		return em.createQuery("select from FlightJpa", FlightJpa.class).getSingleResult();
	}
}
