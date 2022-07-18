package com.sourabh.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attendence")
public class Attendence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "check_in")
	private Date checkIn;
	
	@Column(name = "check_out")
	private Date checkout;
	
	@Column(name = "total_present_day")
	private int totalPresentDay;
	
	@Column(name = "total_hour")
	private int totalHour;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	private EmployeeDetails employeeId;
	
	public Attendence() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public int getTotalPresentDay() {
		return totalPresentDay;
	}

	public void setTotalPresentDay(int totalPresentDay) {
		this.totalPresentDay = totalPresentDay;
	}

	public int getTotalHour() {
		return totalHour;
	}

	public void setTotalHour(int totalHour) {
		this.totalHour = totalHour;
	}

	public EmployeeDetails getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeeDetails employeeId) {
		this.employeeId = employeeId;
	}

	public Attendence(Long id, Date date, Date checkIn, Date checkout, int totalPresentDay, int totalHour,
			EmployeeDetails employeeId) {
		super();
		this.id = id;
		this.date = date;
		this.checkIn = checkIn;
		this.checkout = checkout;
		this.totalPresentDay = totalPresentDay;
		this.totalHour = totalHour;
		this.employeeId = employeeId;
	}

	
	
	

	
	
	
	
	

}
