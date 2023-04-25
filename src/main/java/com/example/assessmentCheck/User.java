package com.example.assessmentCheck;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "assessments")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public User(int assessment) {
        this.assessment = assessment;
    }
    public User(){}

    private int assessment;
}
