package com.app.skillsify.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "course_announcements")
@Data
public class CourseAnnouncement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @JsonBackReference
    private Course course;

    @OneToMany
    @JoinColumn(name = "parent_announcement_id", nullable = true)
    private List<CourseAnnouncement> childAnnouncements;

    @Column(name = "parent_announcement_id")
    private Long parent_announcement_id;

    @Column(nullable = false)
    private String headline;

    @Column(nullable = false)
    private String textContent;

    public CourseAnnouncement() {
        //this.childAnnouncements = new ArrayList<>();
    }
}
