package com.app.skillsify.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CourseReviewId implements Serializable {
    private Long course;
    private Long user;
}
