package com.app.skillsify.models.dto;

import com.app.skillsify.models.User;
import com.app.skillsify.models.enumerations.Skill;

public class CourseDto {
    private String name;
    private Long userId;
    private String about;
    private Skill skill;

    public String getName() {
        return name;
    }

    public Long getUserId() {
        return userId;
    }

    public String getAbout() {
        return about;
    }

    public Skill getSkill() {
        return skill;
    }
}
