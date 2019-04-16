package com.ssi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Emp {
	@Id
	private String eid;
	private String ename;
	private String emobile;
	private String Email;
	private String eaddress;
	private String esal;
	private String escheme;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmobile() {
		return emobile;
	}
	public void setEmobile(String emobile) {
		this.emobile = emobile;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public String getEsal() {
		return esal;
	}
	public void setEsal(String esal) {
		this.esal = esal;
	}
	public String getEscheme() {
		return escheme;
	}
	public void setEscheme(String escheme) {
		this.escheme = escheme;
	}
	
	
	
}
