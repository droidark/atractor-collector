package io.atractor.comic.collector.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.atractor.comic.collector.domain.model.Employee;
import io.atractor.comic.collector.domain.repository.EmployeeRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/employees")
@AllArgsConstructor
public class EmployeeController {
	
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public Iterable<Employee> retrieveAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

}
