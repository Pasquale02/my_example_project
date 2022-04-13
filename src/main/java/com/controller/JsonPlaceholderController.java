package com.controller;

import java.lang.invoke.MethodHandles;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.config.MicrometerUtility;
import com.domain.Post;
import com.domain.User;
import com.service.PostService;
import com.service.UserService;
import com.utils.MetricUtils;

import io.micrometer.core.instrument.Timer;
import io.opentracing.Span;
import io.opentracing.Tracer;

@RestController
public class JsonPlaceholderController {

	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;

	@Autowired
	private Tracer tracer;

	@Autowired
	HttpHeaders httpHeaders;

	@Value("${spring.application.name}")
	String applicationName;

	@GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUsers(String requester, String requestId, String uberTracerId,
			String xIbmClientId, String xIbmClientSecret, String headerRequestId, HttpServletRequest request)
			throws Exception {

		final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

		Span activeSpan = tracer.activeSpan();

		Instant startTime = Instant.now();
		Timer executionJsonRequestTimer = MicrometerUtility.executionTimer(startTime, MicrometerUtility.EXECUTION_TIME,
				"GET");
		MetricUtils.incrementMetrics(requester);

		List<User> users = new ArrayList<>();
		try {
			MetricUtils.mdcLogging(applicationName, requester);

			LOG.debug("[REQUEST]: {}", () -> request);
			users = userService.getUsers(headerRequestId, activeSpan);

		} finally {
			MicrometerUtility.timeElapsed(startTime, executionJsonRequestTimer);
			MDC.clear();
		}

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@PostMapping(path = "/post", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Post> postPost(String requester,
			@RequestHeader(value = "request_id", required = false) String headerRequestId, HttpServletRequest request,
			@RequestBody Post bodyRequest) throws Exception {

		final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

		Span activeSpan = tracer.activeSpan();

		Instant startTime = Instant.now();
		Timer executionJsonRequestTimer = MicrometerUtility.executionTimer(startTime, MicrometerUtility.EXECUTION_TIME,
				"GET");
		MetricUtils.incrementMetrics(requester);

		Post post = new Post();

		try {
			MetricUtils.mdcLogging(applicationName, requester);

			LOG.debug("[REQUEST]: {}", () -> request);
			post = postService.postPost(headerRequestId, bodyRequest, activeSpan);

		} finally {
			MicrometerUtility.timeElapsed(startTime, executionJsonRequestTimer);
			MDC.clear();
		}

		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}}
