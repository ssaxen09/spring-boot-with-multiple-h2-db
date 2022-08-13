package com.example.sprningboote.itcomp;

import com.example.sprningboote.itcomp.repository.EmailAddress;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "employee")
@Entity
public class Employee {
	private Long id;

	private Department department;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
	}

	private EmailAddress emailAddress;

	public Employee() {

	}

	@Column(name = "age")
	public int getAge() {
		return age;
	}

	public int getSalary() {
		return salary;
	}

	public String getName() {
		return name;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "dep", columnDefinition = "ENUM('IT', 'HR', 'ADMIN', 'FINANCE', 'MANAGEMENT')")
	public Department getDepartment() {
		return department;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	private int age;
	private int salary;
	private String name;

	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
}
