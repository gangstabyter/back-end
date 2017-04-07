package com.back.end.service.login.impl;

import com.back.end.security.authentication.AuthenticationBean;
import com.back.end.service.login.LoginSrv;
import org.springframework.stereotype.Service;

/**
 * Created by dmitry on 26.03.2017.
 */
@Service
public class LoginSrvImpl implements LoginSrv {
	@Override
	public AuthenticationBean logMeIn(String login, String password) {
		AuthenticationBean authenticationBean = new AuthenticationBean();
		authenticationBean.setLogin(login);
		authenticationBean.setPassword(password);
		return authenticationBean;
	}
}
