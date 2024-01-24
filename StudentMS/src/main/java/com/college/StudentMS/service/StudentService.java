package com.college.StudentMS.service;

import com.college.StudentMS.model.Student;
import com.college.StudentMS.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    RestTemplate restTemplate = new RestTemplate();

    public Student getByNameAndPassword(String name,String password){
        return studentRepo.getByNameAndPassword(name,password);
    }
    public void addStudent(Student student){
        studentRepo.save(student);
    }

    public List getAllStudent(){
        return (List) studentRepo.findAll();
    }

    public Optional<Student> getByStudentId(int id){
        return studentRepo.findById(id);
    }

    public void deleteStudent(int id){
        studentRepo.deleteById(id);
    }

//Ms marks
    public List getMarks(int stdId){
        return restTemplate.exchange("http://localhost:8004/getByMs/{stdId}", HttpMethod.GET,null,List.class,stdId).getBody();
    }

//Ms Staff
    public List getByStudentCourseMs(int course){
        return studentRepo.getByCourse(course);
    }
}
