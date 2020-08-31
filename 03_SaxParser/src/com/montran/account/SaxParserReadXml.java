package com.montran.account;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.montran.account.bean.Account;
import com.montran.account.bean.AccountDetails;
import com.montran.account.dao.AccountDAO;
import com.montran.account.handler.AccountHandler;

public class SaxParserReadXml {

	public static void main(String[] args) {
		String filePath = "C:/Users/Sohan/Downloads/022AVREQ2109201700003.xml";
		File xmlFile = new File(filePath);
		SAXParserFactory factory = SAXParserFactory.newInstance();
		AccountHandler handler = new AccountHandler();
		AccountDAO dao = new AccountDAO();
		Account account = null;
		try {
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(xmlFile, handler);
			List<AccountDetails> accounts = handler.getAccounts();
			account = handler.getAccount();
			account.setAccountDetails(accounts);
			
			dao.addAccount(account);

		} catch (ParserConfigurationException e) {

			e.printStackTrace();
		} catch (SAXException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
