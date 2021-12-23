package com.config;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;


@EnableKafka
@Configuration
public class KafkaConsumerConfig {
		
    @Value("C:\\Users\\USER\\Documents\\progPoste\\ms_my_examples\\my-project-mvn\\src\\main\\resources\\kafka.properties")
    String kafkaConfigPath;

    @Value("changeit")
    String keystoresPass;
    
    @Value("grouopp")
    String groupID;
    
    @Bean
    public Map<String, Object> consumerConfigs() throws IOException { 
    	Properties properties = PropertiesConfigBuilder.fromFilePath(kafkaConfigPath);
    	Map<String, Object> props = properties.entrySet().stream().collect(
    		    Collectors.toMap(
    		         e -> e.getKey().toString(),
    		         e -> e.getValue().toString()
    		    )
    		);
        
        props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG,keystoresPass);
        props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG,keystoresPass);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupID);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() throws IOException {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() throws IOException {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.getContainerProperties().setSyncCommits(true);
		factory.setConcurrency(1);
		factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}