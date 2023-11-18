package io.atractor.comic.collector.controller;

import io.atractor.comic.collector.domain.model.Employee;
import io.atractor.comic.collector.domain.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
	
	private final EmployeeRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Employee>> retrieveAllEmployees() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> retrieveSalaryById(@PathVariable int id) {
		return ResponseEntity.ok(repository.findById(id).get());
	}
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(repository.save(employee), HttpStatus.CREATED);
	}

}
