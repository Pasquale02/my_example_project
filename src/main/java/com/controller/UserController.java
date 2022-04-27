package com.controller;

import java.lang.invoke.MethodHandles;
import java.net.URI;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.config.MicrometerUtility;
import com.domainJwt.Ruolo;
import com.domainJwt.Utente;
import com.service.UserService;
import com.utils.MetricUtils;

import io.micrometer.core.instrument.Timer;
import io.opentracing.Span;
import io.opentracing.Tracer;
import lombok.Data;

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
	public ResponseEntity<List<Utente>> getUsers(String requester) {

		final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

		Span activeSpan = tracer.activeSpan();

		Instant startTime = Instant.now();
		Timer executionJsonRequestTimer = MicrometerUtility.executionTimer(startTime, MicrometerUtility.EXECUTION_TIME,
				"GET");
		MetricUtils.incrementMetrics(requester);
		List<Utente> users = new ArrayList<>();
		try {
			MetricUtils.mdcLogging(applicationName, requester);

			LOG.debug("[REQUESTER]: {}", () -> requester);

			users = userService.getUsers();

			activeSpan.setBaggageItem("RESPONSE", users.toString());
			LOG.debug("[RESPONSE]: {}", users);
		} finally {
			activeSpan.finish();
			MicrometerUtility.timeElapsed(startTime, executionJsonRequestTimer);
			MDC.clear();
		}

		return new ResponseEntity<List<Utente>>(users, HttpStatus.OK);
	}

	@PostMapping(path = "/user/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Utente> saveUser(String requester, @RequestBody Utente user) {

		final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

		Span activeSpan = tracer.activeSpan();

		Instant startTime = Instant.now();
		Timer executionJsonRequestTimer = MicrometerUtility.executionTimer(startTime, MicrometerUtility.EXECUTION_TIME,
				"GET");
		MetricUtils.incrementMetrics(requester);
		Utente newUser = new Utente();
		try {
			MetricUtils.mdcLogging(applicationName, requester);

			LOG.debug("[REQUESTER]: {}", () -> requester);

			newUser = userService.saveUser(user);

			activeSpan.setBaggageItem("RESPONSE", newUser.toString());
			LOG.debug("[RESPONSE]: {}", newUser);
		} finally {
			activeSpan.finish();
			MicrometerUtility.timeElapsed(startTime, executionJsonRequestTimer);
			MDC.clear();
		}

		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("user/save").toUriString());
		LOG.debug("URI = {}", uri);
		return new ResponseEntity<Utente>(newUser, HttpStatus.OK);
	}

	@PostMapping(path = "/role/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ruolo> saveRole(String requester, @RequestBody Ruolo role) {

		final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

		Span activeSpan = tracer.activeSpan();

		Instant startTime = Instant.now();
		Timer executionJsonRequestTimer = MicrometerUtility.executionTimer(startTime, MicrometerUtility.EXECUTION_TIME,
				"GET");
		MetricUtils.incrementMetrics(requester);
		Ruolo newRuolo = new Ruolo();
		try {
			MetricUtils.mdcLogging(applicationName, requester);

			LOG.debug("[REQUESTER]: {}", () -> requester);

			newRuolo = userService.saveRole(role);

			activeSpan.setBaggageItem("RESPONSE", newRuolo.toString());
			LOG.debug("[RESPONSE]: {}", newRuolo);
		} finally {
			activeSpan.finish();
			MicrometerUtility.timeElapsed(startTime, executionJsonRequestTimer);
			MDC.clear();
		}

		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("role/save").toUriString());
		LOG.debug("URI = {}", uri);
		return new ResponseEntity<Ruolo>(newRuolo, HttpStatus.CREATED);
	}

	@PostMapping(path = "/role/addtouser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addRoleToName(String requester, @RequestBody RoleToUserForm form) {

		final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

		Span activeSpan = tracer.activeSpan();

		Instant startTime = Instant.now();
		Timer executionJsonRequestTimer = MicrometerUtility.executionTimer(startTime, MicrometerUtility.EXECUTION_TIME,
				"GET");
		MetricUtils.incrementMetrics(requester);
		try {
			MetricUtils.mdcLogging(applicationName, requester);

			LOG.debug("[REQUESTER]: {}", () -> requester);

			userService.addRoleToUser(form.getUsername(), form.getRolename());

		} finally {
			activeSpan.finish();
			MicrometerUtility.timeElapsed(startTime, executionJsonRequestTimer);
			MDC.clear();
		}

		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}

@Data
class RoleToUserForm {
	private String username;
	private String rolename;

}
