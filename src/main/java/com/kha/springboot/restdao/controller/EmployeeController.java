package com.kha.springboot.restdao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kha.springboot.restdao.model.Employee;
import com.kha.springboot.restdao.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final ObjectMapper objectMapper;

    public EmployeeController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAll();
    }

    @GetMapping(value = "/{empId}")
    public Employee findEmployeeById(@PathVariable int empId){
        return employeeService.findEmployeeById(empId);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping(value = "/{empId}")
    public void deleteEmployeeById(@PathVariable int empId){
        employeeService.deleteEmployeeById(empId);
    }

    @PatchMapping(value = "/{empId}")
    public Employee patchEmployee(@RequestBody Map<String, Object> patchEmployee, @PathVariable int empId){
        Employee dbEmployee = employeeService.findEmployeeById(empId);
        if (dbEmployee == null){
            throw new RuntimeException("Employee Not Found with id: " + empId);
        }

        if (patchEmployee.containsKey("id")){
            throw new RuntimeException("id field is not allowed in the payload");
        }

        Employee patchedEmployee = apply(dbEmployee, patchEmployee);
        Employee savedEmployee = employeeService.updateEmployee(patchedEmployee);
        return savedEmployee;
    }

    public Employee apply(Employee dbEmployee, Map<String, Object> patchPayload){
        ObjectNode employeeNode = objectMapper.convertValue(dbEmployee, ObjectNode.class);
        ObjectNode patchedNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        employeeNode.setAll(patchedNode);
        return objectMapper.convertValue(employeeNode, Employee.class);
    }
}
