package com.example.daraquei.kafka.creditcard.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import com.example.daraquei.kafka.creditcard.producer.dto.CreditCardDetails;

@Service
public class CreditCardService {
	
	@Autowired
	private KafkaTemplate<String, CreditCardDetails> kafkaTemplate;
	
	@Value(value = "${creditcarddetails.topic-name}")
    private String topicName;
	

    public void publishCreditCardInfo(CreditCardDetails ccInfo) {
        kafkaTemplate.send(topicName, ccInfo.getCardNumber(), ccInfo);
    }
	

}
