package com.utils;

import java.time.Instant;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.config.MicrometerUtility;
import com.enumeration.EnumHttpCode;
import com.exception.ApplicationException;

import io.opentracing.Span;
import io.opentracing.tag.Tags;

public class GenericUtils {

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

	public static void incrementMetrics(String requester, Instant startTime, String typeResponse,
			Span processedRequest) {

		MicrometerUtility.numberRequest(typeResponse);
		String requesterUser = requester != null ? requester : "";
		String base_requester = MicrometerUtility.BASE + MicrometerUtility.API + "_requests_" + requesterUser;

		if (typeResponse.equals(MicrometerUtility.TOTAL_GET_RESPONSE_OK)
				|| typeResponse.equals(MicrometerUtility.TOTAL_POST_RESPONSE_OK)) {
			MicrometerUtility.numberRequest(base_requester + "_counter");
			MicrometerUtility.executionTimer(startTime, typeResponse, requesterUser);

		} else if (typeResponse.equals(MicrometerUtility.TOTAL_GET_RESPONSE_KO)
				|| typeResponse.equals(MicrometerUtility.TOTAL_POST_RESPONSE_KO)) {
			MicrometerUtility.numberRequest(base_requester + "_counter_ko");
		}
		if (typeResponse.equals(MicrometerUtility.TOTAL_RESPONSE_KO)) {
			Tags.ERROR.set(processedRequest, true);
		}
	}
}
