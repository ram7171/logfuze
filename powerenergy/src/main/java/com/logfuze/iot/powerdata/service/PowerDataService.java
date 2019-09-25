package com.logfuze.iot.powerdata.service;

import java.util.List;

import com.logfuze.iot.powerdata.domain.PowerData;

public interface PowerDataService {
	public void insertPowerData(List<PowerData> dataList);
	public List<PowerData> fetchPowerData();
//	public List<PowerData> fetchPowerData(Criteria);
}
