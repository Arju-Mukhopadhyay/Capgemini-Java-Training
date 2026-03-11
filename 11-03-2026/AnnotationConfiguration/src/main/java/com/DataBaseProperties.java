package com;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("database properties bean")      //<-- The name in the bracket is the name of the Component
											//	  if you don't name it, it'll by default be the name of the Class
@ComponentScan(basePackages = "com")   		//<-- This will make it so that the IOC will go through all the components
					 						//    in the com package and make a bean for everyone

public class DataBaseProperties {
	
	public DataBaseProperties() {
		System.out.println("Object is Created");
	}
	
	public String mysqlProperties() {
		return "jdbc:mysql;//localhost3306?user=root&password=root";
		
	}
	
}
