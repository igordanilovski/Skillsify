package com.app.skillsify.services.impl;

import com.app.skillsify.models.Course;
import com.app.skillsify.models.CourseReview;
import com.app.skillsify.models.User;
import com.app.skillsify.models.dto.CourseReviewDto;
import com.app.skillsify.repositories.CourseReviewRepository;
import com.app.skillsify.services.CourseReviewService;
import com.app.skillsify.services.CourseService;
import com.app.skillsify.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseReviewServiceImpl implements CourseReviewService {

    private final CourseService courseService;
    private final UserService userService;

    private final CourseReviewRepository courseReviewRepository;

    @Override
    public CourseReview addReview(CourseReviewDto courseReviewDto) {
        Course course = this.courseService.findById(courseReviewDto.getCourseId()).orElseThrow();
        User user = this.userService.findByUsername(courseReviewDto.getUsername());
        CourseReview courseReview = new CourseReview();
        courseReview.setCourse(course);
        courseReview.setUser(user);
        courseReview.setRating(courseReviewDto.getRating());
        courseReview.setComment(courseReviewDto.getComment());
        courseReview.setCreatedAt(courseReviewDto.getCreatedAt());
        return this.courseReviewRepository.save(courseReview);
    }
}
