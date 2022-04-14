package com.service;

import java.lang.invoke.MethodHandles;
import java.time.Instant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

import com.config.Constants;
import com.config.MicrometerUtility;
import com.domain.Post;
import com.enumeration.EnumHttpCode;
import com.exception.ApplicationException;
import com.utils.GenericUtils;

import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.propagation.Format;
import io.opentracing.propagation.TextMap;

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

		// se lo metto in GenericUtils da errore in esecuzione
		this.setTracer(postRequestSpan, headers);
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
			postRequestSpan.log(Constants.errorInCall + ex.getMessage());

			ApplicationException applicationException = GenericUtils.setApplicationException(
					EnumHttpCode.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.name(),
					HttpStatus.INTERNAL_SERVER_ERROR, Constants.errorInCall, ex.getMessage());

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
			GenericUtils.incrementMetrics(requester, startPostTime, MicrometerUtility.TOTAL_POST_RESPONSE_OK, postRequest);
		} else {
			GenericUtils.incrementMetrics(requester, startPostTime, MicrometerUtility.TOTAL_POST_RESPONSE_KO, postRequest);
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
