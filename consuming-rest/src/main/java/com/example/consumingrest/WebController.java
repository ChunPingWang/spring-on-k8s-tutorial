package com.example.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {
    private static final Logger log = LoggerFactory.getLogger(WebController.class);
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/")
    public Quote getQuote() {
        Quote quote =  restTemplate.getForObject(
                "http://quoters.se-tap.svc.cluster.local:8080/api/random", Quote.class);
        log.info(quote.toString());
        return quote;
    }
}
