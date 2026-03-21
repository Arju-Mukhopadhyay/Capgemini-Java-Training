package com.capgemini.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.training.entity.Employee;

//
//public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
//
//	
//	
//}
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByEmpIdContainingOrEmpNameContainingOrEmpEmailContaining(
            String empId, String empName, String empEmail);
}