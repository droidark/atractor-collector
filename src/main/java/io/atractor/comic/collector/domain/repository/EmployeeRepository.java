package io.atractor.comic.collector.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.atractor.comic.collector.domain.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
