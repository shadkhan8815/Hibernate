package com.rays.subclasswithdiscriminator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TablePerClassDiscriminator {
	
	public static void main(String[] args) {
		
		CreditCardPayment ccp = new CreditCardPayment();
		ccp.setAmount(5500);
		ccp.setPaymentType("CREDIT CARD");
		ccp.setCcType("RUPAY");

		Cash c = new Cash();
		c.setAmount(65000);
		c.setPaymentType("UPI");

		Cheque ch = new Cheque();
		ch.setAmount(75000);
		ch.setPaymentType("CHEQUE");
		ch.setBankName("BANDHAN");
		ch.setChqNumber("BDN0410");

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
