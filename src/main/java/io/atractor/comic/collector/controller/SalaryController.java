package io.atractor.comic.collector.controller;

import io.atractor.comic.collector.domain.model.Salary;
import io.atractor.comic.collector.domain.repository.SalaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salaries")
@RequiredArgsConstructor
public class SalaryController {

    private final SalaryRepository repository;

    @GetMapping
    public ResponseEntity<List<Salary>> retrieveAllSalaries() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salary> retrieveSalaryById(@PathVariable int id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }
}
