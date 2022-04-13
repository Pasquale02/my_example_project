package com.utils;

import org.slf4j.MDC;

import com.config.MicrometerUtility;

public class MetricUtils {

	public static void incrementMetrics(String requester) {
		MicrometerUtility.numberRequest(MicrometerUtility.TOTAL_REQUEST);

		String requesterUser = requester != null ? requester : "";
		MicrometerUtility.numberRequest(
				MicrometerUtility.BASE + "_" + MicrometerUtility.API + "_requests_" + requesterUser + "_counter_ok");
	}

	public static void mdcLogging(String applicationName, String requester) {
		MDC.put("api_tag_name", applicationName);
		MDC.put("requester", requester);
	}
}
