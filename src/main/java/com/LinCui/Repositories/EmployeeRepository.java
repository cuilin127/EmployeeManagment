package com.LinCui.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.LinCui.Beans.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	 Employee findById(long id);
	 List<Employee> findAll();
}
