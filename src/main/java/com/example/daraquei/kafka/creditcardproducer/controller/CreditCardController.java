package com.example.daraquei.kafka.creditcardproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.daraquei.kafka.creditcardproducer.dto.User;
import com.example.daraquei.kafka.creditcardproducer.service.CreditCardService;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {
	
	@Autowired
	CreditCardService creditCardService;
	
	@PostMapping("/info/publish")
	public void publishCreditCardInfo(@RequestBody final User ccInfo) {
		creditCardService.publishCreditCardInfo(ccInfo);
		
	}

}
