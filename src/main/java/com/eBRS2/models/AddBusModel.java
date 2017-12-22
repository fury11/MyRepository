package com.eBRS2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "business")
public class AddBusModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "BNAME") 
	private String txta;
	
	@Column(name = "OWNER") 
	private String txtb;
	
	@Column(name = "BTYPE") 
	private String txtc;
	
	@Column(name = "BFROM") 
	private String txtd;
	
	@Column(name = "BTO") 
	private String txte;
	
	@Column(name = "ADDRESS") 
	private String txtf;
	
	@Column(name = "BRGY") 
	private String txtg;
	
	@Column(name = "BDATE") 
	private String txth;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTxta() {
		return txta;
	}

	public void setTxta(String txta) {
		this.txta = txta;
	}

	public String getTxtb() {
		return txtb;
	}

	public void setTxtb(String txtb) {
		this.txtb = txtb;
	}

	public String getTxtc() {
		return txtc;
	}

	public void setTxtc(String txtc) {
		this.txtc = txtc;
	}

	public String getTxtd() {
		return txtd;
	}

	public void setTxtd(String txtd) {
		this.txtd = txtd;
	}

	public String getTxte() {
		return txte;
	}

	public void setTxte(String txte) {
		this.txte = txte;
	}

	public String getTxtf() {
		return txtf;
	}

	public void setTxtf(String txtf) {
		this.txtf = txtf;
	}

	public String getTxtg() {
		return txtg;
	}

	public void setTxtg(String txtg) {
		this.txtg = txtg;
	}

	public String getTxth() {
		return txth;
	}

	public void setTxth(String txth) {
		this.txth = txth;
	}
	
	
	
	
	
}
