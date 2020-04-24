package com.capgemini.backgroundverification.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.type.DateType;

@Entity
@Table(name= "Verification")
public class Verification {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int verId;
	private DateType StartDate;
	private DateType EndDate;
	private String status;
	
	
	@OneToOne(cascade=CascadeType.ALL)   
	@JoinColumn(name="userId")
	private Logindata logindata;
	
	@OneToOne(cascade=CascadeType.ALL)   
	@JoinColumn(name="id")
	private FileModel filemodel;
	
	
	
	public int getVerId() {
		return verId;
	}
	public void setVerId(int verId) {
		this.verId = verId;
	}
	
	
	public DateType getStartDate() {
		return StartDate;
	}
	public void setStartDate(DateType startDate) {
		StartDate = startDate;
	}
	public DateType getEndDate() {
		return EndDate;
	}
	public void setEndDate(DateType endDate) {
		EndDate = endDate;
	}
	public Logindata getLogindata() {
		return logindata;
	}
	public void setLogindata(Logindata logindata) {
		this.logindata = logindata;
	}
	public FileModel getFilemodel() {
		return filemodel;
	}
	public void setFilemodel(FileModel filemodel) {
		this.filemodel = filemodel;
	}
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}