package com.college.CourseMs.controller;

import com.college.CourseMs.model.Course;
import com.college.CourseMs.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseRepo courseRepo;

    @GetMapping("/course")
    public List getAll(){
        return (List) courseRepo.findAll();
    }

    @GetMapping("/course/{id}")
    public Optional<Course> getById(@PathVariable int id){
        return courseRepo.findById(id);
    }

    @PostMapping("/addMs")
    public void addCourse(@RequestBody Course course){
        System.out.println(course.getName());
        courseRepo.save(course);
    }

    @DeleteMapping("/course/{id}")
    public void delete(@PathVariable int id){
        System.out.println("called");
        courseRepo.deleteById(id);

    }
}
