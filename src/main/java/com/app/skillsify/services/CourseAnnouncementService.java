package com.app.skillsify.services;

import com.app.skillsify.models.CourseAnnouncement;
import com.app.skillsify.models.CourseReviewId;
import com.app.skillsify.models.dto.CourseAnnouncementDto;

import java.util.List;

public interface CourseAnnouncementService {
    List<CourseAnnouncement> findAll();

    List<CourseAnnouncement> findAllByCourseId(Long courseId);

    CourseAnnouncement addAnAnnouncement(CourseAnnouncementDto courseAnnouncementDto);

    void deleteAnnouncement(Long id);
}
