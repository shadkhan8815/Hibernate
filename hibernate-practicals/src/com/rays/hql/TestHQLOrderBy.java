package com.rays.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.crud.UserDTO;

public class TestHQLOrderBy {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesssion = sf.openSession();
		Transaction tx = sesssion.beginTransaction();
		
		Query q = sesssion.createQuery("from UserDTO order by firstName");
		List list = q.list();
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			UserDTO dto = (UserDTO) it.next();
		
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLoginId());
			System.out.print("\t" + dto.getPassword());
			System.out.print("\t" + dto.getDob());
			System.out.println("\t" + dto.getAddress());
		}
		tx.commit();
		sesssion.close();
	}

}
