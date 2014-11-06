package com.reuters.cc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.reuters.cc.dao.HibernateDaoImpl;
import com.reuters.cc.dao.SimpleJdbcDaoImpl;
import com.reuters.cc.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//SimpleJdbcDaoImpl dao = context.getBean("simpleJdbcDaoImpl",SimpleJdbcDaoImpl.class);
		
		
		HibernateDaoImpl dao = context.getBean("hibernateDaoImpl",HibernateDaoImpl.class);
		
		//Circle circle = dao.getCircle(1);
		
		//System.out.println(circle.getId()+":"+circle.getName());
		
		//dao.insertCircle(new Circle(3,"Third Circle"));
		
		System.out.println(dao.getCircleCount());
		
		
		//dao.createTriangleTable();
	}

}
