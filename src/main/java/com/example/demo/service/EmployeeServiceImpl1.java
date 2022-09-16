package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.model.Employee;

@Service
public class EmployeeServiceImpl1 implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return this.employeeRepository.findAll();
	}

	@Override
	public List<Employee> getEmployeeByName(String employeeName) {
		return this.employeeRepository.getEmployeeByName(employeeName);
	}

	@Override
	public List<Employee> getEmployeeByCity(String employeeCity) {
		return this.employeeRepository.getEmployeeByCity(employeeCity);
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer employeeId) {
		Optional<Employee> findById = this.employeeRepository.findById(employeeId);
		return findById;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Employee updateEmployeeById(Integer employeeId, Employee employee) {

		Employee byId = this.employeeRepository.getById(employeeId);

		byId.setId(employee.getId());
		byId.setName(employee.getName());
		byId.setCity(employee.getCity());
		Employee save = this.employeeRepository.save(byId);
		return save;
	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		this.employeeRepository.deleteById(employeeId);

	}

}
