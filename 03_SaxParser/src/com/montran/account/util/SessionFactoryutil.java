package com.montran.account.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryutil {

	private static SessionFactory sessionFactory;
	static {
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources().buildMetadata(registry).buildSessionFactory();

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
