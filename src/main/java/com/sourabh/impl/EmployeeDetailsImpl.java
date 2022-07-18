package com.sourabh.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourabh.entity.Attendence;
import com.sourabh.entity.EmployeeDetails;
import com.sourabh.exception.ResourceNotFoundException;
import com.sourabh.repoisitory.AttendenceRepoisitory;
import com.sourabh.repoisitory.EmployeeDetailsRepoisitory;
import com.sourabh.service.EmployeeDetailsService;

@Service
public class EmployeeDetailsImpl implements EmployeeDetailsService {
	
	@Autowired
	private EmployeeDetailsRepoisitory employeeDetailsRepoisitory;
	
	@Autowired
	private AttendenceRepoisitory attendenceRepoisitory;
	
	
	

	@Override
	public EmployeeDetails findSalary(Long id) {
		EmployeeDetails employeeDetails = employeeDetailsRepoisitory.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
	
		int totalSalary = 0;
		
		if(employeeDetails.getRole().equals("permanet")) {
			Attendence attendence = attendenceRepoisitory.findByEmployeeId(id);
			
			if(attendence == null)
				throw new ResourceNotFoundException("Employee id is invalid");
			
			totalSalary = (attendence.getTotalPresentDay())*(employeeDetails.getDailySalary());
			employeeDetails.setSalary(totalSalary);
			employeeDetailsRepoisitory.save(employeeDetails);
		}
		else {
			Attendence attendence = attendenceRepoisitory.findByEmployeeId(id);
			
			if(attendence == null)
				throw new ResourceNotFoundException("Employee id is invalid");
			
			totalSalary = attendence.getTotalHour()*employeeDetails.getDailySalary();
			employeeDetails.setSalary(totalSalary);
			employeeDetailsRepoisitory.save(employeeDetails);
		}
		
		return employeeDetails;
	}
	
	
	
	

	@Override
	public EmployeeDetails saveEmployee(EmployeeDetails employeeDetails) {
		return employeeDetailsRepoisitory.save(employeeDetails);
	}
	
	
	

	@Override
	public String attendence(Long id) {
		Attendence attendence = attendenceRepoisitory.findByEmployeeId(id);
		
		if(attendence == null)
			throw new ResourceNotFoundException("Employee id is invalid");
		
		
		int count = 0;
		int present = 1;
		
		
		int total=0;
		total = (attendence.getCheckout().getHours())-(attendence.getCheckIn().getHours());
		
		count = attendence.getTotalPresentDay()+ present;
		attendence.setCheckIn(new Date());
		attendence.setDate(new Date());
		attendence.setTotalPresentDay(count);
		
		int counts = attendence.getTotalHour()+total;
		attendence.setTotalHour(counts);
		
		attendenceRepoisitory.save(attendence);
		
		return "Present";
	}
	
	
	
	

	@Override
	public String exitTime(Long id) {
		Attendence attendence = attendenceRepoisitory.findByEmployeeId(id);
		
		if(attendence == null)
			throw new ResourceNotFoundException("Employee id is invalid");
		
		
		attendence.setCheckout(new Date());
		attendenceRepoisitory.save(attendence);
		return "Done";
	}

}
