package com.university.courseapi.service;

import com.university.courseapi.model.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(Course course);

    Course updateCourse(Long courseId, Course course);

    void deleteCourse(Long courseId);

    Course getCourseById(Long courseId);

    List<Course> getAllCourses();

    List<Course> searchByTitle(String title);
}
