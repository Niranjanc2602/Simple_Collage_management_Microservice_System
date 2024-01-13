package com.college.CourseMs.repository;

import com.college.CourseMs.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepo extends CrudRepository<Course,Integer> {
}
