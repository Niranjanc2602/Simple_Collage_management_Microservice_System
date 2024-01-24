package com.college.StudentMS.repository;

import com.college.StudentMS.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo extends CrudRepository<Student,Integer> {

    public List getByCourse(int course);

    public Student getByNameAndPassword(String name,String password);
}
