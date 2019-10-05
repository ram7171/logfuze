package com.logfuze.iot.powerdata.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.datastax.driver.core.utils.UUIDs;
import com.logfuze.iot.powerdata.domain.PowerData;
import com.logfuze.iot.powerdata.domain.PowerDataTable;
import com.logfuze.iot.powerdata.domain.Quote;
import com.logfuze.iot.powerdata.mysql.repository.PowerDataMySQLRepository;
import com.logfuze.iot.powerdata.repository.PowerDataRepository;
import com.logfuze.iot.powerdata.service.PowerDataService;

@RestController
public class PowerDataController {

	@Autowired
	PowerDataService service;
	
	@Autowired
	PowerDataMySQLRepository respository;
	
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
    
    
    @GetMapping(path = "save-data-for-reference")
    public void saveDataForReference() {
    	RestTemplate template = new RestTemplate();
//    	PowerDataTable dataTable = template.getForObject("https://gturnquist-quoters.cfapps.io/api/random", PowerDataTable.class);
    	respository.save(getSampleDataTable());
//    	return quote;
    }
    
    private PowerDataTable getSampleDataTable() {
    	PowerDataTable data = new PowerDataTable();
    	data.setDtm("20190925014110");data.setSeq("8");data.setSig("0");
    	data.setMsg("io");data.setGhstatus("ON");data.setGh1("1");
    	data.setGh2("1");data.setGh3("1");data.setRsstatus("OFF");
    	data.setRs1("1");data.setRs2("2");data.setRs3("3");
    	return data;
    }
    
    private List<PowerData> getSampleData() {
    	List<PowerData> dataList = new ArrayList<>();
    	PowerData data = new PowerData(UUIDs.timeBased(), "2019-09-24 13:06:35.454", "20190925014110",
    			"8", "0", "io", "ON", "2", "3", "4", "OFF", "2", "3", "1");
    	dataList.add(data);
    	dataList.add(new PowerData(UUIDs.timeBased(), "2019-09-24 13:06:35.454", "20190925014110",
    			"8", "0", "io", "ON", "2", "3", "4", "OFF", "2", "3", "1"));
    	dataList.add(new PowerData(UUIDs.timeBased(), "2019-09-24 13:06:35.454", "20190925014110",
    			"8", "0", "io", "ON", "2", "3", "4", "OFF", "2", "3", "1"));
    	return dataList;
    }
}