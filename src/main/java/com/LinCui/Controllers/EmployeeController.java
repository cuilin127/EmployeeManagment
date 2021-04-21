package com.LinCui.Controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.LinCui.Beans.Employee;
import com.LinCui.Repositories.EmployeeRepository;

@RestController

public class EmployeeController {
	@Autowired
	private EmployeeRepository eRepo;
	
	
//	private void generateEmployees() {
//		for(int i=0;i<10;i++) {
//			eRepo.save(new Employee("Employee"+i));
//		}
//	}

	@GetMapping("/")
	public String home() {
		//generateEmployees();
		return "<h1>Successfully create Employees</h1>";
	}
	

	@GetMapping(path="/employees", produces = "application/json")
	public List<Employee> getEmployeeList() {
		return eRepo.findAll();
	}
	@PostMapping(value="/employees",consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
		

         
        eRepo.save(employee);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{employee.getId()}")
                                    .buildAndExpand(employee.getId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();

	}

}
