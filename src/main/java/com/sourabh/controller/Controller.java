package com.sourabh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourabh.entity.EmployeeDetails;
import com.sourabh.service.EmployeeDetailsService;

@RestController
public abstract class Controller {
	
	@Autowired
	private EmployeeDetailsService employeeDetailsService;
	
	
	@GetMapping("/find/salary/{id}")
    public EmployeeDetails findSalary(Long id) {
		 return employeeDetailsService.findSalary(id);
	}
	
	@PostMapping("/save/employee")
	public EmployeeDetails saveEmployee(EmployeeDetails employeeDetails) {
		return employeeDetailsService.saveEmployee(employeeDetails);
	}
	
	@PutMapping("/attendence/{id}")
	public String attendence(Long id) {
		return employeeDetailsService.attendence(id);
	}
	
	@PutMapping("/exit/time/{id}")
	public String exitTime(Long id) {
		return employeeDetailsService.exitTime(id);
	}
	

	

}
