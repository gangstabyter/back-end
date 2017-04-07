package com.back.end.service.login.impl;

import com.back.end.config.security.authentication.AuthenticationBean;
import com.back.end.config.security.authentication.GrantedAuthorityCreator;
import com.back.end.dao.UserDao;
import com.back.end.model.jpa.UserJpa;
import com.back.end.service.login.LoginSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dmitry on 26.03.2017.
 */
@Service
public class LoginSrvImpl implements LoginSrv {

	@Autowired
	private UserDao userDao;

	@Override
	public AuthenticationBean logMeIn(String login, String password) {
		UserJpa user = userDao.getUserByLogin(login);

		AuthenticationBean authenticationBean = null;
		if (user.getPwd().equals(password)) {
			authenticationBean = new AuthenticationBean();
			authenticationBean.setLogin(login);
			authenticationBean.setPassword(password);
			authenticationBean.setFirstName(user.getFirstName());
			authenticationBean.setLastName(user.getLastName());
			if (user.getAdmin()) {
				authenticationBean.addAuthority(GrantedAuthorityCreator.getAdminAuthority());
			} else {
				authenticationBean.addAuthority(GrantedAuthorityCreator.getUserAuthority());
			}
		}


		return authenticationBean;
	}
}
