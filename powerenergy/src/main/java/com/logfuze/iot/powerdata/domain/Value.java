package com.logfuze.iot.powerdata.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@NoArgsConstructor
public class Value {
	private Long id;
    private String quote;
    
	/*
	 * @Override public String toString() { return "Value{" + "id=" + id +
	 * ", quote='" + quote + '\'' + '}'; }
	 */
}
