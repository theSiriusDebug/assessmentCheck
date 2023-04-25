package com.example.assessmentCheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private Service service;
    private Methods methods;

    @Autowired
    public Controller(Service service,Methods methods){
        this.service = service;
        this.methods = methods;
    }

    @GetMapping("/result")
    public int getIndex(){

        return (int)methods.find(service.getAssessments());
    }

    @GetMapping("/all")
    public List<Integer> getAll(){

        return service.getAssessments();
    }
    @PostMapping("/add")
    public void addAssessment(@RequestBody User user){
        service.addAssessment(user.getAssessment());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteUserById(id);
    }
}
