package com.app.skillsify.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CourseAnnouncementDto {
    private Long id;
    public Long authorId;
    private Long courseId;
    private String headline;
    private String textContent;

}
