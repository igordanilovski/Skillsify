package com.app.skillsify.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "course_sections")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String headline;

    @ManyToOne
    private Course course;

    @ManyToOne
    private User user;

    private CourseSectionLink link;
}
