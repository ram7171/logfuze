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
        		append("time text,").append("dtm text,").append("seq text,").append("sig text,").append("msg text,").
        		append("ghstatus text,").append("gh1 text,").append("gh2 text,").append("gh3 text,").append("rsstatus text,").append("rs1 text,").
        		append("rs2 text,").append("rs3 text);");

        final String query = sb.toString();
        session.execute(query);
    }

    public void insertPowerData(PowerData data) {
        StringBuilder sb = new StringBuilder().append("INSERT INTO ").append(TABLE_NAME).
        		append("(id, time, dtm, seq, sig, msg, ghstatus, gh1, gh2, gh3, rsstatus, rs1,rs2,rs3)").append("VALUES (").
        		append(data.getId()).append(", '").append(data.getTime()).append("', '").append(data.getDtm()).append("', '").
        		append(data.getSeq()).append("', '").append(data.getSig()).append("', '").
        		append(data.getMsg()).append("', '").append(data.getGhstatus()).append("', '").append(data.getGh1()).append("', '").
        		append(data.getGh2()).append("', '").append(data.getGh3()).append("', '").append(data.getRsstatus()).append("', '").
        		append(data.getRs1()).append("', '").append(data.getRs2()).append("', '").append(data.getRs3()).append("');"
        				
        				);

        final String query = sb.toString();
        session.execute(query);
    }
    
    public List<PowerData> selectAll() {
        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(TABLE_NAME);

        final String query = sb.toString();
        ResultSet rs = session.execute(query);

        List<PowerData> dataList = new ArrayList<>();

        for (Row row : rs) {
        	PowerData data = new PowerData(row.getUUID("id"), row.getString("time"), row.getString("dtm"), row.getString("seq"),
        			row.getString("sig"), row.getString("msg"), row.getString("ghstatus"), row.getString("gh1"), row.getString("gh2"),
        			row.getString("gh3"), row.getString("rsstatus"),row.getString("rs1"),row.getString("rs2"),row.getString("rs3"));
        	dataList.add(data);
        }
        return dataList;
    }

    
}
