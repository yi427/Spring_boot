package com.example.h2database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "COURSES")
public class Course {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "RATING")
    private int rating;
    @Column(name = "DESCRIPTION")
    private String description;

    public Course() {}

    public Course(String name, String category, int rating, String description) {
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return Objects.equals(name, course.name) &&
                Objects.equals(category, course.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}
