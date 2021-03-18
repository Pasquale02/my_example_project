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
}
