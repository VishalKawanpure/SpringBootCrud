package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	List<Employee> getAllEmployee();

	List<Employee> getEmployeeByName(String employeeName);

	List<Employee> getEmployeeByCity(String employeeCity);

	Optional<Employee> getEmployeeById(Integer employeeId);

	Employee updateEmployeeById(Integer employeeId, Employee employee);

	void deleteEmployeeById(Integer employeeId);

}
