# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.2/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data Reactive Redis](https://docs.spring.io/spring-boot/docs/2.6.2/reference/htmlsingle/#boot-features-redis)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)

# SWAGGER

### Abilitazioni api-docs

1. Aggiungere la dipendenza "springfox-swagger2";
2. Abilitare swagger, lo puoi fare:
   1. con l'annotazione @EnableSwagger2 in SpringBootApplication;
   2. con l'annotazione @EnableSwagger2 creando la classe apposita openApiSwaggerConfig;
3. L'url da chiamare tramite postman è "http://localhost:8081/v2/api-docs"

### Abilitazioni swagger-ui

1. Aggiungere la dipendenza "springfox-swagger-ui" (le versioni 3.0.0 danno un errore nel pom; metti le versioni 2.9.2);
3. L'url da chiamare tramite chrome è "http://localhost:8081/swagger-ui.html"

### Customizzazione 

1. Creazione openApiConfig e oggetto Docket

### APIOperation

* Aggiunta descrizione sul metodo del controller

### ApiModelProperty

* Aggiunta descrizione sui model
