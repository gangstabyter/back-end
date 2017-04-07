package com.back.end.model.dto.login;

import com.back.end.config.security.authentication.AuthenticationBean;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Base64;

/**
 * Created by dmitry on 26.03.2017.
 */
public class LoginResultBean implements Serializable {

	private String login;

	@JsonIgnore
	private String password;

	private String firstName;

	private String lastName;

	private String userRole;

	private LoginStatus status = LoginStatus.FAILED;


	public enum LoginStatus {
		SUCCESS,
		FAILED
	}

	public static LoginResultBean from(AuthenticationBean bean) {
		LoginResultBean loginResultBean = new LoginResultBean();
		if (bean != null) {
			loginResultBean.login = bean.getLogin();
			loginResultBean.password = bean.getPassword();
			loginResultBean.firstName = bean.getFirstName();
			loginResultBean.lastName = bean.getLastName();
			loginResultBean.userRole = bean.getAuthorities().get(0).getAuthority();
			loginResultBean.status = LoginStatus.SUCCESS;
		}

		return loginResultBean;
	}

	public String getAuthHeader() {
		if (status == LoginStatus.SUCCESS) {
			return "Basic "
					+ new String(Base64.getEncoder().encode((login + ":" + password).getBytes()));
		}
		return "";
	}

	public String getLogin() {
		return login;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserRole() {
		return userRole;
	}

	public LoginStatus getStatus() {
		return status;
	}
}