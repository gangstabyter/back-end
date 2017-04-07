package com.back.end.dao;

import com.back.end.model.jpa.UserJpa;

import java.util.List;

/**
 * Created by dmitry on 07.04.2017.
 */
public interface UserDao {
	List<UserJpa> getUsers();

	UserJpa getUserByLogin(String login);
}
