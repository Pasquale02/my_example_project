package com.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.model.Anagrafica;
import com.model.AnagraficaUnicaCliente;
import com.model.Monitoring;
import com.service.KafkaService;
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
	private KafkaService kafkaService;

    @Autowired
    private Tracer tracer;

    @Autowired
    HttpHeaders httpHeaders;
    
    @Value("${spring.kafka.topic.source.input}")
    private String topicName;
    
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
	
	@PostMapping(path = "/postKafka", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> postAnag(
			HttpServletRequest request, @RequestBody @Valid Post bodyRequest) throws Exception {
		
//		Anagrafica anag = new Anagrafica();
//		anag.setAnagraficaUnicaCliente(new AnagraficaUnicaCliente());
//		anag.setLogAnagraficaUnicaCliente(new AnagraficaUnicaCliente());
//		anag.setMonitoring(new Monitoring());
//		anag.setNumRetry(23);
//		anag.setSourceName("source_pasquale");
//		kafkaService.sendMessage(anag);
		
		String anag = "{\r\n"
				+ "  \"logAnagraficaUnicaCliente\": {\r\n"
				+ "    \"datiCliente\": {\r\n"
				+ "      \"codClienteSorgente\": \"000007091347\",\r\n"
				+ "      \"codSistemaSorgente\": \"BP\",\r\n"
				+ "      \"idClienteAuc\": null,\r\n"
				+ "      \"idTransazione\": \"3137971260259933\",\r\n"
				+ "      \"requestID\": \"BP_E_000007091347_3137971260259933\",\r\n"
				+ "      \"tipoElaborazione\": \"I\",\r\n"
				+ "      \"tsAucService\": null,\r\n"
				+ "      \"tipoEntita\": \"E\",\r\n"
				+ "      \"monitoring\": null,\r\n"
				+ "      \"sourceName\": null,\r\n"
				+ "      \"numRetry\": null\r\n"
				+ "    },\r\n"
				+ "    \"indirizzo\": [\r\n"
				+ "      {\r\n"
				+ "        \"cap\": \"80121\",\r\n"
				+ "        \"civicoaltro\": null,\r\n"
				+ "        \"codComuneMinFin\": null,\r\n"
				+ "        \"codNazioneCli\": null,\r\n"
				+ "        \"codiceIndirizzoSorgente\": null,\r\n"
				+ "        \"desNazioneCli\": null,\r\n"
				+ "        \"descComuneCli\": \"NAPOLI\",\r\n"
				+ "        \"descProvinciaCli\": null,\r\n"
				+ "        \"dsTimestamp\": \"2021-03-17 17:34:22.766\",\r\n"
				+ "        \"fabbricato\": null,\r\n"
				+ "        \"flagNormalizzazione\": \"0\",\r\n"
				+ "        \"flagInformativa\": null,\r\n"
				+ "        \"flagAffidabilita\": null,\r\n"
				+ "        \"flagVariazione\": \"A\",\r\n"
				+ "        \"frazione\": null,\r\n"
				+ "        \"dsFrazione\": null,\r\n"
				+ "        \"idIndirizzo\": null,\r\n"
				+ "        \"idTipoRiferimentoIndirizzo\": \"6\",\r\n"
				+ "        \"dsTipoIndirizzo\": null,\r\n"
				+ "        \"dsIndirizzoCompleto\": \"VIA PIAVE 12\",\r\n"
				+ "        \"descIndirizzoSenzaCivico\": \"VIA PIAVE\",\r\n"
				+ "        \"nomeStrada\": null,\r\n"
				+ "        \"numeroCivico\": \"12\",\r\n"
				+ "        \"presso\": null,\r\n"
				+ "        \"siglaProvinciaCli\": \"NA\",\r\n"
				+ "        \"tipoStrada\": null,\r\n"
				+ "        \"idCivico\": null,\r\n"
				+ "        \"intestazioneRidotta\": null,\r\n"
				+ "        \"intestazioneEstesa\": null,\r\n"
				+ "        \"bitmap\": null,\r\n"
				+ "        \"monitoring\": null,\r\n"
				+ "        \"sourceName\": null,\r\n"
				+ "        \"numRetry\": null\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  },\r\n"
				+ "  \"anagraficaUnicaCliente\": {\r\n"
				+ "    \"datiCliente\": {\r\n"
				+ "      \"codClienteSorgente\": \"000007091347\",\r\n"
				+ "      \"codSistemaSorgente\": \"BP\",\r\n"
				+ "      \"idClienteAuc\": \"1412825912\",\r\n"
				+ "      \"idTransazione\": \"3137971260259933\",\r\n"
				+ "      \"requestID\": \"BP_E_000007091347_3137971260259933\",\r\n"
				+ "      \"tipoElaborazione\": \"I\",\r\n"
				+ "      \"tsAucService\": \"2021-03-17 17:34:30.165\",\r\n"
				+ "      \"tipoEntita\": \"E\",\r\n"
				+ "      \"monitoring\": null,\r\n"
				+ "      \"sourceName\": null,\r\n"
				+ "      \"numRetry\": null\r\n"
				+ "    },\r\n"
				+ "    \"indirizzo\": [\r\n"
				+ "      {\r\n"
				+ "        \"cap\": \"80121\",\r\n"
				+ "        \"civicoaltro\": null,\r\n"
				+ "        \"codComuneMinFin\": \"F839\",\r\n"
				+ "        \"codNazioneCli\": \"IT\",\r\n"
				+ "        \"codiceIndirizzoSorgente\": null,\r\n"
				+ "        \"desNazioneCli\": \"ITALIA\",\r\n"
				+ "        \"descComuneCli\": \"NAPOLI\",\r\n"
				+ "        \"descProvinciaCli\": \"NAPOLI\",\r\n"
				+ "        \"dsTimestamp\": \"2021-03-17 17:34:22.766\",\r\n"
				+ "        \"fabbricato\": null,\r\n"
				+ "        \"flagNormalizzazione\": \"0\",\r\n"
				+ "        \"flagInformativa\": null,\r\n"
				+ "        \"flagAffidabilita\": null,\r\n"
				+ "        \"flagVariazione\": \"A\",\r\n"
				+ "        \"frazione\": null,\r\n"
				+ "        \"dsFrazione\": null,\r\n"
				+ "        \"idIndirizzo\": null,\r\n"
				+ "        \"idTipoRiferimentoIndirizzo\": \"6\",\r\n"
				+ "        \"dsTipoIndirizzo\": \"DOMICILIO\",\r\n"
				+ "        \"dsIndirizzoCompleto\": \"VIA PIAVE 12\",\r\n"
				+ "        \"descIndirizzoSenzaCivico\": \"VIA PIAVE\",\r\n"
				+ "        \"nomeStrada\": null,\r\n"
				+ "        \"numeroCivico\": \"12\",\r\n"
				+ "        \"presso\": null,\r\n"
				+ "        \"siglaProvinciaCli\": \"NA\",\r\n"
				+ "        \"tipoStrada\": null,\r\n"
				+ "        \"idCivico\": null,\r\n"
				+ "        \"intestazioneRidotta\": null,\r\n"
				+ "        \"intestazioneEstesa\": null,\r\n"
				+ "        \"bitmap\": null,\r\n"
				+ "        \"monitoring\": null,\r\n"
				+ "        \"sourceName\": null,\r\n"
				+ "        \"numRetry\": null\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  },\r\n"
				+ "  \"customData\": {\r\n"
				+ "    \"keymap\": [\r\n"
				+ "      {\r\n"
				+ "        \"code\": \"TERMINALE\",\r\n"
				+ "        \"value\": \"NFID\",\r\n"
				+ "        \"type\": \"ANTBTNDR\"\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  },\r\n"
				+ "  \"monitoring\": {\r\n"
				+ "    \"nrCampiNotNull\": 0,\r\n"
				+ "    \"statoAcquisizione\": \"ELABORATO\",\r\n"
				+ "    \"cdErrore\": \"0\"\r\n"
				+ "  }\r\n"
				+ "}";
		
		kafkaService.sendString(anag);
		return new ResponseEntity<String>(anag, HttpStatus.OK);
	
	}
}
