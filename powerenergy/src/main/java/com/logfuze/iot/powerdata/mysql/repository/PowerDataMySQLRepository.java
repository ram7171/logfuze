package com.logfuze.iot.powerdata.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logfuze.iot.powerdata.domain.PowerDataTable;

@Repository
public interface PowerDataMySQLRepository extends JpaRepository<PowerDataTable, Long> {
	
}
