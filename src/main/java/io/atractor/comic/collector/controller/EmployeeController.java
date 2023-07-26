package io.atractor.comic.collector.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.atractor.comic.collector.domain.model.Employee;
import io.atractor.comic.collector.domain.model.Salary;
import io.atractor.comic.collector.domain.repository.EmployeeRepository;
import io.atractor.comic.collector.domain.repository.SalaryRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/employees")
@AllArgsConstructor
public class EmployeeController {
	
	private EmployeeRepository employeeRepository;
	
	private SalaryRepository salaryRepository;
	
	@GetMapping
	public List<Employee> retrieveAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Salary retrieveSalaryById(@PathVariable int id) {
		return salaryRepository.findById(id).get();
	}
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

}
