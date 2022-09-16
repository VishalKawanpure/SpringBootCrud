package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from Employee where name=?", nativeQuery = true)
	List<Employee> getEmployeeByName(String employeeName);

	@Query(value = "select * from Employee where city=?", nativeQuery = true)
	List<Employee> getEmployeeByCity(String employeeCity);

}
