//package com.capgemini.training.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.capgemini.training.entity.Employee;
//import com.capgemini.training.services.EmployeeServices;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class EmployeeRestController {
//
//    @Autowired
//    private EmployeeServices employeeServices;
//
//    // Get all employees
//    @GetMapping("/allemp")
//    public List<Employee> getAllEmployee() {
//        return employeeServices.getAllEmployees();
//    }
//}
package com.capgemini.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.entity.Employee;
import com.capgemini.training.services.EmployeeServices;
import java.util.*;


@RestController
@RequestMapping("/api/")

public class EmployeeRestController {
		
	@Autowired
	EmployeeServices employeeServices; 
	
	//Get all Employees
	@GetMapping("/allemp")
	public List<Employee> getAllEmployee(){
		return employeeServices.getAllEmployees();
	}
	
	//Get Single Employee
	@GetMapping("/getemp/{id}")
	public Employee getSingleEmployee(@PathVariable int id) {
	    return employeeServices.getSingleEmpInfo(id);
	}
	
	
	//Post Single Employee
	@PostMapping("/createemp")
	public Employee registerEmp(@RequestBody Employee emp) {
		
		Employee empdata = employeeServices.saveEmployee(emp);
		
	    return empdata;
	}
	//Update API
	@PutMapping("/updateemp/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
	    return employeeServices.updateEmployee(id, emp);
	}
	//Delete API
	@DeleteMapping("/deleteemp/{id}")
	public Map<String, Object> deleteEmployee(@PathVariable int id) {

	    Map<String, Object> response = new HashMap<>();

	    boolean deleted = employeeServices.deleteEmployee(id);

	    if (deleted) {
	        response.put("status", "success");
	        response.put("message", "Employee deleted successfully");
	    } else {
	        response.put("status", "error");
	        response.put("message", "Employee not found");
	    }

	    return response;
	}
	
	
	
	
	
	
	
	
}