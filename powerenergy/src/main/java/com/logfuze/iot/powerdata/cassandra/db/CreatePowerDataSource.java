package com.logfuze.iot.powerdata.cassandra.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.Session; 
import com.logfuze.iot.powerdata.repository.KeyspaceRepository;
import com.logfuze.iot.powerdata.repository.PowerDataRepository;

public class CreatePowerDataSource {
	
	private static final Logger LOG = LoggerFactory.getLogger(CreatePowerDataSource.class);

    public static void main(String args[]) {
        CassandraConnector connector = new CassandraConnector();
        connector.connect("127.0.0.1", null);
        Session session = connector.getSession();

        KeyspaceRepository sr = new KeyspaceRepository(session);
        sr.createKeyspace();
        sr.useKeyspace();

        PowerDataRepository br = new PowerDataRepository(session);
        br.createTable();
        connector.close();
    }
}
