package com.example.sprningboote.itcomp.repository;

import com.example.sprningboote.itcomp.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	public List<Employee> findEmployeesByName(String name);
}
