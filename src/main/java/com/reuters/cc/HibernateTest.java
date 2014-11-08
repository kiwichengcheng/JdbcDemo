package com.reuters.cc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.reuters.cc.model.UserDetails;

public class HibernateTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		SessionFactory sessionFactory = context.getBean("sessionFactory",SessionFactory.class);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
	}

}
