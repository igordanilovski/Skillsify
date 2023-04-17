package com.app.skillsify.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "course_section_links")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseSectionLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private CourseSection courseSection;

    private String headline_text;

    private String link;

    @ManyToOne
    private User user;

}
