package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="account")

@Entity
public class Baroda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private Long account;
	private String ifscCode = "BARBOSONAJX";
	private String adhar;
	private String pan;
	private String email;
	private String mobile;
	private String adress;
	private String pin;
	public Baroda() {
		
		
	}
	public Baroda(int id, Long account, String ifscCode, String adhar, String pan, String email, String mobile,
			String adress, String pin) {
		super();
		this.id = id;
		this.account = account;
		this.ifscCode = ifscCode;
		this.adhar = adhar;
		this.pan = pan;
		this.email = email;
		this.mobile = mobile;
		this.adress = adress;
		this.pin = pin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getAccount() {
		return account;
	}
	public void setAccount(Long account) {
		this.account = account;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Baroda [id=" + id + ", account=" + account + ", ifscCode=" + ifscCode + ", adhar=" + adhar + ", pan="
				+ pan + ", email=" + email + ", mobile=" + mobile + ", adress=" + adress + ", pin=" + pin + "]";
	}
	
	
}
