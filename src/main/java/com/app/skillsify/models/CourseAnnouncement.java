package com.app.skillsify.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "course_announcements")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CourseAnnouncement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long authorId;

    private Long courseId;

    @Column(nullable = false)
    private String headline;

    @Column(nullable = false)
    private String textContent;

}