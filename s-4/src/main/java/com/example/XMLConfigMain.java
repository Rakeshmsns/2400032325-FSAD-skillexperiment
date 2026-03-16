package com.example;

import com.example.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class to demonstrate XML-based Spring Configuration
 * This class loads the Spring IoC container using XML configuration
 */
public class XMLConfigMain {

    public static void main(String[] args) {
        System.out.println("========== XML Configuration - Spring Dependency Injection ==========\n");

        // Load the Spring IoC container from XML configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n========== Constructor Injection ==========");
        // Retrieve the student bean created using Constructor Injection
        Student studentConstructor = (Student) context.getBean("studentConstructor");
        System.out.println("Retrieved Student (Constructor Injection):");
        System.out.println(studentConstructor);

        System.out.println("\n========== Setter Injection ==========");
        // Retrieve the student bean created using Setter Injection
        Student studentSetter = (Student) context.getBean("studentSetter");
        System.out.println("Retrieved Student (Setter Injection):");
        System.out.println(studentSetter);

        System.out.println("\n========== Mixed Injection ==========");
        // Retrieve the student bean created using Mixed Injection
        Student studentMixed = (Student) context.getBean("studentMixed");
        System.out.println("Retrieved Student (Mixed Injection):");
        System.out.println(studentMixed);

        System.out.println("\n========== Individual Field Access ==========");
        System.out.println("Student Constructor Injection Details:");
        System.out.println("  ID: " + studentConstructor.getStudentId());
        System.out.println("  Name: " + studentConstructor.getName());
        System.out.println("  Course: " + studentConstructor.getCourse());
        System.out.println("  Year: " + studentConstructor.getYear());

        System.out.println("\nStudent Setter Injection Details:");
        System.out.println("  ID: " + studentSetter.getStudentId());
        System.out.println("  Name: " + studentSetter.getName());
        System.out.println("  Course: " + studentSetter.getCourse());
        System.out.println("  Year: " + studentSetter.getYear());

        System.out.println("\n========== Spring Container Closed ==========");
        // Close the application context to release resources
        ((ClassPathXmlApplicationContext) context).close();
    }
}
