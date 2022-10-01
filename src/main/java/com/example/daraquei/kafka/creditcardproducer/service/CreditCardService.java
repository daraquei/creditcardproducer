package com.example.daraquei.kafka.creditcardproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.daraquei.kafka.creditcardproducer.dto.User;

@Service
public class CreditCardService {
	
	@Autowired
	private KafkaTemplate<String, User> template;
	
	public void publishCreditCardInfo(User ccInfo) {
	     template.send("userdetails-topic", ccInfo.getName() ,ccInfo);
	}
	

}
