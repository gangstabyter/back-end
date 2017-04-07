package com.back.end.security.authentication;

import com.google.common.collect.Lists;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

public class RestApiUserAuthentication implements Authentication {
	private static final long serialVersionUID = 1L;

	private static final String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";

	private AuthenticationBean bean;

	private static GrantedAuthority ANONYMOUS_AUTHORITY;

	static {
		ANONYMOUS_AUTHORITY = new GrantedAuthority() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return ROLE_ANONYMOUS;
			}
		};
	}

	public RestApiUserAuthentication(AuthenticationBean bean) {
		this.bean = bean;
	}

	public RestApiUserAuthentication(String login, String password) {
		bean = new AuthenticationBean();
		bean.setLogin(login);
		bean.setPassword(password);
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		if (bean == null ||
				CollectionUtils.isEmpty(bean.getAuthorities())) {
			return Lists.newArrayList(ANONYMOUS_AUTHORITY);
		}
		return bean.getAuthorities();
	}

	@Override
	public Object getCredentials() {
		return bean.getPassword();
	}

	@Override
	public Object getDetails() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return bean.getLogin();
	}

	@Override
	public boolean isAuthenticated() {
		return true;
	}

	public String getName(){
		return bean.getLogin();
	}

	@Override
	public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
	}

	public AuthenticationBean getAuthBean() {
		return bean;
	}
}