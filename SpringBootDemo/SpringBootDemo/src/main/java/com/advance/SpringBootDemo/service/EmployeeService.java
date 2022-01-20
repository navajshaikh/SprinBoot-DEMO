package com.advance.SpringBootDemo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.advance.SpringBootDemo.demo.Employee;

@Service
public interface EmployeeService extends JpaRepository<Employee,Long> {

}
