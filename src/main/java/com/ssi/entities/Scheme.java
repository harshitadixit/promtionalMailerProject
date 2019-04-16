package com.ssi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Scheme {
@Id
	
	private String sid;
    private String stit;
	private String sdes;
	private String slundate;
	private String senddate;
	private String sdis;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSdes() {
		return sdes;
	}
	public void setSdes(String sdes) {
		this.sdes = sdes;
	}
	public String getSlundate() {
		return slundate;
	}
	public void setSlundate(String slundate) {
		this.slundate = slundate;
	}
	public String getSenddate() {
		return senddate;
	}
	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}
	public String getSdis() {
		return sdis;
	}
	public void setSdis(String sdis) {
		this.sdis = sdis;
		
	}
	public String getStit() {
		return stit;
	}
	public void setStit(String stit) {
		this.stit = stit;
	}
	
	
}


