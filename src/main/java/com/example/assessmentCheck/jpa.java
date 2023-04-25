package com.example.assessmentCheck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface jpa extends JpaRepository<User, Long> {
    @Query("SELECT a.assessment FROM User a")
    List<Integer> findAllAssessments();
}
