package com.rays.auction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestDelete {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		AuctionItem item = (AuctionItem) session.get(AuctionItem.class, 1);
	    session.delete(item);
	    tx.commit();
	    session.close();
	}

}
