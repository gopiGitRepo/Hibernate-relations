package com.raven.springbootonetoonemapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raven.springbootonetoonemapping.entiry.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}