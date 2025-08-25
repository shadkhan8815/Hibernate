package com.rays.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.crud.UserDTO;

public class TestFlush {
	
	public static void main(String[] args) {
		
		UserDTO dto = new UserDTO();
		
		dto.setFirstName("Sonu");
		dto.setLastName("Mev");
		dto.setLoginId("sonu@gmail.com");
		dto.setPassword("1234");
		dto.setDob(new Date());
		dto.setAddress("indore");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sessoin = sf.openSession();
		Transaction tx = sessoin.beginTransaction();
		
		sessoin.save(dto);
		sessoin.flush();
		
		dto = (UserDTO) sessoin.get(UserDTO.class, 1);
		tx.commit();
		sessoin.close();
	}

}
