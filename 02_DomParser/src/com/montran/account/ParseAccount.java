package com.montran.account;

import org.w3c.dom.*;
import org.xml.sax.SAXException;


import com.montran.account.bean.Account;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParseAccount {

	public static void main(String[] args) {
		String messageId;
		String source;
		String destination;
		String bankCode;
		String bankName;
		String recordCounts;

		String filePath = "C:/Users/Sohan/Downloads/022AVREQ2109201700003.xml";
		File xmlFile = new File(filePath);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(xmlFile);
			document.getDocumentElement().normalize();
			messageId = document.getDocumentElement().getAttribute("MessageId");
			source = document.getDocumentElement().getAttribute("Source");
			destination = document.getDocumentElement().getAttribute("Destination");
			bankCode = document.getDocumentElement().getAttribute("BankCode");
			bankName = document.getDocumentElement().getAttribute("BankName");
			recordCounts = document.getDocumentElement().getAttribute("RecordsCount");

			System.out.println("MessageId:" + messageId);
			System.out.println("Source:" + source);
			System.out.println("Destination:" + destination);
			System.out.println("Bank Code:" + bankCode);
			System.out.println("Bank Name:" + bankName);
			System.out.println("Record Counts:" + recordCounts);

			NodeList nodeList = document.getDocumentElement().getElementsByTagName("Account");
			List<Account> accounts = new ArrayList<Account>();
			for (int i = 0; i < nodeList.getLength(); i++) {

				accounts.add(getAccount(nodeList.item(i)));

			}

			for (Account account:accounts) {
				System.out.println(account);
			}

		} catch (ParserConfigurationException e) {

			e.printStackTrace();
		} catch (SAXException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private static Account getAccount(Node item) {
		Account account = new Account();
		if (item.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) item;
			account.setAccountNumber(Long.valueOf(getTagValue("AccountNumber", element)));
			account.setBsrCode(getTagValue("BSRCode", element));
			account.setEntityCode(getTagValue("EntityCode", element));
			account.setAhName(getTagValue("AHName", element));

			account.setAccountType(getTagValue("AccountType", element));
			account.setSchemeCode(Integer.valueOf(getTagValue("SchemeCode", element)));
			account.setSchemeName(getTagValue("SchemeName", element));
			account.setStateCode(Integer.valueOf(getTagValue("StateCode", element)));
			account.setDataRequird((getTagValue("DataRequired", element).charAt(0)));
		}
		return account;
	}

	private static String getTagValue(String name, Element element) {
		String value = element.getElementsByTagName(name).item(0).getTextContent();
		return value;
	}

}
