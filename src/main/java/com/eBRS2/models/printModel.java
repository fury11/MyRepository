package com.eBRS2.models;

import java.sql.Date;

public class printModel {
	
	private String txtcategory;
	private String txtsearch;
	private String txtbrgy;
	private Date txtfrom;
	private Date txtto;
	
	public String getTxtcategory() {
		return txtcategory;
	}
	public void setTxtcategory(String txtcategory) {
		this.txtcategory = txtcategory;
	}
	public String getTxtsearch() {
		return txtsearch;
	}
	public void setTxtsearch(String txtsearch) {
		this.txtsearch = txtsearch;
	}
	public String getTxtbrgy() {
		return txtbrgy;
	}
	public void setTxtbrgy(String txtbrgy) {
		this.txtbrgy = txtbrgy;
	}
	public Date getTxtfrom() {
		return txtfrom;
	}
	public void setTxtfrom(Date txtfrom) {
		this.txtfrom = txtfrom;
	}
	public Date getTxtto() {
		return txtto;
	}
	public void setTxtto(Date txtto) {
		this.txtto = txtto;
	}
	
	
}
