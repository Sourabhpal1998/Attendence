package com.sourabh.service;

import com.sourabh.entity.EmployeeDetails;

public interface EmployeeDetailsService {
	
	public EmployeeDetails findSalary(Long id);
	
	public EmployeeDetails saveEmployee(EmployeeDetails employeeDetails);
	
	public String attendence(Long id);
	
	public String exitTime(Long id);
	

}
