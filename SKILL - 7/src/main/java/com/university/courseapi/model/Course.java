package com.university.courseapi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Course {

    @NotNull(message = "courseId is required")
    @Positive(message = "courseId must be positive")
    private Long courseId;

    @NotBlank(message = "title is required")
    private String title;

    @NotBlank(message = "duration is required")
    private String duration;

    @NotNull(message = "fee is required")
    @Positive(message = "fee must be positive")
    private Double fee;

    public Course() {
    }

    public Course(Long courseId, String title, String duration, Double fee) {
        this.courseId = courseId;
        this.title = title;
        this.duration = duration;
        this.fee = fee;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}
