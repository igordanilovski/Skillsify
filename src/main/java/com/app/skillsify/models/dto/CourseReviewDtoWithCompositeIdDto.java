package com.app.skillsify.models.dto;

import com.app.skillsify.models.CourseReviewId;
import lombok.Getter;

@Getter
public class CourseReviewDtoWithCompositeIdDto {
    CourseReviewDto courseReviewDto;
    CourseReviewId courseReviewId;
}
