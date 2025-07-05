package com.kha.springboot.restdao.service;

import com.kha.springboot.restdao.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee findEmployeeById(int id);
    Employee updateEmployee(Employee employee);
    Employee saveEmployee(Employee employee);
    void deleteEmployeeById(int id);
}
