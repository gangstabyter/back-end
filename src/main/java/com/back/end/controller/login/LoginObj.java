package com.back.end.controller.login;

import java.io.Serializable;

/**
 * Created by dmitry on 25.04.2017.
 */
public class LoginObj implements Serializable {
	private String login;
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
