package com.rays.crud;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestSave {

	public static void main(String[] args) {

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("Akbar");
		dto.setLastName("Mansuri");
		dto.setLoginId("akbar@gmail.com");
		dto.setAddress("Indore");
		dto.setPassword("1234");
		dto.setDob(new Date());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dto);

		tx.commit();
		session.close();

	}

}
