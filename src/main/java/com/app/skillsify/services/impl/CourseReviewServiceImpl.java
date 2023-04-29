package com.app.skillsify.services.impl;

import com.app.skillsify.models.Course;
import com.app.skillsify.models.CourseReview;
import com.app.skillsify.models.CourseReviewId;
import com.app.skillsify.models.User;
import com.app.skillsify.models.dto.CourseReviewDto;
import com.app.skillsify.models.dto.CourseReviewDtoWithCompositeIdDto;
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

    @Override
    public CourseReview editReview(CourseReviewDtoWithCompositeIdDto courseReviewDtoWithCompositeIdDto) {
        if(courseReviewDtoWithCompositeIdDto.getCourseReviewId().getCourse() != null
                && courseReviewDtoWithCompositeIdDto.getCourseReviewId().getUser() != null) {
            CourseReview courseReview = this.courseReviewRepository.findByCourseAndUser(this.courseService.findById(courseReviewDtoWithCompositeIdDto.getCourseReviewId().getCourse()).orElseThrow(),
                    this.userService.findById(courseReviewDtoWithCompositeIdDto.getCourseReviewId().getUser()));
            courseReview.setCourse(this.courseService.findById(courseReviewDtoWithCompositeIdDto.getCourseReviewDto().getCourseId()).orElseThrow());
            courseReview.setUser(this.userService.findByUsername(courseReviewDtoWithCompositeIdDto.getCourseReviewDto().getUsername()));
            courseReview.setRating(courseReviewDtoWithCompositeIdDto.getCourseReviewDto().getRating());
            courseReview.setComment(courseReviewDtoWithCompositeIdDto.getCourseReviewDto().getComment());
            courseReview.setCreatedAt(courseReviewDtoWithCompositeIdDto.getCourseReviewDto().getCreatedAt());
            return this.courseReviewRepository.save(courseReview);
        }else{
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteReview(CourseReviewId courseReviewId) {
        if(courseReviewId.getCourse() != null && courseReviewId.getUser() != null) {
            this.courseReviewRepository.deleteByCourseAndUser(this.courseService.findById(courseReviewId.getCourse()).orElseThrow(),
                    this.userService.findById(courseReviewId.getUser()));
        }
    }
}
