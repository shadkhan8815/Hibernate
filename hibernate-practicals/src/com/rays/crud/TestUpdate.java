package com.rays.crud;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestUpdate {
	
	public static void main(String[] args) {
		
		UserDTO dto = new UserDTO();
		
		dto.setId(1);
		dto.setFirstName("Yusuf");
		dto.setLastName("Khan");
		dto.setLoginId("yusuf@gmail.com");
		dto.setPassword("4321");
		dto.setAddress("Bhopal");
		dto.setDob(new Date());
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(dto);
		
		tx.commit();
		session.close();
	}

}
