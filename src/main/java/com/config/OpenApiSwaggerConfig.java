package com.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OpenApiSwaggerConfig {

	@Value("${swagger.apiInfo.title}")
	String title;

	@Value("${swagger.apiInfo.description:description}")
	String description;

	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion,
			ApplicationServerProps applicationServerProps) {

		OpenAPI openApi = new OpenAPI()
				.components(new Components().addSecuritySchemes("basicScheme",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
				.info(new Info().title(title).version(appVersion).description(description));

		List<Server> servers = new ArrayList<>();

		for (ApplicationServerProps.Host host : applicationServerProps.getHosts()) {
			Server server = new Server();
			server.setUrl(host.getUrl());
			server.description(host.getDescription());
			servers.add(server);
		}

		openApi.servers(servers);
		return openApi;
	}
}
