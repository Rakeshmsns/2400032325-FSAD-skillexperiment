package com.example.model;

/**
 * Student POJO class with Constructor and Setter Injection support
 */
public class Student {
    private int studentId;
    private String name;
    private String course;
    private int year;

    /**
     * Default Constructor
     */
    public Student() {
        System.out.println("Student object created using default constructor");
    }

    /**
     * Constructor with all fields - used for Constructor Injection
     */
    public Student(int studentId, String name, String course, int year) {
        System.out.println("Student object created using parameterized constructor");
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.year = year;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getYear() {
        return year;
    }

    // Setters
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", year=" + year +
                '}';
    }
}
