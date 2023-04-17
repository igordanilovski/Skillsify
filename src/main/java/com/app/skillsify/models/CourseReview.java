package com.app.skillsify.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "course_reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating_value;

    private String rating_comment;

    private LocalDateTime createdAt;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

}
