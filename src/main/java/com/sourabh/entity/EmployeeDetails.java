package com.sourabh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "salary")
	private int salary;
	
	@Column(name = "daily_wages")
	private int dailySalary;
	
	public EmployeeDetails() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDailySalary() {
		return dailySalary;
	}

	public void setDailySalary(int dailySalary) {
		this.dailySalary = dailySalary;
	}

	public EmployeeDetails(Long id, String employeeName, String role, int salary, int dailySalary) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.role = role;
		this.salary = salary;
		this.dailySalary = dailySalary;
	}
	
	


}
