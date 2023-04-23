package com.app.skillsify.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "course_questions")
@Data
public class CourseQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String headingText;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = false
    )
    private User creator;

    @ManyToOne
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "id",
            nullable = false
    )
    @JsonBackReference
    private Course course;

    @Column(nullable = false)
    private String questionText;

    @Column(nullable = false)
    private Date createdAt;
}
