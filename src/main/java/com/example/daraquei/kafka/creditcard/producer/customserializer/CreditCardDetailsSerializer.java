package com.example.daraquei.kafka.creditcard.producer.customserializer;


import org.apache.kafka.common.serialization.Serializer;

import com.example.daraquei.kafka.creditcard.producer.dto.CreditCardDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class CreditCardDetailsSerializer implements Serializer<CreditCardDetails> {

	@Override
	public byte[] serialize(String topic, CreditCardDetails data) {
		byte[] response = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			response = objectMapper.writeValueAsBytes(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}

}
