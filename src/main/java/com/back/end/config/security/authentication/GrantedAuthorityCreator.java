package com.back.end.config.security.authentication;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by dmitry on 07.04.2017.
 */
public final class GrantedAuthorityCreator {
	private GrantedAuthorityCreator() {
	}

	public static GrantedAuthority getAdminAuthority() {
		return new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return "ROLE_ADMIN";
			}
		};
	}

	public static GrantedAuthority getUserAuthority() {
		return new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return "ROLE_USER";
			}
		};
	}
}
