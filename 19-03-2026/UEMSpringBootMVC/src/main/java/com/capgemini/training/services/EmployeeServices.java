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

    public Employee getSingleEmpInfo(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // ================= DELETE =================
    public boolean deleteEmployee(int id) {

        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }

        return false;
    }

    // ================= UPDATE =================
    public Employee updateEmployee(int id, Employee emp) {

        Employee existingEmp = employeeRepository.findById(id).orElse(null);

        if (existingEmp != null) {
            existingEmp.setEmpId(emp.getEmpId());
            existingEmp.setEmpName(emp.getEmpName());
            existingEmp.setEmpEmail(emp.getEmpEmail());
            existingEmp.setEmpContactNo(emp.getEmpContactNo());
            existingEmp.setEmpCity(emp.getEmpCity());

            return employeeRepository.save(existingEmp);
        }

        return null;
    }

    // ================= SEARCH =================
    public List<Employee> searchEmployee(String keyword) {
        return employeeRepository
                .findByEmpIdContainingOrEmpNameContainingOrEmpEmailContaining(
                        keyword, keyword, keyword);
    }
}