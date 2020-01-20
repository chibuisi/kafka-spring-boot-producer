package com.kelvin.kafka.controller;


import com.kelvin.kafka.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private static final String TOPIC = "payments";
    private Logger logger = Logger.getLogger(PaymentController.class.getName());

    @Autowired
    private KafkaTemplate<String, Payment> kafkaTemplate;

    @PostMapping(value = "/pay")
    public ResponseEntity<String> makePayment(@RequestBody Payment payment){
        logger.log(Level.INFO, "publishing payment to kafka...");
        kafkaTemplate.send(TOPIC, payment);
        logger.log(Level.INFO, "payment published to kafka successfully...");
        return new ResponseEntity<>("Paid Completed", HttpStatus.OK);
    }
}
