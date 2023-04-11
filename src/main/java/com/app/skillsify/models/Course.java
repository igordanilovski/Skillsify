package com.app.skillsify.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "courses")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Course() {
    }

    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
