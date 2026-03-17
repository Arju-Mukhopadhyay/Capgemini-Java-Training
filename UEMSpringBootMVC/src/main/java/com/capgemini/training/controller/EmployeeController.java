package com.capgemini.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capgemini.training.entity.Employee;
import com.capgemini.training.services.EmployeeServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeServices empServices;

    // ================== VIEW ALL EMPLOYEES ==================
    @GetMapping("/allemp")
    public String getAllEmployees(HttpServletRequest request) {

        System.out.println("Fetching all employees...");

        List<Employee> listOfEmployees = empServices.getAllEmployees();

        request.setAttribute("emplist", listOfEmployees);

        return "home.jsp";
    }

    // ================== OPEN ADD EMPLOYEE PAGE ==================
    @GetMapping("/addemp")
    public String createEmp() {
        return "register-emp.jsp";
    }

    // ================== ADD EMPLOYEE ==================
    @PostMapping("/addemp")
    public String addEmployee(HttpServletRequest request, RedirectAttributes ra) {

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

        empServices.saveEmployee(emp);

        // ✅ Flash Message
        ra.addFlashAttribute("msg", "Employee Added Successfully ✅");

        return "redirect:/allemp";
    }

    // ================== VIEW SINGLE EMPLOYEE ==================
    @GetMapping("/viewemp")
    public String viewEmployee(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        Employee emp = empServices.getEmployeeById(id);

        request.setAttribute("emp", emp);

        return "view-emp.jsp";
    }

    // ================== DELETE EMPLOYEE ==================
    @GetMapping("/deleteemp")
    public String deleteEmployee(HttpServletRequest request, RedirectAttributes ra) {

        int id = Integer.parseInt(request.getParameter("id"));

        empServices.deleteEmployee(id);

        // ✅ Flash Message
        ra.addFlashAttribute("msg", "Employee Deleted Successfully ✅");

        return "redirect:/allemp";
    }

    // ================== OPEN EDIT PAGE ==================
    @GetMapping("/editemp")
    public String editEmployee(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        Employee emp = empServices.getEmployeeById(id);

        request.setAttribute("emp", emp);

        return "edit-emp.jsp";
    }

    // ================== UPDATE EMPLOYEE ==================
    @PostMapping("/updateemp")
    public String updateEmployee(HttpServletRequest request, RedirectAttributes ra) {

        int id = Integer.parseInt(request.getParameter("id"));

        Employee emp = empServices.getEmployeeById(id);

        emp.setEmpId(request.getParameter("empId"));
        emp.setEmpName(request.getParameter("empName"));
        emp.setEmpEmail(request.getParameter("empEmail"));
        emp.setEmpContactNo(Long.parseLong(request.getParameter("empContactNo")));
        emp.setEmpCity(request.getParameter("empCity"));

        empServices.saveEmployee(emp);

        // ✅ Flash Message
        ra.addFlashAttribute("msg", "Employee Updated Successfully ✅");

        return "redirect:/allemp";
    }
}