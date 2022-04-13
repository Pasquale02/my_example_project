package com.utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.enumeration.EnumHttpCode;
import com.exception.ApplicationException;

import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.propagation.Format;
import io.opentracing.propagation.TextMap;

public class GenericUtils {

	@Autowired
	private static Tracer tracer;

	public static HttpHeaders setHeaders(String requester) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Content-type", "application/json");
		headers.set("requester", requester);
		headers.set("Accept-Charset", "utf-8");
		return headers;
	}

	/**
	 * 
	 * @param code
	 * @param scope
	 * @param status
	 * @param title
	 * @param detail
	 * @return
	 */
	public static ApplicationException setApplicationException(EnumHttpCode code, String scope, HttpStatus status,
			String title, String detail) {

		ApplicationException applicationException = new ApplicationException();

		applicationException.setCode(code);
		// scope è resultMessage
		applicationException.setScope(scope);
		// la seguente è obbligatoria!
		applicationException.setHttpStatus(status);

		// per settaggio details
		applicationException.setNewApplicationException(status, code, title, detail, scope);

		return applicationException;
	}

	public static void setTracer(Span processRequest, HttpHeaders headers) {

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
