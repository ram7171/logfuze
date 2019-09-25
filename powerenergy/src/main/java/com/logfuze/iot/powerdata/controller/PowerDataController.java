package com.logfuze.iot.powerdata.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.utils.UUIDs;
import com.logfuze.iot.powerdata.domain.PowerData;
import com.logfuze.iot.powerdata.service.PowerDataService;

@RestController
public class PowerDataController {

	@Autowired
	PowerDataService service;
	
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/pushdata")
    public String pushData(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name));
    	service.insertPowerData(getSampleData());
    	return "Hellow World";
    }
    
    @RequestMapping("/pulldata")
    public List<PowerData> fetchData(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name));
    	return service.fetchPowerData();
    }
    
    
    
    private List<PowerData> getSampleData() {
    	List<PowerData> dataList = new ArrayList<>();
    	PowerData data = new PowerData(UUIDs.timeBased(), "2019-09-25 15:06:35.454", "ON", "OFF", "ON", "OFF","ON", "ON", "ON", "OFF", "OFF");
    	dataList.add(data);
    	dataList.add(new PowerData(UUIDs.timeBased(), "2019-09-24 13:06:35.454", "ON", "OFF", "ON", "OFF","ON", "ON", "ON", "OFF", "OFF"));
    	dataList.add(new PowerData(UUIDs.timeBased(), "2019-09-23 13:06:35.454", "ON", "OFF", "ON", "OFF","ON", "ON", "ON", "OFF", "OFF"));
    	return dataList;
    }
}