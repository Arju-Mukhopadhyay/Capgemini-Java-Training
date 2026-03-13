package com.uem.training;

public class Student {
	//Declaration
	public String name;
	public int age;
	public double stipend;
	
	public static void main() {
		Student student = new Student();
		
		student.name="Tarun";
		student.age=21;
		student.stipend=10000.000;
		
		System.out.println(" Name : " + student.name);
		System.out.println(" Age : " + student.age);
		System.out.println(" Stipend : " + student.stipend);
	}
}
