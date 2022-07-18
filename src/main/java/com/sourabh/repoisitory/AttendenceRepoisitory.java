package com.sourabh.repoisitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sourabh.entity.Attendence;

@Repository
public interface AttendenceRepoisitory extends JpaRepository<Attendence, Long> {

	Attendence findByEmployeeId(Long id);

}
