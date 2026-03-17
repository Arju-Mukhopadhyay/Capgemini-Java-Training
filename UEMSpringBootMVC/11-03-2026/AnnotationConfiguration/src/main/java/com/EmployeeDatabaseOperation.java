package com;
//Create a EmployeeDatabaseOperation Class and configure the bean creation by the IOC Container


import org.springframework.stereotype.Component;

@Component("employee database bean")
public class EmployeeDatabaseOperation {
	public EmployeeDatabaseOperation() {
		System.out.println("Employee Created");
	}
	public void insertEmployeeDetails() {
		System.out.println("Data Inserted");
	}
}
