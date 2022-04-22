package com.controller;

import java.lang.invoke.MethodHandles;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.config.MicrometerUtility;
import com.domainJwt.User;
import com.service.UserService;
import com.utils.MetricUtils;

import io.micrometer.core.instrument.Timer;
import io.opentracing.Span;
import io.opentracing.Tracer;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private Tracer tracer;

	@Value("${spring.application.name}")
	String applicationName;

	@Autowired
	HttpHeaders httpHeaders;

	@GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUsers(String requester) {

		final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

		Span activeSpan = tracer.activeSpan();

		Instant startTime = Instant.now();
		Timer executionJsonRequestTimer = MicrometerUtility.executionTimer(startTime, MicrometerUtility.EXECUTION_TIME,
				"GET");
		MetricUtils.incrementMetrics(requester);
		List<User> users = new ArrayList<>();
		try {
			MetricUtils.mdcLogging(applicationName, requester);

			LOG.debug("[REQUESTER]: {}", () -> requester);

			users = userService.getUsers();

			activeSpan.setBaggageItem("RESPONSE", users.toString());
			LOG.debug("[RESPONSE]: {}", users);
		} finally {
			MicrometerUtility.timeElapsed(startTime, executionJsonRequestTimer);
			MDC.clear();
		}

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
