package com.back.end.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dmitry on 27.01.2017.
 */
public final class RestURLs {
	private RestURLs() {
	}

	public static final String ROOT = "/v1";
	public static final String LOGIN = "/login";
	public static final String TEST = "/test";

	//will be used a bit later for HATEOAS
	public static String getHostUrl(HttpServletRequest request) {
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String contextPath = request.getContextPath();
		return scheme + "://" + serverName + ":" + serverPort + contextPath;
	}
}
