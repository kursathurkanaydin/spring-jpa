package com.kha.springboot.restdao.repository;

import com.kha.springboot.restdao.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
