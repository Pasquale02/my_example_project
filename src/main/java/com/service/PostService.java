package com.service;

import java.lang.invoke.MethodHandles;
import java.time.Instant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.config.APITCostant;
import com.config.MicrometerUtility;
import com.domain.Post;
import com.enumeration.EnumHttpCode;
import com.exception.ApplicationException;
import com.utils.GenericUtils;

import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.tag.Tags;

@Service
public class PostService {

	@Autowired
	private Tracer tracer;

	private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

	public Post postPost(String headerRequestId, Post bodyRequest, Span span) throws ApplicationException {

		span.setTag("userId", bodyRequest.getUserId());
		Span postRequestSpan = tracer.buildSpan("call_to_post_jsonplaceholder").asChildOf(span).start();
		Instant startPostTime = Instant.now();

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = GenericUtils.setHeaders(headerRequestId);

		Post post = new Post();

		GenericUtils.setTracer(span, headers);
		postRequestSpan.log("Chiamata verso post json placeholder");
		postRequestSpan.setBaggageItem("bodyRequest", bodyRequest.toString());

		HttpEntity<Post> entity = new HttpEntity<>(headers);

		try {
			ResponseEntity<Post> response = restTemplate.exchange("http://jsonplaceholder.typicode.com/posts",
					HttpMethod.POST, entity, Post.class);
			post = response.getBody();
			this.processingMetrics(post, headerRequestId, startPostTime, postRequestSpan);

		} catch (Exception ex) {

			LOG.error(ex);
			postRequestSpan.log(APITCostant.errorInCall + ex.getMessage());

			ApplicationException applicationException = GenericUtils.setApplicationException(
					EnumHttpCode.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.name(),
					HttpStatus.INTERNAL_SERVER_ERROR, APITCostant.errorInCall, ex.getMessage());

			MicrometerUtility.incrementMetrics(headerRequestId, startPostTime, MicrometerUtility.TOTAL_RESPONSE_KO,
					postRequestSpan);
			throw applicationException;

		} finally {
			postRequestSpan.finish();
		}

		return post;
	}

	private void processingMetrics(Post bodyRequest, String requester, Instant startPostTime, Span postRequest) {

		if (bodyRequest != null && bodyRequest.getBody() != null) {
			this.incrementMetrics(requester, startPostTime, MicrometerUtility.TOTAL_POST_RESPONSE_OK, postRequest);
		} else {
			this.incrementMetrics(requester, startPostTime, MicrometerUtility.TOTAL_POST_RESPONSE_KO, postRequest);
		}
	}

	private void incrementMetrics(String requester, Instant startTime, String typeResponse, Span processedRequest) {

		MicrometerUtility.numberRequest(typeResponse);
		String base_requester = MicrometerUtility.BASE + MicrometerUtility.API + "_requests_" + requester.toUpperCase();

		if (typeResponse.equals(MicrometerUtility.TOTAL_POST_RESPONSE_OK)) {
			MicrometerUtility.numberRequest(base_requester + "_counter");
			MicrometerUtility.executionTimer(startTime, typeResponse, requester);

		} else if (typeResponse.equals(MicrometerUtility.TOTAL_POST_RESPONSE_KO)) {
			MicrometerUtility.numberRequest(base_requester + "_counter_ko");
		}
		if (typeResponse.equals(MicrometerUtility.TOTAL_RESPONSE_KO)) {
			Tags.ERROR.set(processedRequest, true);
		}
	}
}
