package com.back.end.dao.impl;

import com.back.end.dao.UserDao;
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
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly=true)
	public List<UserJpa> getUsers() {
		return em.createQuery("select u from UserJpa u", UserJpa.class).getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public UserJpa getUserByLogin(String login) {
		return em.createQuery("select u from UserJpa u where u.login = :login", UserJpa.class).setParameter("login", login).getSingleResult();
	}
}
