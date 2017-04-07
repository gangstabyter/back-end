package com.back.end.config.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by dmitry on 27.01.2017.
 */
@Component
public class RestApiAuthenticationEntryPoint implements AuthenticationEntryPoint {
	private String realmName;
	private ObjectMapper mapper = new ObjectMapper();

	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {
		Map<String, String> errorModel = Maps.newHashMap();
		errorModel.put("status", HttpStatus.UNAUTHORIZED + "");
		errorModel.put("message", authException.getMessage());

		response.addHeader("WWW-Authenticate", "Basic realm=\"" + realmName + "\"");
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.getWriter().write(mapper.writeValueAsString(errorModel));
	}

	public void setRealmName(String realmName) {
		this.realmName = realmName;
	}
}