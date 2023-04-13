package com.example.daraquei.kafka.creditcard.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.daraquei.kafka.creditcard.producer.dto.CreditCardDetails;
import com.example.daraquei.kafka.creditcard.producer.service.CreditCardService;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {
	
	@Autowired
	CreditCardService creditCardService;
	
	@PostMapping("/info/publish")
	public void publishCreditCardInfo(@RequestBody final CreditCardDetails ccInfo) {
		creditCardService.publishCreditCardInfo(ccInfo);
	}

}
