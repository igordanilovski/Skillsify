package com.app.skillsify.controllers;

import com.app.skillsify.models.CourseAnnouncement;
import com.app.skillsify.models.CourseReview;
import com.app.skillsify.models.CourseReviewId;
import com.app.skillsify.models.dto.CourseAnnouncementDto;
import com.app.skillsify.models.dto.CourseReviewDto;
import com.app.skillsify.models.dto.CourseReviewDtoWithCompositeIdDto;
import com.app.skillsify.services.CourseAnnouncementService;
import com.app.skillsify.services.CourseReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/course-announcement")
public class CourseAnnouncementController {

    private final CourseAnnouncementService courseAnnouncementService;

    @GetMapping
    private ResponseEntity<List<CourseAnnouncement>> findAll() {
        return ResponseEntity.ok().body(this.courseAnnouncementService.findAll());
    }

    @GetMapping("/{courseId}")
    private ResponseEntity<List<CourseAnnouncement>> findAllByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok().body(this.courseAnnouncementService.findAllByCourseId(courseId));
    }

    @PostMapping
    private ResponseEntity<CourseAnnouncement> addAnAnnouncement(@RequestBody CourseAnnouncementDto courseAnnouncementDto) {
        return ResponseEntity.ok().body(this.courseAnnouncementService.addAnAnnouncement(courseAnnouncementDto));
    }

    @DeleteMapping("/{id}")
    private void deleteAnnouncement(@PathVariable Long id) {
        this.courseAnnouncementService.deleteAnnouncement(id);
    }

}
