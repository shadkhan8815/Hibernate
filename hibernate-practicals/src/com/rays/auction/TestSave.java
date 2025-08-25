package com.rays.auction;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestSave {
	
	public static void main(String[] args) {
		
		Bid bid1 = new Bid();
		
		bid1.setId(1);
		bid1.setAmount(500);
		bid1.setTimeStamp("A");
		
		Bid bid2 = new Bid();
		
		bid2.setId(2);
		bid2.setAmount(1000);
		bid2.setTimeStamp("AA");
		
		Bid bid3 = new Bid();
		
		bid3.setId(3);
		bid3.setAmount(1500);
		bid3.setTimeStamp("AAA");
		
		Set bids = new HashSet();
		
		bids.add(bid1);
		bids.add(bid2);
		bids.add(bid3);
		
		AuctionItem at = new AuctionItem();
		
		at.setId(1);
		at.setDescription("Auction 1");
		at.setBids(bids);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(at);
		tx.commit();
		session.close();
	}

}
