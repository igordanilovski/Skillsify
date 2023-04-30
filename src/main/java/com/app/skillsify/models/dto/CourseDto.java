package com.app.skillsify.models.dto;

import com.app.skillsify.models.enumerations.Skill;
import lombok.Getter;

@Getter
public class CourseDto {
    private String name;
    private Long userId;
    private String about;
    private Skill skill;

}
