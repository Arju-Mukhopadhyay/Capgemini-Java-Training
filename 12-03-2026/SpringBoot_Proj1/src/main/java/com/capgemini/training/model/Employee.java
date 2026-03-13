//package com.capgemini.training.model;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

//@Component
//public class Employee {
//    @Autowired  // Automatically creates objects for the department class
//    // for this that class use @Component
//    
//	Department dept;
//    
//    public String empInfo;
	
    // constructor
    
//    Employee(){
//    	dept.displayDepartment();
//    }
//    
//    Employee(Department dept){
//    	return dept;
//    }
//    
    
    
    
    // getter setter 
    
//	public String empInfo;
//	
//	public void showEmployeeInfo() {
//		// dept.displayDepartment()
//		System.out.println("This method ......inside Employee class ");
//	}
//	public String getEmpInfo() {
//		return empInfo;
//	}
//	
//	public void setEmpInfo(String empInfo) {
//		dept.displayDepartment();
//		this.empInfo = empInfo;
//	}
//	
package com.capgemini.training.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
	
	@Component
	public class Employee{


	@Autowired
	Department dept;
	
	// Constructor  Injection
	
	Employee(Department dept){ // passing object of Department in Employee Constructor
		this.dept = dept;
		
		dept.displayDepartment();
	}
	
	public String empInfo;
	
	
	
    public void showEmployeeInfo() {
    	// dept.displayDepartment();
    	
       System.out.print("This method....... inside Employee class  ");
    }
     
    public void setEmpInfo(String empInfo) {
		dept.displayDepartment();
		this.empInfo = empInfo;
	}
    
    public String getEmpInfo() {
		return empInfo;
	}
	
}