package com.rays.subclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TablePerSubClassInheritance {
	
	public static void main(String[] args) {

		CreditCardPayment ccp = new CreditCardPayment();
		ccp.setAmount(1500);
		ccp.setPaymentType("Credit Card");
		ccp.setCcType("VISA");

		Cash c = new Cash();
		c.setAmount(2500);
		c.setPaymentType("CASH");

		Cheque ch = new Cheque();
		ch.setAmount(3500);
		ch.setPaymentType("CHEQUE");
		ch.setBankName("KOTAK");
		ch.setChqNumber("KKBK10305");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(ccp);
		session.save(c);
		session.save(ch);

		tx.commit();
		session.close();
	}

}
