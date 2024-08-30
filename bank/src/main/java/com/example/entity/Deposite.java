package com.example.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Table(name = "deposite")
@Entity
public class Deposite {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	private int id;
	private double account;
	private String ifsc;
	private double amount;
	private double balance;
	
	
	
	private String  time;
	
	
	public Deposite() {}


	public Deposite(int id, double account, String ifsc, double amount, double balance, String time) {
		super();
		this.id = id;
		this.account = account;
		this.ifsc = ifsc;
		this.amount = amount;
		this.balance = balance;
		this.time = time;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getAccount() {
		return account;
	}


	public void setAccount(double account) {
		this.account = account;
	}


	public String getIfsc() {
		return ifsc;
	}


	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "Deposite [id=" + id + ", account=" + account + ", ifsc=" + ifsc + ", amount=" + amount + ", balance="
				+ balance + ", time=" + time + "]";
	}


	


	
	
}