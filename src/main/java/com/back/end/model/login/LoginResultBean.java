package com.back.end.model.login;

import com.back.end.security.authentication.AuthenticationBean;

import java.util.Base64;

/**
 * Created by dmitry on 26.03.2017.
 */
public class LoginResultBean {
	private String login;
	private String password;
	private LoginStatus status;

	public enum LoginStatus {
		SUCCESS,
		FAILED
	}

	public static LoginResultBean from(AuthenticationBean authenticationBean) {
		LoginResultBean loginResultBean = new LoginResultBean();
		loginResultBean.login = authenticationBean.getLogin();
		loginResultBean.password = authenticationBean.getPassword();
		loginResultBean.status = authenticationBean.isLocked()
				? LoginStatus.FAILED : LoginStatus.SUCCESS;
		return loginResultBean;
	}

	public String getAuthHeader() {
		if (status == LoginStatus.SUCCESS) {
			return "Basic "
					+ new String(Base64.getEncoder().encode((login + ":" + password).getBytes()));
		}
		return "";
	}
}