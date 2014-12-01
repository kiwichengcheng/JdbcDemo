package com.reuters.cc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.reuters.cc.model.UserDetailsOneToOne;
import com.reuters.cc.model.Vehicle;

public class HibernateOneToOneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetailsOneToOne user = new UserDetailsOneToOne();
		user.setUsername("First User");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		SessionFactory sessionFactory = context.getBean("sessionFactory",SessionFactory.class);
		Session session = sessionFactory.openSession();
		
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		
		session.beginTransaction().commit();
		session.close();
	}

	
	
}
