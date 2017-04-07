package com.back.end.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by dmitry on 17.03.2017.
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		Map<String, String> errorModel = Maps.newHashMap();
		errorModel.put("status", HttpStatus.FORBIDDEN + "");
		errorModel.put("message", accessDeniedException.getMessage());

		response.setStatus(HttpStatus.FORBIDDEN.value());
		response.getWriter().write(mapper.writeValueAsString(errorModel));
	}
}