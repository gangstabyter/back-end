package com.back.end.controller.login;

import com.back.end.model.dto.login.LoginResultBean;
import com.back.end.config.security.authentication.AuthenticationBean;
import com.back.end.service.login.LoginSrv;
import com.back.end.util.RestURLs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Created by dmitry on 27.01.2017.
 */
@Controller
@RequestMapping(RestURLs.ROOT)
public class LoginCtlr {

	@Autowired
	private LoginSrv loginSrv;

	@RequestMapping(value = RestURLs.LOGIN_URL_ENCODED, method = RequestMethod.POST)
	@ResponseBody
	public LoginResultBean loginUrlEncoded(@RequestParam String login, @RequestParam String password) throws Exception {

		LoginResultBean result;
		try {
			AuthenticationBean authenticationBean = loginSrv.logMeIn(login, password);
			result = LoginResultBean.from(authenticationBean);
		} catch (Exception e) {
			result = LoginResultBean.from(null);
		}
		return result;
	}

	@RequestMapping(value = RestURLs.LOGIN_JSON, method = RequestMethod.POST)
	@ResponseBody
	public LoginResultBean loginJSON(@RequestBody LoginObj loginObj) throws Exception {

		LoginResultBean result;
		try {
			AuthenticationBean authenticationBean = loginSrv.logMeIn(loginObj.getLogin(), loginObj.getPassword());
			result = LoginResultBean.from(authenticationBean);
		} catch (Exception e) {
			result = LoginResultBean.from(null);
		}
		return result;
	}
}