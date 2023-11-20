package com.example.springbootdata.repository;

import java.util.List;

import com.example.springbootdata.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContainingIgnoreCase(String title);
}