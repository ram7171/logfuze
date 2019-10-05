package com.logfuze.iot.powerdata.domain;

import java.util.UUID;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@SuppressWarnings("unused")
@ToString
public class PowerData {

	private UUID id;
	private String time;
	
	private String dtm;
	private String seq;
	private String sig;
	private String msg;
	private String ghstatus;
	private String gh1;
	private String gh2;
	private String gh3;
	private String rsstatus;
	private String rs1;
	private String rs2;
	private String rs3;
}
