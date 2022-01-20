package com.advance.SpringBootDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advance.SpringBootDemo.demo.Employee;
import com.advance.SpringBootDemo.service.EmployeeService;

@RequestMapping("/employee/api")
@RestController
public class EmployeeRestController {

	
	private EmployeeService employeService;

	@Autowired  //byname
	public void setEmployeService(EmployeeService employeService) {
		this.employeService = employeService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAll(){
		return ResponseEntity.ok(employeService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> add(@PathVariable Long id){
		return ResponseEntity.ok(employeService.findById(id).orElse(null));
	}
	
	
	@PutMapping("/")
	public ResponseEntity<Employee> add(@RequestBody Employee employee){
		return ResponseEntity.ok(employeService.save(employee));
	}
	
	@PostMapping("/")
	public  ResponseEntity<Employee> update(@RequestBody Employee employee){
		return ResponseEntity.ok(employeService.save(employee));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> delete(@PathVariable Long id){
		employeService.findById(id).ifPresent(employeService::delete);
		return ResponseEntity.ok().build();
	}	
	
}
