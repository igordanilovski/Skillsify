package com.app.skillsify.models.dto;

import com.app.skillsify.models.Course;

import java.util.Date;
import java.util.List;


public record AccountDetailsDto (
    String fullName,
    String email,
    String username,
    Date dateOfBirth,
    String address,
    String phoneNumber,
    List<UserCoursesDto> courses
    ){
}
