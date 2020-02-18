package com.kaiburr.task.one;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaiburr.task.one.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student",theStudent);
		
		return "student-form";
	}
	
	@RequestMapping("/addEntry")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("creating student object");
			
			//Student temp = new Student("kk", "java", "react");
			
			session.beginTransaction();
			
			System.out.println("saving object");
			session.save(theStudent);
			
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			factory.close();
		}
		
		return "student-confirmation";
	}
	
	@RequestMapping("/deleteEntry")
	public String deleteInfo(HttpServletRequest request, Model theModel) {
		String s = request.getParameter("id");
		System.out.println(s);
		Integer num = Integer.parseInt(s);
		Student theStudent = new Student();
		theModel.addAttribute("student",theStudent);
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("deleting info from table");
						
			session.beginTransaction();
			/*
			System.out.println("________________________\n");
			List<Student> list = session.createQuery("from student s where s.id=num", Student.class).getResultList();
			for(Student d:list) {
				System.out.println(d);
			}
			*/
			Student mystudent = session.get(Student.class, num);

			session.delete(mystudent);
			System.out.println(mystudent);
			
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			factory.close();
		}
		
		return "show-details";
	}
	
	@RequestMapping("/showDetails")
	public String showDetails(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student",theStudent);
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("getting info from table");
						
			session.beginTransaction();
			
			List<Student> list = session.createQuery("from Student").getResultList();
			theModel.addAttribute("list", list);
			System.out.println(list.size());
			for(Student d:list) {
				System.out.println(">>>>>> " + d);
			}
			
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			factory.close();
		}

		
		return "show-details";
	}
	
	@RequestMapping("/id")
	public String showId(Model theModel) {
		//String s = request.getParameter("id");
		//System.out.println(s);
		return "get-id";
	}
	
	
}
