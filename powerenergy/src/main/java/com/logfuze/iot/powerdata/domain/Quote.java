package com.logfuze.iot.powerdata.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@NoArgsConstructor
public class Quote {

	private String type;
    private Value value;
    
	/*
	 * @Override public String toString() { return "Quote{" + "type='" + type + '\''
	 * + ", value=" + value + '}'; }
	 */
}
