package io.atractor.comic.collector.domain.repository;

import org.springframework.data.repository.CrudRepository;

import io.atractor.comic.collector.domain.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
