package com.app.skillsify.repositories;

import com.app.skillsify.models.Course;
import com.app.skillsify.models.CourseReview;
import com.app.skillsify.models.CourseReviewId;
import com.app.skillsify.models.User;
import com.app.skillsify.models.dto.CourseReviewDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseReviewRepository extends JpaRepository<CourseReview, CourseReviewId> {
    CourseReview findByCourseAndUser(Course course, User user);
    void deleteByCourseAndUser(Course course, User user);
}
