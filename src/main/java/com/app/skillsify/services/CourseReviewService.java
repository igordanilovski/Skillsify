package com.app.skillsify.services;


import com.app.skillsify.models.CourseReview;
import com.app.skillsify.models.CourseReviewId;
import com.app.skillsify.models.dto.CourseReviewDto;
import com.app.skillsify.models.dto.CourseReviewDtoWithCompositeIdDto;

public interface CourseReviewService {
    CourseReview addReview(CourseReviewDto courseReviewDto);

    CourseReview editReview(CourseReviewDtoWithCompositeIdDto courseReviewDtoWithCompositeIdDto);

    void deleteReview(CourseReviewId courseReviewId);
}
