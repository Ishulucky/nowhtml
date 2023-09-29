package com.insurance.Insurance.model;

import java.sql.Date;

public class InsurancePolicyCoverageMembers {
	private int iplcId;
	private int ipcmMIndex;
	private String ipcmMemberName;
	private String ipcmRelation;
	private Date ipcmDob;
	private char ipcmGender;
	private String ipcmHealthHistory;

	public int getIplcId() {
		return iplcId;
	}

	public void setIplcId(int iplcId) {
		this.iplcId = iplcId;
	}

	public int getIpcmMIndex() {
		return ipcmMIndex;
	}

	public void setIpcmMIndex(int ipcmMIndex) {
		this.ipcmMIndex = ipcmMIndex;
	}

	public String getIpcmMemberName() {
		return ipcmMemberName;
	}

	public void setIpcmMemberName(String ipcmMemberName) {
		this.ipcmMemberName = ipcmMemberName;
	}

	public String getIpcmRelation() {
		return ipcmRelation;
	}

	public void setIpcmRelation(String ipcmRelation) {
		this.ipcmRelation = ipcmRelation;
	}

	public Date getIpcmDob() {
		return ipcmDob;
	}

	public void setIpcmDob(Date ipcmDob) {
		this.ipcmDob = ipcmDob;
	}

	public char getIpcmGender() {
		return ipcmGender;
	}

	public void setIpcmGender(char ipcmGender) {
		this.ipcmGender = ipcmGender;
	}

	public String getIpcmHealthHistory() {
		return ipcmHealthHistory;
	}

	public void setIpcmHealthHistory(String ipcmHealthHistory) {
		this.ipcmHealthHistory = ipcmHealthHistory;
	}

}
