package com.example.config;

import com.example.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Configuration class using Java-based configuration with annotations
 * This class demonstrates Dependency Injection using annotations
 */
@Configuration
public class StudentConfig {

    /**
     * Bean for Constructor Injection demonstration using Annotation
     */
    @Bean(name = "studentAnnotationConstructor")
    public Student studentAnnotationConstructor() {
        System.out.println("Creating student bean using annotation-based constructor injection");
        return new Student(201, "Neha Verma", "B.Tech Mechanical Engineering", 1);
    }

    /**
     * Bean for Setter Injection demonstration using Annotation
     */
    @Bean(name = "studentAnnotationSetter")
    public Student studentAnnotationSetter() {
        System.out.println("Creating student bean using annotation-based setter injection");
        Student student = new Student();
        student.setStudentId(202);
        student.setName("Arjun Mishra");
        student.setCourse("B.Tech Civil Engineering");
        student.setYear(4);
        return student;
    }

    /**
     * Bean for Mixed Injection demonstration using Annotation
     */
    @Bean(name = "studentAnnotationMixed")
    public Student studentAnnotationMixed() {
        System.out.println("Creating student bean using annotation-based mixed injection");
        Student student = new Student(203, "Shreya Gupta", "B.Tech", 1);
        student.setCourse("B.Tech Chemical Engineering");
        student.setYear(3);
        return student;
    }
}
