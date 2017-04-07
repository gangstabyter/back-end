package com.back.end.config.security.authentication;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * Created by dmitry on 26.03.2017.
 */
public class AuthenticationBean {
	private String login;
	private String firstName;
	private String lastName;
	private String password;
	private boolean isLocked;

	private List<GrantedAuthority> authorities = Lists.newArrayList();

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

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean locked) {
		isLocked = locked;
	}

	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities.clear();
		this.authorities.addAll(authorities);
	}

	public void addAuthority(GrantedAuthority authority) {
		this.authorities.add(authority);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}