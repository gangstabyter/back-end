package com.back.end.controller.test;

import com.back.end.service.flight.FlightSvr;
import com.back.end.util.RestURLs;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private FlightSvr flightSvr;

	@RequestMapping(value = RestURLs.TEST1, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity test1() {
		return ResponseEntity.ok("TEST with ADMIN role");
	}

	@RequestMapping(value = RestURLs.TEST2, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity test2() {
		return ResponseEntity.ok("TEST with USER role");
	}

	@RequestMapping(value = RestURLs.TEST3, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity test3() {
		return ResponseEntity.ok("TEST with ADMIN and USER role");
	}

	@RequestMapping(value = RestURLs.TEST4, method = RequestMethod.GET)
	@ResponseBody
	public Object test4() {
		return flightSvr.getFlightByNumber("TDF2341");
	}
}
