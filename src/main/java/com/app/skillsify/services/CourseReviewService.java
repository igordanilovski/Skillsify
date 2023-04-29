package com.app.skillsify.services;


import com.app.skillsify.models.CourseReview;
import com.app.skillsify.models.dto.CourseReviewDto;

public interface CourseReviewService {
    CourseReview addReview(CourseReviewDto courseReviewDto);
}
