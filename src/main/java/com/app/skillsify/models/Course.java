package com.app.skillsify.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "courses")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(
            name = "user_creator",
            referencedColumnName = "id"
    )
    private User creator;

    @ManyToMany
    @JoinTable(
            name = "course_has_admins",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> admins;

    @ManyToMany
    @JoinTable(
            name = "course_has_participants",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> participants;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<CourseAnnouncements> courseAnnouncements;

    public Course() {
        this.courseAnnouncements = new ArrayList<>();
    }

    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
