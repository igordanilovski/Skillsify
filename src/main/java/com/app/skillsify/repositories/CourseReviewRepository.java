package com.app.skillsify.repositories;

import com.app.skillsify.models.CourseReview;
import com.app.skillsify.models.CourseReviewId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseReviewRepository extends JpaRepository<CourseReview, CourseReviewId> {
}
