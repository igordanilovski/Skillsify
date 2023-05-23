package com.app.skillsify.models.mapper;

import com.app.skillsify.models.Course;
import com.app.skillsify.models.User;
import com.app.skillsify.models.dto.AccountDetailsDto;
import com.app.skillsify.models.dto.UserCoursesDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class UserCoursesDtoMapper implements Function<Course, UserCoursesDto> {
    @Override
    public UserCoursesDto apply(Course course) {
        return new UserCoursesDto(course.getName(), course.getDescription(), course.getAbout());
    }
}
