package com.app.skillsify.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "course_announcements")
@Data
public class CourseAnnouncements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @JsonBackReference
    private Course course;

    @OneToMany
    @JoinColumn(name = "parent_announcement_id", nullable = true)
    private List<CourseAnnouncements> childAnnouncements;

    @Column(nullable = false)
    private String headline;

    @Column(nullable = false)
    private String textContent;

}
