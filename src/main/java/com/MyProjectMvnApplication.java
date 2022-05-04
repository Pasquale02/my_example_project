package com;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.domainJwt.Ruolo;
import com.domainJwt.Utente;
import com.service.UserService;

import io.jaegertracing.Configuration;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan({ "com.*" })
@Slf4j
public class MyProjectMvnApplication {

	public static void main(String[] args) throws ParseException {
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

	@Bean
	CommandLineRunner run(UserService userService) {
		log.info("adding elements to db");
		return args -> {
			
			userService.removeAllUsers();
			userService.removeAllRoles();
			userService.saveRole(new Ruolo(null, "ROLE_USER"));
			userService.saveRole(new Ruolo(null, "ROLE_MANAGER"));
			userService.saveRole(new Ruolo(null, "ROLE_ADMIN"));
			userService.saveRole(new Ruolo(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new Utente(null, "John Travolta2", "John", "1234", new ArrayList<>()));
			userService.saveUser(new Utente(null, "Will smith2", "Will", "1234", new ArrayList<>()));
			userService.saveUser(new Utente(null, "Jim carrey2", "Jim", "1234", new ArrayList<>()));

			userService.addRoleToUser("John", "ROLE_USER");
			userService.addRoleToUser("Will", "ROLE_MANAGER");
			userService.addRoleToUser("Jim", "ROLE_ADMIN");
		};
	}
}
