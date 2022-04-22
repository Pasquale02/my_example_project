package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RestController;

import com.service.UserService;

import io.opentracing.Tracer;

@RestController
public class JsonPlaceholderController {

	@Autowired
	private UserService userService;

	@Autowired
	private Tracer tracer;

	@Autowired
	HttpHeaders httpHeaders;

	@Value("${spring.application.name}")
	String applicationName;

//	@GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<User>> getUsers(String requester, String requestId, String uberTracerId,
//			String xIbmClientId, String xIbmClientSecret, String headerRequestId, HttpServletRequest request)
//			throws Exception {
//
//		final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());
//
//		Span activeSpan = tracer.activeSpan();
//
//		Instant startTime = Instant.now();
//		Timer executionJsonRequestTimer = MicrometerUtility.executionTimer(startTime, MicrometerUtility.EXECUTION_TIME,
//				"GET");
//		MetricUtils.incrementMetrics(requester);
//
//		List<User> users = new ArrayList<>();
//		try {
//			MetricUtils.mdcLogging(applicationName, requester);
//
//			LOG.debug("[REQUEST]: {}", () -> request);
//			users = userService.getUsers(headerRequestId, activeSpan);
//
//		} finally {
//			MicrometerUtility.timeElapsed(startTime, executionJsonRequestTimer);
//			MDC.clear();
//		}
//
//		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//	}
}

