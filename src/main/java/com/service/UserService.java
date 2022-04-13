package com.service;

import java.lang.invoke.MethodHandles;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.config.APITCostant;
import com.config.MicrometerUtility;
import com.domain.User;
import com.enumeration.EnumHttpCode;
import com.exception.ApplicationException;
import com.utils.GenericUtils;

import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.tag.Tags;

@Service
public class UserService {

	@Autowired
	private Tracer tracer;

	private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

	public List<User> getUsers(String headerRequestId, Span span) throws ApplicationException {

		span.setTag("headerRequestId", headerRequestId);
		Span getRequestSpan = tracer.buildSpan("call_to_get_jsonplaceholder").asChildOf(span).start();
		Instant startPostTime = Instant.now();

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = GenericUtils.setHeaders(headerRequestId);

		User[] users = null;

		GenericUtils.setTracer(span, headers);
		getRequestSpan.log("Chiamata verso get json placeholder");
		getRequestSpan.setBaggageItem("headerRequestId", headerRequestId);

		try {
			ResponseEntity<User[]> userArray = restTemplate.exchange("http://jsonplaceholder.typicode.com/users",
					HttpMethod.GET, null, User[].class);
			users = userArray.getBody();

			this.processingMetrics(users, headerRequestId, startPostTime, getRequestSpan);

		} catch (Exception ex) {

			LOG.error(ex);
			getRequestSpan.log(APITCostant.errorInCall + ex.getMessage());

			ApplicationException applicationException = GenericUtils.setApplicationException(
					EnumHttpCode.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.name(),
					HttpStatus.INTERNAL_SERVER_ERROR, APITCostant.errorInCall, ex.getMessage());

			MicrometerUtility.incrementMetrics(headerRequestId, startPostTime, MicrometerUtility.TOTAL_RESPONSE_KO,
					getRequestSpan);

			throw applicationException;

		} finally {
			getRequestSpan.finish();
		}

		return Arrays.asList(users);
	}
	
	private void processingMetrics(User[] users, String requester, Instant startPostTime, Span postRequest) {

		if (users != null) {
			this.incrementMetrics(requester, startPostTime, MicrometerUtility.TOTAL_GET_RESPONSE_OK, postRequest);
		} else {
			this.incrementMetrics(requester, startPostTime, MicrometerUtility.TOTAL_GET_RESPONSE_KO, postRequest);
		}
	}

	private void incrementMetrics(String requester, Instant startTime, String typeResponse, Span processedRequest) {

		MicrometerUtility.numberRequest(typeResponse);
		String base_requester = MicrometerUtility.BASE + MicrometerUtility.API + "_requests_" + requester.toUpperCase();

		if (typeResponse.equals(MicrometerUtility.TOTAL_GET_RESPONSE_OK)) {
			MicrometerUtility.numberRequest(base_requester + "_counter");
			MicrometerUtility.executionTimer(startTime, typeResponse, requester);

		} else if (typeResponse.equals(MicrometerUtility.TOTAL_GET_RESPONSE_KO)) {
			MicrometerUtility.numberRequest(base_requester + "_counter_ko");
		}
		if (typeResponse.equals(MicrometerUtility.TOTAL_RESPONSE_KO)) {
			Tags.ERROR.set(processedRequest, true);
		}
	}
}
