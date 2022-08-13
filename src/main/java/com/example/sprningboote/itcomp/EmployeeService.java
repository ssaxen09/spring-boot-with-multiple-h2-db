package com.example.sprningboote.itcomp;

import com.example.sprningboote.itcomp.Employee;
import com.example.sprningboote.itcomp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;

	@Autowired
	EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> getEmployeesByName(String name) {
		return employeeRepository.findEmployeesByName(name);
	}

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Optional<Employee> findById(Long Id) {
		return employeeRepository.findById(Id);
	}
}
