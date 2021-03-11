package com.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Post;
import com.domain.User;
import com.service.PostService;
import com.service.UserService;

import io.opentracing.Span;
import io.opentracing.SpanContext;
import io.opentracing.Tracer;
import io.opentracing.propagation.Format;
import io.opentracing.propagation.TextMap;
import io.opentracing.propagation.TextMapAdapter;
import io.swagger.annotations.ApiOperation;

@RequestMapping
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

	@GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get users", notes = "Get users from jsonPlaceholder website")
	public ResponseEntity<List<User>> getUsers(
			@RequestHeader(value = "request_id", required = false) String headerRequestId, HttpServletRequest request)
			throws Exception {
		
        TextMap textMapExtractAdapter = new TextMapAdapter(httpHeaders.toSingleValueMap());
        SpanContext parentContext =
                tracer.extract(Format.Builtin.HTTP_HEADERS, textMapExtractAdapter);

        Span span = tracer.buildSpan("GetFromPlaceholder").asChildOf(parentContext).start();
		List<User> users = userService.getUsers(headerRequestId, span);

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@PostMapping(path = "/post", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Post> postPost(@RequestHeader(value = "request_id", required = false) String headerRequestId,
			HttpServletRequest request, @RequestBody @Valid Post bodyRequest) throws Exception {

        TextMap textMapExtractAdapter = new TextMapAdapter(httpHeaders.toSingleValueMap());
        SpanContext parentContext =
                tracer.extract(Format.Builtin.HTTP_HEADERS, textMapExtractAdapter);

        // Create a span
        Span span = tracer.buildSpan("PostToPlaceholder").asChildOf(parentContext).start();
		Post post = postService.postPost(headerRequestId, bodyRequest, span);

		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}
}
