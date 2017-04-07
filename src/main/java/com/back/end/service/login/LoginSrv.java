package com.back.end.service.login;

import com.back.end.config.security.authentication.AuthenticationBean;

/**
 * Created by dmitry on 26.03.2017.
 */
public interface LoginSrv {
	AuthenticationBean logMeIn(String login, String password);
}
