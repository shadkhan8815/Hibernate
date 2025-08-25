package com.rays.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.crud.UserDTO;

public class TestSavePersist {
	
	public static void main(String[] args) {
		
		UserDTO dto = new UserDTO();
		
		dto.setFirstName("Amit");
		dto.setLastName("Kirhar");
		dto.setLoginId("amit@gmail.com");
		dto.setPassword("123");
		dto.setDob(new Date());
		dto.setAddress("indore");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		int i = (int) session.save(dto);
	//	session.persist(dto);
		
		tx.commit();
		session.close();
	}

}
