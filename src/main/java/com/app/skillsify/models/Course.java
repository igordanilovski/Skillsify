package com.app.skillsify.models;

import com.app.skillsify.models.enumerations.Skill;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "courses")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "about_text", nullable = false)
    private String about;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "skill_level_required", nullable = false)
    private Skill skillRequired;

    @ManyToOne
    @JoinColumn(
            name = "user_creator",
            referencedColumnName = "id",
            nullable = false
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
    private List<CourseAnnouncement> courseAnnouncements;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<CourseQuestion> courseQuestions;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<CourseReview> courseReviews;

    @Column(nullable = false)
    private Date createdAt;

    @Column()
    private Date updatedAt;

    public Course() {
        this.courseQuestions = new ArrayList<>();
        this.courseAnnouncements = new ArrayList<>();
    }

    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}