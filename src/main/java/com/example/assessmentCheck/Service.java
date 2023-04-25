package com.example.assessmentCheck;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private EntityManager entityManager;
    private jpa jpa;
    @Autowired
    public Service(EntityManager entityManager, jpa jpa) {
        this.entityManager = entityManager;
        this.jpa = jpa;
    }

    public List<Integer> getAssessments(){
        Session session = entityManager.unwrap(Session.class);
        String hql = "SELECT a.assessment FROM User a";
        Query query = session.createQuery(hql);
        List<Integer> assessmentList = query.getResultList();

        System.out.println("was selected");
        return jpa.findAllAssessments();
    }
    public void addAssessment(int assessment) {
        if (assessment >= 0 && assessment <= 10) {
            jpa.save(new User(assessment));
            System.out.println("was created");
        } else {
            throw new IllegalArgumentException("Assessment must be between 0 and 10");
        }
    }
    public void deleteUserById(long id) {
        jpa.deleteById(id);
        System.out.println("was deleted");
    }
}
