package com.ssi.entities;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Customer {
 @Id
	private String cid;
 
	private String cname;
    private String cpassword;
	private String caddress;
	private String cemail;
	private String cmobile;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCmobile() {
		return cmobile;
	}
	public void setCmobile(String cmobile) {
		this.cmobile = cmobile;
	}
	
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", caddress="
				+ caddress + ", cemail=" + cemail + ", cmobile=" + cmobile
				+ "]";
	}
	
	
}


   