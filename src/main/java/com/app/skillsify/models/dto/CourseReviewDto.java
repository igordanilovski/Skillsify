package com.app.skillsify.models.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class CourseReviewDto {
    Long courseId;
    String username;
    Integer rating;
    String comment;
    Date createdAt;
}
