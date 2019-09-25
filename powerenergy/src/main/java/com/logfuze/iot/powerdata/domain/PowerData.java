package com.logfuze.iot.powerdata.domain;

import java.util.UUID;

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
	private String ebStatus1;
	private String ebStatus2;
	private String ebStatus3;
	private String ebStatus4;
	private String ebStatus5;
	private String ebStatus6;
	private String ebStatus7;
	private String ebStatus8;
	private String ebStatus9;
}
