package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
       // DataBaseProperties properties = new DataBaseProperties();
    	ApplicationContext context = new AnnotationConfigApplicationContext(DataBaseProperties.class);
    	String[] beanDefinationNames =context.getBeanDefinitionNames();
    	for(String names: beanDefinationNames) {
    		System.out.println(names);
    	}
    	
    	EmployeeDatabaseOperation operation=context.getBean(EmployeeDatabaseOperation.class);
    	operation.insertEmployeeDetails();
    }
}