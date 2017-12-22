package com.eBRS2.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "business")
public class SearchModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "BFROM") 
	private Timestamp BFROM;
	
	@Column(name = "BNAME") 
	private String busname;
	
	@Column(name = "OWNER") 
	private String owner;
	
	@Column(name = "BTYPE") 
	private String bustype;
	
	@Column(name = "BRGY") 
	private String brgy;
	
	@Column(name = "ADDRESS") 
	private String busaddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getBFROM() {
		return BFROM;
	}

	public void setBFROM(Timestamp bFROM) {
		BFROM = bFROM;
	}

	public String getBusname() {
		return busname;
	}

	public void setBusname(String busname) {
		this.busname = busname;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getBustype() {
		return bustype;
	}

	public void setBustype(String bustype) {
		this.bustype = bustype;
	}

	public String getBrgy() {
		return brgy;
	}

	public void setBrgy(String brgy) {
		this.brgy = brgy;
	}

	public String getBusaddress() {
		return busaddress;
	}

	public void setBusaddress(String busaddress) {
		this.busaddress = busaddress;
	}

	
	
}
