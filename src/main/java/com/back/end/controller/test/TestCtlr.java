package com.back.end.controller.test;

import com.back.end.util.RestURLs;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dmitry on 26.03.2017.
 */
@Controller
@RequestMapping(RestURLs.ROOT)
public class TestCtlr {

	@RequestMapping(value = RestURLs.TEST, method = RequestMethod.GET)
	@ResponseBody
	public Object login() {
		return ResponseEntity.ok("TEST");
	}
}
