package com.rays.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TablePerClassInheritance {
	
	public static void main(String[] args) {
		
		CreditCardPayment ccp = new CreditCardPayment();
		
		ccp.setAmount(1000);
		ccp.setPaymentType("IMPs");
		ccp.setCcType("VISA");
		
		Cheque ch = new Cheque();
		
		ch.setAmount(2000);
		ch.setPaymentType("DEPOSITE");
		ch.setBankName("Axis");
		ch.setChqNumber("AXS1010");
		
		Cash c = new Cash();
		
		c.setAmount(3000);
		c.setPaymentType("CASH");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(ccp);
		session.save(ch);
		session.save(c);
		
		tx.commit();
		session.close();
	}

}
