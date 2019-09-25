package com.logfuze.iot.powerdata.repository;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.logfuze.iot.powerdata.domain.PowerData;

public class PowerDataRepository {
	private static final String TABLE_NAME = "powerdata";
	
	private Session session;
	
	public PowerDataRepository(Session session) {
		this.session = session;
	}
	
	/**
     * Creates the books table.
     */
    public void createTable() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ").append(TABLE_NAME).append("(").append("id uuid PRIMARY KEY, ").
        		append("time text,").append("ebStatus1 text,").append("ebStatus2 text,").append("ebStatus3 text,").append("ebStatus4 text,").
        		append("ebStatus5 text,").append("ebStatus6 text,").append("ebStatus7 text,").append("ebStatus8 text,").append("ebStatus9 text);");

        final String query = sb.toString();
        session.execute(query);
    }

    public void insertPowerData(PowerData data) {
        StringBuilder sb = new StringBuilder().append("INSERT INTO ").append(TABLE_NAME).
        		append("(id, time, ebStatus1, ebStatus2, ebStatus3, ebStatus4, ebStatus5, ebStatus6, ebStatus7, ebStatus8, ebStatus9)").append("VALUES (").
        		append(data.getId()).append(", '").append(data.getTime()).append("', '").append(data.getEbStatus1()).append("', '").
        		append(data.getEbStatus2()).append("', '").append(data.getEbStatus3()).append("', '").
        		append(data.getEbStatus4()).append("', '").append(data.getEbStatus5()).append("', '").append(data.getEbStatus6()).append("', '").
        		append(data.getEbStatus7()).append("', '").append(data.getEbStatus8()).append("', '").append(data.getEbStatus9()).append("');");

        final String query = sb.toString();
        session.execute(query);
    }
    
    public List<PowerData> selectAll() {
        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(TABLE_NAME);

        final String query = sb.toString();
        ResultSet rs = session.execute(query);

        List<PowerData> dataList = new ArrayList<>();

        for (Row row : rs) {
        	PowerData data = new PowerData(row.getUUID("id"), row.getString("time"), row.getString("ebStatus1"), row.getString("ebStatus2"),
        			row.getString("ebStatus3"), row.getString("ebStatus4"), row.getString("ebStatus5"), row.getString("ebStatus6"), row.getString("ebStatus7"),
        			row.getString("ebStatus8"), row.getString("ebStatus9"));
        	dataList.add(data);
        }
        return dataList;
    }

    
}
