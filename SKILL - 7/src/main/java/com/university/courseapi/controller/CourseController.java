package com.university.courseapi.controller;

import com.university.courseapi.dto.ApiResponse;
import com.university.courseapi.model.Course;
import com.university.courseapi.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> addCourse(@Valid @RequestBody Course course) {
        Course created = courseService.addCourse(course);
        ApiResponse<Course> response = new ApiResponse<>(true, "Course created successfully", created);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@PathVariable Long courseId, @Valid @RequestBody Course course) {
        Course updated = courseService.updateCourse(courseId, course);
        ApiResponse<Course> response = new ApiResponse<>(true, "Course updated successfully", updated);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<ApiResponse<String>> deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
        ApiResponse<String> response = new ApiResponse<>(true, "Course deleted successfully", "Deleted courseId: " + courseId);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Object>> getAllCourses() {
        ApiResponse<Object> response = new ApiResponse<>(true, "Courses fetched successfully", courseService.getAllCourses());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable Long courseId) {
        Course course = courseService.getCourseById(courseId);
        ApiResponse<Course> response = new ApiResponse<>(true, "Course fetched successfully", course);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<ApiResponse<Object>> searchCourses(@PathVariable String title) {
        ApiResponse<Object> response = new ApiResponse<>(true, "Search completed successfully", courseService.searchByTitle(title));
        return ResponseEntity.ok(response);
    }
}
