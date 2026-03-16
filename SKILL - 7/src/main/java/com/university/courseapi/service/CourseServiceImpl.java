package com.university.courseapi.service;

import com.university.courseapi.exception.CourseNotFoundException;
import com.university.courseapi.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CourseServiceImpl implements CourseService {

    private final Map<Long, Course> courseStore = new ConcurrentHashMap<>();

    @Override
    public Course addCourse(Course course) {
        if (courseStore.containsKey(course.getCourseId())) {
            throw new IllegalArgumentException("Course with id " + course.getCourseId() + " already exists");
        }
        courseStore.put(course.getCourseId(), course);
        return course;
    }

    @Override
    public Course updateCourse(Long courseId, Course course) {
        Course existing = courseStore.get(courseId);
        if (existing == null) {
            throw new CourseNotFoundException("Course with id " + courseId + " not found");
        }
        existing.setTitle(course.getTitle());
        existing.setDuration(course.getDuration());
        existing.setFee(course.getFee());
        courseStore.put(courseId, existing);
        return existing;
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course removed = courseStore.remove(courseId);
        if (removed == null) {
            throw new CourseNotFoundException("Course with id " + courseId + " not found");
        }
    }

    @Override
    public Course getCourseById(Long courseId) {
        Course course = courseStore.get(courseId);
        if (course == null) {
            throw new CourseNotFoundException("Course with id " + courseId + " not found");
        }
        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        return new ArrayList<>(courseStore.values());
    }

    @Override
    public List<Course> searchByTitle(String title) {
        String keyword = title.toLowerCase();
        return courseStore.values().stream()
                .filter(course -> course.getTitle() != null && course.getTitle().toLowerCase().contains(keyword))
                .toList();
    }
}
