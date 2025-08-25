package com.rays.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.auction.AuctionItem;
import com.rays.auction.Bid;

public class TestTransitivePersistance {
	
	public static void main(String[] args) {
		
		Bid b = new Bid();
		
		b.setId(4);
		b.setAmount(4000);
		b.setTimeStamp("AAAA");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		AuctionItem item = (AuctionItem) session.get(AuctionItem.class, 1);
		Set s = item.getBids();
		s.add(b);
		tx.commit();
		session.close();
	}

}
