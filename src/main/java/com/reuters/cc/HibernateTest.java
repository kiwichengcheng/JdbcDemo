package com.reuters.cc;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.reuters.cc.model.UserDetails;

public class HibernateTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserDetails user = new UserDetails();
		user.setUserName("First User");
		user.setAddress("First User's address");
		user.setJoinedDate(new Date());
		user.setDescription("Description of the user goes here");
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("Second User");
		user2.setAddress("First User's address");
		user2.setJoinedDate(new Date());
		user2.setDescription("Description of the user goes here");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		SessionFactory sessionFactory = context.getBean("sessionFactory",SessionFactory.class);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		
		/*session.close();
		
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 1);
		
		System.out.println("User Name retrieved is "+user.getUserName());*/
	}

}
