package com.app.skillsify.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "course_announcements")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseAnnouncement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Course course;

    private String headline;

    @ManyToOne
    private User user;

    private String text_content;

    @OneToOne
    private CourseAnnouncement parentAnnouncement;
}
