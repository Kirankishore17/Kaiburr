package com.kaiburr.task.one;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kaiburr.task.one.entity.Student;


public class CreateStudent {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("creating student object");
			
			Student temp = new Student("kk", "java", "react");
			
			session.beginTransaction();
			
			System.out.println("saving object");
			session.save(temp);
			
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			factory.close();
		}
		
	}

}
