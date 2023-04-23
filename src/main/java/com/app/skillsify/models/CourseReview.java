package com.app.skillsify.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "course_reviews")
@Data
public class CourseReview {
    @Id
    @ManyToOne
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "id",
            nullable = false
    )
    @JsonBackReference
    private Course course;

    @Id
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = false
    )
    private User user;

    @Column(name = "rating_value", nullable = false)
    private Integer rating;

    @Column(name = "rating_comment", nullable = false)
    private String comment;

    @Column(nullable = false)
    private Date createdAt;
}
