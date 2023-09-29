package com.insurance.Insurance.model;

import java.sql.Date;

public class FormData {
	private String fName;
	private String lName;
	private Date dob;
	private String address;
	private char gender;
	private String aadhar;

	private String[] mName;
	private Date[] dob2;
	private char[] gender1;

	private String[] healthHistory;
	private String[] relationship;

	private int id;
	private int price;

	public int getSumassured() {
		return sumassured;
	}

	public void setSumassured(int sumassured) {
		this.sumassured = sumassured;
	}

	public int getPaymodecount() {
		return paymodecount;
	}

	public void setPaymodecount(int paymodecount) {
		this.paymodecount = paymodecount;
	}

	private int sumassured;
	private int paymodecount;

	public FormData() {
		super();
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String[] getmName() {
		return mName;
	}

	public void setmName(String[] mName) {
		this.mName = mName;
	}

	public Date[] getDob2() {
		return dob2;
	}

	public void setDob2(Date[] dob2) {
		this.dob2 = dob2;
	}

	public char[] getGender1() {
		return gender1;
	}

	public void setGender1(char[] gender1) {
		this.gender1 = gender1;
	}

	public String[] getHealthHistory() {
		return healthHistory;
	}

	public void setHealthHistory(String[] healthHistory) {
		this.healthHistory = healthHistory;
	}

	public String[] getRelationship() {
		return relationship;
	}

	public void setRelationship(String[] relationship) {
		this.relationship = relationship;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public FormData(String fName, String lName, Date dob, String address, char gender, String aadhar, String[] mName,
			Date[] dob2, char[] gender1, String[] healthHistory, String[] relationship, int id, int price,
			int sumassured, int paymodecount) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.dob = dob;
		this.address = address;
		this.gender = gender;
		this.aadhar = aadhar;
		this.mName = mName;
		this.dob2 = dob2;
		this.gender1 = gender1;
		this.healthHistory = healthHistory;
		this.relationship = relationship;
		this.id = id;
		this.price = price;
		this.sumassured = sumassured;
		this.paymodecount = paymodecount;
	}

}