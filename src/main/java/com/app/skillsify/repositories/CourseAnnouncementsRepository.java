package com.app.skillsify.repositories;

import com.app.skillsify.models.CourseAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseAnnouncementsRepository extends JpaRepository<CourseAnnouncement, Long> {
    @Query(value = "select * from course_announcements ca where parent_announcement_id is null", nativeQuery = true)
    List<CourseAnnouncement> findByCourseIdWhereParentAnnouncementIsNull(Long courseId);

    @Query(value = "select * from course_announcements ca where parent_announcement_id=#announcementId", nativeQuery = true)
    List<CourseAnnouncement> findByCourseIdAndChildAnnouncementsIsNotNull(Long courseId);

    @Query(value = "select * from course_announcements ca where parent_announcement_id=#announcementId", nativeQuery = true)
    List<CourseAnnouncement> findAllByParentId(Long announcementId);
}
