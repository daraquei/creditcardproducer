package com.example.daraquei.kafka.creditcard.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.example.daraquei.kafka.creditcard.producer.customserializer.CreditCardDetailsSerializer;
import com.example.daraquei.kafka.creditcard.producer.dto.CreditCardDetails;
import com.example.daraquei.kafka.creditcard.producer.partitions.TopicPartitions;

@Configuration
public class KafkaProducerConfiguration {
	
	@Value(value = "${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapAddress;
	
    @Bean
    public ProducerFactory<String, CreditCardDetails> producerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
        		bootstrapAddress);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, 
            StringSerializer.class);     
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        		CreditCardDetailsSerializer.class);
        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, TopicPartitions.class);
        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, CreditCardDetails> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
