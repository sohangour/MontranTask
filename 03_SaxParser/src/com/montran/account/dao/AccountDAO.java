package com.montran.account.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.montran.account.bean.Account;

import com.montran.account.util.SessionFactoryutil;

public class AccountDAO {

	private Session session;
	private Transaction transaction;

	public void addAccount(Account account) {
		session = SessionFactoryutil.getSessionFactory().openSession();

		transaction = session.beginTransaction();
		session.save(account);
		transaction.commit();

		session.close();

	}
}
