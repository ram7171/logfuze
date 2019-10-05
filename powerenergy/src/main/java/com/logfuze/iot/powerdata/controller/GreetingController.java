package com.logfuze.iot.powerdata.controller;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.logfuze.iot.powerdata.domain.Greeting;
import com.logfuze.iot.powerdata.domain.Quote;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @GetMapping(path = "another-rest-call")
    public Quote sampleRestCall() {
    	RestTemplate template = new RestTemplate();
    	Quote quote = template.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    	return quote;
    }
}