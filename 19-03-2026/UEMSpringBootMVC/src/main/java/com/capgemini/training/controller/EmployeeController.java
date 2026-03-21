//package com.capgemini.training.controller;
//import java.util.*;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.capgemini.training.entity.Employee;
//import com.capgemini.training.services.EmployeeServices;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//@Controller
//public class EmployeeController {
//	
//	@Autowired
//	EmployeeServices empServices;
//	
//	
//	
//	
//	@RequestMapping("/allemp")
//	public String getAllEmployees(HttpServletRequest request) {
//		System.out.println("*************************");
//		List<Employee> listOfEmployees= empServices.getAllEmployees();
//		for(Employee emp: listOfEmployees) {
//			System.out.println(" Emp : "+ emp.getEmpName());
//		}
//		request.setAttribute("emplist", listOfEmployees);
//		
//		return "home.jsp";
//	}
//}
package com.capgemini.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.training.entity.Employee;
import com.capgemini.training.services.EmployeeServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeServices empServices;

    @GetMapping("/allemp")
    public String getAllEmployees(HttpServletRequest request) {

        System.out.println("Fetching all employees...");

        List<Employee> listOfEmployees = empServices.getAllEmployees();

        request.setAttribute("emplist", listOfEmployees);

        // returning home.jsp where table is present
        return "home.jsp";
        
    }
        @GetMapping("/addemp")
        public String createEmp() {
        	return "register-emp.jsp";
        
    }
        
        
        @PostMapping("/addemp")
        public String addEmployee(HttpServletRequest request) {

            String empId = request.getParameter("empId");
            String empName = request.getParameter("empName");
            String empEmail = request.getParameter("empEmail");
            long empContactNo = Long.parseLong(request.getParameter("empContactNo"));
            String empCity = request.getParameter("empCity");

            Employee emp = new Employee();
            emp.setEmpId(empId);
            emp.setEmpName(empName);
            emp.setEmpEmail(empEmail);
            emp.setEmpContactNo(empContactNo);
            emp.setEmpCity(empCity);

            empServices.saveEmployee(emp);   // your service method

            return "redirect:/allemp";
        }
        @GetMapping("/viewemp")
        public String viewEmployee(HttpServletRequest request) {

            int id = Integer.parseInt(request.getParameter("id"));

            Employee emp = empServices.getEmployeeById(id);

            request.setAttribute("emp", emp);

            return "view-emp.jsp";
        }
        @GetMapping("/deleteemp")
        public String deleteEmployee(HttpServletRequest request) {

            int id = Integer.parseInt(request.getParameter("id"));

            empServices.deleteEmployee(id);

            return "redirect:/allemp";
        }
        @GetMapping("/editemp")
        public String editEmployee(HttpServletRequest request) {

            int id = Integer.parseInt(request.getParameter("id"));

            Employee emp = empServices.getEmployeeById(id);

            request.setAttribute("emp", emp);

            return "edit-emp.jsp";
        }
        @PostMapping("/updateemp")
        public String updateEmployee(HttpServletRequest request) {

            int id = Integer.parseInt(request.getParameter("id"));

            Employee emp = empServices.getEmployeeById(id);

            emp.setEmpId(request.getParameter("empId"));
            emp.setEmpName(request.getParameter("empName"));
            emp.setEmpEmail(request.getParameter("empEmail"));
            emp.setEmpContactNo(Long.parseLong(request.getParameter("empContactNo")));
            emp.setEmpCity(request.getParameter("empCity"));

            empServices.saveEmployee(emp);

            return "redirect:/allemp";
        }
        
        
        
        @GetMapping("/searchemp")
        public String searchEmployee(HttpServletRequest request) {

            String keyword = request.getParameter("keyword");

            List<Employee> list = empServices.searchEmployee(keyword);

            request.setAttribute("emplist", list);

            return "home.jsp";
        }
        
}