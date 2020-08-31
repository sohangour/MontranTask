package com.montran.account.handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.montran.account.bean.Account;
import com.montran.account.bean.AccountDetails;

public class AccountHandler extends DefaultHandler {
	private List<AccountDetails> accounts = null;
	private Account account = null;
	private AccountDetails accountDetails = null;
	private StringBuilder data = null;

	public Account getAccount() {
		return account;
	}

	private boolean baccountNumber = false;
	private boolean bsrCode = false;
	private boolean bentityCode = false;
	private boolean bahName = false;
	private boolean baccountType = false;
	private boolean bschemeCode = false;
	private boolean bschemeName = false;
	private boolean bstateCode = false;
	private boolean bdataRequired = false;

	public List<AccountDetails> getAccounts() {
		return accounts;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (accounts == null)
			accounts = new ArrayList<AccountDetails>();
		data = new StringBuilder();

		if (qName.equalsIgnoreCase("Accounts")) {
			account = new Account();
			System.out.println();
			System.out.println("MessageId:" + attributes.getValue("MessageId"));
			System.out.println("Source:" + attributes.getValue("Source"));
			System.out.println("Destination:" + attributes.getValue("Destination"));
			System.out.println("Bank Code:" + attributes.getValue("BankCode"));
			System.out.println("Bank Name:" + attributes.getValue("BankName"));
			System.out.println("Record Counts:" + attributes.getValue("RecordsCount"));

			account.setMessageId(attributes.getValue("MessageId"));
			account.setSource(attributes.getValue("Source"));
			account.setDestination(attributes.getValue("BankCode"));
			account.setBankCode(attributes.getValue("BankCode"));
			account.setBankName(attributes.getValue("BankName"));

		} else if (qName.equalsIgnoreCase("Account")) {
			accountDetails = new AccountDetails();
		} else if (qName.equalsIgnoreCase("AccountNumber")) {
			baccountNumber = true;
		} else if (qName.equalsIgnoreCase("bsrCode")) {
			bsrCode = true;
		} else if (qName.equalsIgnoreCase("entityCode")) {
			bentityCode = true;
		} else if (qName.equalsIgnoreCase("ahName")) {
			bahName = true;

		} else if (qName.equalsIgnoreCase("accountType")) {
			baccountType = true;
		} else if (qName.equalsIgnoreCase("schemeCode")) {
			bschemeCode = true;

		} else if (qName.equalsIgnoreCase("schemeName")) {
			bschemeName = true;
		}

		else if (qName.equalsIgnoreCase("stateCode")) {
			bstateCode = true;

		} else if (qName.equalsIgnoreCase("DataRequired")) {
			bdataRequired = true;
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (baccountNumber) {
			accountDetails.setAccountNumber(Long.valueOf(data.toString()));
			baccountNumber = false;
		} else if (bsrCode) {
			accountDetails.setBsrCode(data.toString());
			bsrCode = false;
		} else if (bentityCode) {
			accountDetails.setEntityCode(data.toString());
			bentityCode = false;
		} else if (bahName) {
			accountDetails.setAhName(data.toString());
			bahName = false;
		} else if (baccountType) {
			accountDetails.setAccountType(data.toString());
			baccountType = false;
		} else if (bschemeCode) {
			accountDetails.setSchemeCode(Integer.valueOf(data.toString()));
			bschemeCode = false;
		} else if (bschemeName) {
			accountDetails.setSchemeName(data.toString());
			bschemeName = false;
		} else if (bstateCode) {
			accountDetails.setStateCode(Integer.valueOf(data.toString()));
			bstateCode = false;

		} else if (bdataRequired) {
			accountDetails.setDataRequired(data.toString().charAt(0));
			bdataRequired = false;
		}
		if (qName.equalsIgnoreCase("Account")) {
			accounts.add(accountDetails);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));

	}
}
