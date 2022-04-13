package com.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;
import io.opentracing.Span;
import io.opentracing.tag.Tags;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class MicrometerUtility {

	private MicrometerUtility() {
	}

	public static final String BASE = "proof";
	public static final String API = "_jsonRequest";
	public static final String CHANNEL_NAME = "requester";
	public static final String MESSAGES = "messages";

	public static final String TOTAL_REQUEST = BASE + API + "_request_counter";
	public static final String TOTAL_RESPONSE_OK = BASE + API + "_response_ok";
	public static final String TOTAL_RESPONSE_KO = BASE + API + "_response_ko";

	public static final String TOTAL_GET_REQUEST = BASE + API + "_get_request_counter";
	public static final String TOTAL_GET_RESPONSE_OK = BASE + API + "_get_response_ok";
	public static final String TOTAL_GET_RESPONSE_KO = BASE + API + "_get_response_ko";
	
	public static final String TOTAL_POST_REQUEST = BASE + API + "_post_request_counter";
	public static final String TOTAL_POST_RESPONSE_OK = BASE + API + "_post_response_ok";
	public static final String TOTAL_POST_RESPONSE_KO = BASE + API + "_post_response_ko";
	
	public static final String EXECUTION_TIME = BASE + API + "_execute_time";
	public static final String TOTAL_REQUEST_GENERIC_KO = BASE + API + "_request_counter_generic_ko";
	public static final String TOTAL_REQUEST_MESS_NOT_READABLE_KO = BASE + API + "_request_counter_not_readable";
	public static final String TOTAL_REQUEST_ARG_NOT_VALID_KO = BASE + API + "_request_counter_arg_not_valid";
	public static final String TOTAL_REQUEST_APPLICATION_EXCEPTION = BASE + API
			+ "_request_counter_application_exception";

	public static final String BUILD_RESPONSE_EXECUTION_TIME = BASE + "_" + API + "_build_response_execute_time";

	static {
		Counter.builder(TOTAL_REQUEST).baseUnit(MESSAGES).description("Numero di richieste ricevute")
				.register(Metrics.globalRegistry);

		Counter.builder(TOTAL_RESPONSE_OK).baseUnit(MESSAGES).description("Numero di risposte corrette")
				.register(Metrics.globalRegistry);

		Counter.builder(TOTAL_RESPONSE_KO).baseUnit(MESSAGES).description("Numero di risposte errate")
				.register(Metrics.globalRegistry);

		Counter.builder(TOTAL_REQUEST_GENERIC_KO).baseUnit(MESSAGES).description("Numero di errori generici")
				.register(Metrics.globalRegistry);

		Counter.builder(TOTAL_REQUEST_MESS_NOT_READABLE_KO).baseUnit(MESSAGES)
				.description("Numero di richieste non leggibili").register(Metrics.globalRegistry);

		Counter.builder(TOTAL_REQUEST_ARG_NOT_VALID_KO).baseUnit(MESSAGES)
				.description("Numero di richieste con argomenti non validi").register(Metrics.globalRegistry);

	}

	public static void numberRequest(String metric) {
		Metrics.counter(metric).increment();
	}

	public static Timer executionTimer(Instant start, String executionMetricName, String method) {
		Timer executionTimer = Timer.builder(executionMetricName).tags("method", method)
				.register(Metrics.globalRegistry);
		MicrometerUtility.timeElapsed(start, executionTimer);

		return executionTimer;
	}

	public static void timeElapsed(Instant start, Timer executionTimer) {
		long timeElapsed = Duration.between(start, Instant.now()).toMillis();
		executionTimer.record(timeElapsed, TimeUnit.MILLISECONDS);
	}

	public static void incrementMetrics(String requester, Instant startTime, String typeResponse,
			Span processedRequest) {
		if (typeResponse.equals(MicrometerUtility.TOTAL_RESPONSE_OK)) {
			MicrometerUtility.numberRequest(typeResponse);
			MicrometerUtility.numberRequest(MicrometerUtility.BASE + "_" + MicrometerUtility.API + "_requests_"
					+ requester.toUpperCase() + "_counter");
			MicrometerUtility.executionTimer(startTime, typeResponse, requester);
		} else {
			MicrometerUtility.numberRequest(MicrometerUtility.BASE + "_" + MicrometerUtility.API + "_requests_"
					+ requester.toUpperCase() + "_counter_ko");
			Tags.ERROR.set(processedRequest, true);
		}
	}

}
