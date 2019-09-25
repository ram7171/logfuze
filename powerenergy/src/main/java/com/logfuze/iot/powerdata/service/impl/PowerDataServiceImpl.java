package com.logfuze.iot.powerdata.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.Session;
import com.logfuze.iot.powerdata.cassandra.db.CassandraConnector;
import com.logfuze.iot.powerdata.domain.PowerData;
import com.logfuze.iot.powerdata.repository.KeyspaceRepository;
import com.logfuze.iot.powerdata.repository.PowerDataRepository;
import com.logfuze.iot.powerdata.service.PowerDataService;

@Service
public class PowerDataServiceImpl implements PowerDataService {

	CassandraConnector connector = null;
	private static final Logger LOG = LoggerFactory.getLogger(PowerDataServiceImpl.class);
	@Override
	public void insertPowerData(List<PowerData> dataList) {
		// TODO Auto-generated method stub
		LOG.debug("data List ->{}",dataList);
		
		Session session = getDBSession();
		dataList.forEach(data -> LOG.debug("data->{}", data));
		KeyspaceRepository sr = new KeyspaceRepository(session);
        sr.useKeyspace();
		PowerDataRepository repository = new PowerDataRepository(session);
		for(PowerData data : dataList ) {
			repository.insertPowerData(data);
		}
		if (connector != null) {
			connector.close();
		}
	}

	@Override
	public List<PowerData> fetchPowerData() {
		Session session = getDBSession();
		KeyspaceRepository sr = new KeyspaceRepository(session);
        sr.useKeyspace();
		PowerDataRepository repository = new PowerDataRepository(session);
		
		List<PowerData> dataList = repository.selectAll();
		dataList.forEach(data -> LOG.debug("row of data -> {}", data));
		if (connector != null) {
			connector.close();
		}
		return dataList;
	}

	private Session getDBSession() {
		CassandraConnector connector = new CassandraConnector();
		connector.connect("127.0.0.1", null); // second arg is null then wil use the defatult port number
		return connector.getSession();
	}

}
