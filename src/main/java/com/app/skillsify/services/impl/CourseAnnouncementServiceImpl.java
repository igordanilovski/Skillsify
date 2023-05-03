package com.app.skillsify.services.impl;

import com.app.skillsify.models.CourseAnnouncement;
import com.app.skillsify.models.CourseReviewId;
import com.app.skillsify.models.dto.CourseAnnouncementDto;
import com.app.skillsify.repositories.CourseAnnouncementsRepository;
import com.app.skillsify.services.CourseAnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseAnnouncementServiceImpl implements CourseAnnouncementService {
    private final CourseAnnouncementsRepository courseAnnouncementsRepository;

    @Override
    public List<CourseAnnouncement> findAll() {
        return this.courseAnnouncementsRepository.findAll();
    }

    @Override
    public List<CourseAnnouncement> findAllByCourseId(Long courseId) {
        return courseAnnouncementsRepository.findAllByCourseId(courseId);
    }

    @Override
    public CourseAnnouncement addAnAnnouncement(CourseAnnouncementDto courseAnnouncementDto) {

        CourseAnnouncement courseAnnouncement = CourseAnnouncement
            .builder()
            .id(courseAnnouncementDto.getId())
            .authorId(courseAnnouncementDto.getAuthorId())
            .courseId(courseAnnouncementDto.getCourseId())
            .headline(courseAnnouncementDto.getHeadline())
            .textContent(courseAnnouncementDto.getTextContent())
            .build();

        return courseAnnouncementsRepository.save(courseAnnouncement);
    }

    @Override
    public void deleteAnnouncement(Long id) {
        courseAnnouncementsRepository.deleteById(id);
    }
}
