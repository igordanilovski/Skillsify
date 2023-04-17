package com.app.skillsify.models;

import com.app.skillsify.models.enumerations.SkillLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private User user;

    private LocalDateTime createdAt;

    private String aboutText;

    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevelRequired;

    @OneToMany
    private List<CourseReview> courseReviews;
}
