//package com.capgemini.training.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.capgemini.training.dao.EmployeeRepository;
//import com.capgemini.training.entity.Employee;
//
//@Service
//public class EmployeeServices {
//	
//	
//	@Autowired
//	EmployeeRepository employeeRepository;
//	
//     public List<Employee> getAllEmployees(){
//    	 return employeeRepository.findAll();
//     }
//}
package com.capgemini.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.training.dao.EmployeeRepository;
import com.capgemini.training.entity.Employee;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    // ================= GET ALL =================
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // ================= SAVE =================
    public Employee saveEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }
 // ================= GET ONE =================
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // ================= DELETE =================
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}