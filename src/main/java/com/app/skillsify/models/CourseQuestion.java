package com.app.skillsify.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "course_questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Course course;

    @ManyToOne
    private User user;

    private String heading_text;

    private String question_text;

    private LocalDateTime created_at;

    @ManyToOne
    private CourseQuestion parent_question;
}
