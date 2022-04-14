package com.service;

import java.lang.invoke.MethodHandles;
import java.time.Instant;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.config.Constants;
import com.config.MicrometerUtility;
import com.domain.User;
import com.enumeration.EnumHttpCode;
import com.exception.ApplicationException;
import com.utils.GenericUtils;

import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.propagation.Format;
import io.opentracing.propagation.TextMap;

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

		// se lo metto in GenericUtils da errore in esecuzione
		this.setTracer(getRequestSpan, headers);
		getRequestSpan.log("Chiamata verso get json placeholder");
		getRequestSpan.setBaggageItem("headerRequestId", headerRequestId);

		try {
			ResponseEntity<User[]> userArray = restTemplate.exchange("http://jsonplaceholder.typicode.com/users",
					HttpMethod.GET, null, User[].class);
			users = userArray.getBody();

			this.processingMetrics(users, headerRequestId, startPostTime, getRequestSpan);

		} catch (Exception ex) {

			LOG.error(ex);
			getRequestSpan.log(Constants.errorInCall + ex.getMessage());

			ApplicationException applicationException = GenericUtils.setApplicationException(
					EnumHttpCode.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.name(),
					HttpStatus.INTERNAL_SERVER_ERROR, Constants.errorInCall, ex.getMessage());

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
			GenericUtils.incrementMetrics(requester, startPostTime, MicrometerUtility.TOTAL_GET_RESPONSE_OK, postRequest);
		} else {
			GenericUtils.incrementMetrics(requester, startPostTime, MicrometerUtility.TOTAL_GET_RESPONSE_KO, postRequest);
		}
	}

	private void setTracer(Span processRequest, HttpHeaders headers) {

		tracer.inject(processRequest.context(), Format.Builtin.HTTP_HEADERS, new TextMap() {

			@Override
			public Iterator<Map.Entry<String, String>> iterator() {
				throw new UnsupportedOperationException(
						"TextMapInjectAdapter should only be used with Tracer.inject()");
			}

			@Override
			public void put(String key, String value) {
				List<String> values = new LinkedList<>();
				values.add(value);
				headers.put(key, values);
			}
		});
	}
}
