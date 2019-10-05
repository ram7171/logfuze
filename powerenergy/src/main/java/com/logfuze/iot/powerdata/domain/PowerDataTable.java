package com.logfuze.iot.powerdata.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "powerdata")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PowerDataTable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", updatable=false, nullable=false)
	private Long id;
	
	@Column(name = "dtm", unique = true, nullable = false, columnDefinition = "VARCHAR(64)")
	private String dtm;
	
	@Column(name = "seq", unique = false, nullable = true, columnDefinition = "VARCHAR(4)")
	private String seq;
	
	@Column(name = "sig", unique = false, nullable = true, columnDefinition = "VARCHAR(4)")
	private String sig;
	
	@Column(name = "msg", unique = false, nullable = true, columnDefinition = "VARCHAR(4)")
	private String msg;
	
	@Column(name = "ghstatus", unique = false, nullable = true, columnDefinition = "VARCHAR(4)")
	private String ghstatus;
	
	@Column(name = "gh1", unique = false, nullable = true, columnDefinition = "VARCHAR(4)")
	private String gh1;
	
	@Column(name = "gh2", unique = false, nullable = true, columnDefinition = "VARCHAR(4)")
	private String gh2;
	
	@Column(name = "gh3", unique = false, nullable = true, columnDefinition = "VARCHAR(4)")
	private String gh3;
	
	@Column(name = "rsstatus", unique = false, nullable = true, columnDefinition = "VARCHAR(4)")
	private String rsstatus;
	
	@Column(name = "rs1", unique = false, nullable = true, columnDefinition = "VARCHAR(4)")
	private String rs1;

	@Column(name = "rs2", unique = false, nullable = true, columnDefinition = "VARCHAR(4)")
	private String rs2;
	
	@Column(name = "rs3", unique = false, nullable = true, columnDefinition = "VARCHAR(4)")
	private String rs3;
}