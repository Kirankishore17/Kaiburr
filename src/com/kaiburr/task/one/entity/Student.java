package com.kaiburr.task.one.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="language")
	private String language;
	
	@Column(name="framework")
	private  String framework;
	
	public Student() {
		id = 0;
		name = "";
		language = "";
		framework = "";
	}

	public Student(String name, String language, String framework) {
		super();
		this.name = name;
		this.language = language;
		this.framework = framework;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", language=" + language + ", framework=" + framework + "]";
	}
		
	
}
