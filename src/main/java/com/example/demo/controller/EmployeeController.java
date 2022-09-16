package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeServiceImpl1;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl1 EmployeeServiceImpl;

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

		Employee addEmployee = this.EmployeeServiceImpl.addEmployee(employee);

		return ResponseEntity.ok(addEmployee);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> allEmployee = this.EmployeeServiceImpl.getAllEmployee();

		return ResponseEntity.ok(allEmployee);
	}

	@GetMapping("/byName/{employeeName}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@RequestBody @PathVariable String employeeName) {

		List<Employee> employeeByName = this.EmployeeServiceImpl.getEmployeeByName(employeeName);
		return ResponseEntity.ok(employeeByName);

	}

	@GetMapping("/byCity/{employeeCity}")
	public ResponseEntity<List<Employee>> getEmployeeByCity(@RequestBody @PathVariable String employeeCity) {
		List<Employee> employeeByCity = this.EmployeeServiceImpl.getEmployeeByCity(employeeCity);
		return ResponseEntity.ok(employeeByCity);

	}

	@GetMapping("/byId/{employeeId}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@RequestBody @PathVariable Integer employeeId) {
		Optional<Employee> employeeById = this.EmployeeServiceImpl.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeById);

	}

	@PutMapping("/update/{employeeId}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable Integer employeeId,
			@RequestBody Employee employee) {
		Employee updateEmployeeById = this.EmployeeServiceImpl.updateEmployeeById(employeeId, employee);
		return ResponseEntity.ok(updateEmployeeById);
	}

	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<String> deleteEmployeeById(@RequestBody @PathVariable Integer employeeId) {
		this.EmployeeServiceImpl.deleteEmployeeById(employeeId);

		return ResponseEntity.ok("Deleted Successfully");

	}

}
