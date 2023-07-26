package io.atractor.comic.collector.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.atractor.comic.collector.domain.model.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Integer>{

}
