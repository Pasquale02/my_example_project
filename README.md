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

1. Creazione di un oggetto Docket nella classe di configurazione 

### APIOperation

* Aggiunta descrizione sul metodo del controller

### ApiModelProperty

* Aggiunta descrizione sui model

# PDF

Non ho aggiunto la dipendenza nel pom, ma il jar nelle dipendenze