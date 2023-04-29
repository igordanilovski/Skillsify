package com.app.skillsify.controllers;

import com.app.skillsify.models.CourseReview;
import com.app.skillsify.models.CourseReviewId;
import com.app.skillsify.models.dto.CourseReviewDto;
import com.app.skillsify.models.dto.CourseReviewDtoWithCompositeIdDto;
import com.app.skillsify.services.CourseReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/course-reviews")
public class CourseReviewController {
    private final CourseReviewService courseReviewService;

    @PostMapping("/add-review")
    private ResponseEntity<CourseReview> addReview(@RequestBody CourseReviewDto courseReviewDto){
        return ResponseEntity.ok().body(this.courseReviewService.addReview(courseReviewDto));
    }

    @PutMapping("/edit-review")
    private ResponseEntity<CourseReview> editReview(@RequestBody CourseReviewDtoWithCompositeIdDto courseReviewDtoWithCompositeIdDto){
        return ResponseEntity.ok().body(this.courseReviewService.editReview(courseReviewDtoWithCompositeIdDto));
    }

    @PostMapping("/delete-review")
    private void deleteReview(@RequestBody CourseReviewId courseReviewId){
        this.courseReviewService.deleteReview(courseReviewId);
    }
}
