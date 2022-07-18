package com.sourabh.repoisitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sourabh.entity.EmployeeDetails;

@Repository
public interface EmployeeDetailsRepoisitory extends JpaRepository<EmployeeDetails, Long> {

}
