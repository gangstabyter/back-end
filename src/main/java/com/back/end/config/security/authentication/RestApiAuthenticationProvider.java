package com.back.end.config.security.authentication;

import com.back.end.service.login.LoginSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by dmitry on 27.01.2017.
 */
@Component
public class RestApiAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private LoginSrv loginSrv;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		String login = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();

		AuthenticationBean authenticationBean;

		try {
			authenticationBean = loginSrv.logMeIn(login, password);
		} catch (Exception e) {
			throw new AccountStatusException("Authantification failed") {};
		}


		if (authenticationBean.isLocked()) {
			throw new LockedException("You account has been locked.");
		}

		return new RestApiUserAuthentication(authenticationBean);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class == authentication;
	}
}