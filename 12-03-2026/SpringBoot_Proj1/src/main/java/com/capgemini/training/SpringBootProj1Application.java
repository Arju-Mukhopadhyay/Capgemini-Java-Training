//package com.capgemini.training;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//
//import com.capgemini.training.model.Department;
//import com.capgemini.training.model.Employee;


// Getters and Setters injection 

//@SpringBootApplication
//public class SpringBootProj1Application {
//
//	public static void main(String[] args) {
		
		//SpringApplication.run(SpringBootProj1Application.class, args); // old way
		
		//System.out.println("Welcome To the World of SpringBoot........Technology");
		
//		Employee emp = new Employee();   -> This is the old way to do this.
//		
//		emp.showEmployeeInfo();
		
		// New way to do this..
		
		
		// it is called inversion of control
		
	//	ApplicationContext ctx = SpringApplication.run(SpringBootProj1Application.class, args);
		
//		Employee emp = ctx.getBean(Employee.class, "IEM");
//		
//		//Department dept = ctx.getBean(Department.class);
//		
//		
//		emp.showEmployeeInfo();
//		
//		emp.setEmpInfo(" UEM");// setter injection
//		
//		emp.getEmpInfo();


		
package com.capgemini.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.capgemini.training.model.Department;
import com.capgemini.training.model.Employee;

// Constructor injection

		@SpringBootApplication
		public class SpringBootProj1Application {

			public static void main(String[] args) {
				
		ApplicationContext ctx = SpringApplication.run(SpringBootProj1Application.class, args);
		
		Employee emp = ctx.getBean(Employee.class);
		
		emp.showEmployeeInfo();
		
		emp.setEmpInfo(" UEM");// setter injection
		
	    emp.getEmpInfo();
		
		
		
	}

}