package com.montran.account.bean;

public class Account {

	private long accountNumber;
	private String bsrCode;
	private String entityCode;
	private String ahName;
	private String accountType;
	private int schemeCode;
	private String schemeName;
	private int stateCode;
	private char dataRequird;

	public long getAccountNumber() {
		return accountNumber;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", bsrCode=" + bsrCode + ", entityCode=" + entityCode
				+ ", ahName=" + ahName + ", accountType=" + accountType + ", schemeCode=" + schemeCode + ", schemeName="
				+ schemeName + ", stateCode=" + stateCode + ", dateRequird=" + dataRequird + "]";
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBsrCode() {
		return bsrCode;
	}

	public void setBsrCode(String bsrCode) {
		this.bsrCode = bsrCode;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	public String getAhName() {
		return ahName;
	}

	public void setAhName(String ahName) {
		this.ahName = ahName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(int schemeCode) {
		this.schemeCode = schemeCode;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	public char getDataRequird() {
		return dataRequird;
	}

	public void setDataRequird(char dataRequird) {
		this.dataRequird = dataRequird;
	}

}
