package com.app.skillsify.repositories;

import com.app.skillsify.models.CourseAnnouncements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseAnnouncementsRepository extends JpaRepository<CourseAnnouncements, Long> {
    List<CourseAnnouncements> findByCourseId(Long courseId);
}
