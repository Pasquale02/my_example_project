package com;

import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import io.jaegertracing.Configuration;

@SpringBootApplication
@ComponentScan({ "com.*" })
@EnableScheduling
public class MyProjectMvnApplication {

	public static void main(String[] args) {
		final Logger log = LogManager.getLogger(MethodHandles.lookup().lookupClass());

		log.info("init main");

		String date = LocalDateTime.now().toString();
		
		String dataUtile = date.substring(0, date.indexOf("."));
		String due = dataUtile.replace("T", " ");

		log.info(due);

		// se hai nella data il formato CEST
        String dateStr = "Mon Apr 20 00:00:00 CEST 2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM d H:mm:ss zzz yyyy", Locale.ENGLISH);
        ZonedDateTime parsedDate = ZonedDateTime.parse(dateStr, formatter);
        System.out.println(parsedDate);
        System.out.println(parsedDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
		
		SpringApplication.run(MyProjectMvnApplication.class, args);
	}

	@Bean
	public io.opentracing.Tracer jaegerTracer() {
		Configuration.SamplerConfiguration samplerConfig = new Configuration.SamplerConfiguration().withType("const")
				.withParam(1);
		Configuration.ReporterConfiguration reporterConfig = Configuration.ReporterConfiguration.fromEnv()
				.withLogSpans(true);
		return Configuration.fromEnv("getUsersFromPlaceholder").withSampler(samplerConfig).withReporter(reporterConfig)
				.getTracer();
	}

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public HttpHeaders httpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpServletRequest curRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		Enumeration<String> headerNames = curRequest.getHeaderNames();

		if (headerNames != null) {
			while (headerNames.hasMoreElements()) {
				String header = headerNames.nextElement();
				String value = curRequest.getHeader(header);
				httpHeaders.add(header, value);
			}
		}
		return httpHeaders;
	}

}
