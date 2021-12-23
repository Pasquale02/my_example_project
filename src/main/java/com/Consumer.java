package com;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	@KafkaListener(topics = "auc2.notifica.logarea_pasquale")
	public void consume(String message) throws IOException {
		System.out.println("record letto =" + message);
	}
}
