package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.model.Anagrafica;

@Service
public class KafkaService {

	@Value("${spring.kafka.topic.source.input}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, Anagrafica> kafkaTemplate;

	@Autowired
	private KafkaTemplate<String, String> kafkaStringTemplate;

	public Boolean sendMessage(Anagrafica anag) {

		Boolean result = false;
		try {
			kafkaTemplate.send(topicName, anag);
			result = true;
		} catch (Exception e) {
			System.out.println("Eccezione invio messaggio su kafka" + e);
		}
		return result;
	}

	public Boolean sendString(String stringa) {

		Boolean result = false;
		try {
			kafkaStringTemplate.send(topicName, stringa);
			result = true;
		} catch (Exception e) {
			System.out.println("Eccezione invio messaggio (stringa) su kafka" + e);
		}
		return result;
	}
}
