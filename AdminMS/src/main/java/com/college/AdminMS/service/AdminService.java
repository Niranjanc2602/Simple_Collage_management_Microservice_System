package com.college.AdminMS.service;

import com.college.AdminMS.model.AdminEntity;
import com.college.AdminMS.model.Course;
import com.college.AdminMS.model.Staff;
import com.college.AdminMS.model.Student;
import com.college.AdminMS.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepo adminRepo;

    RestTemplate restTemplate = new RestTemplate();

    public List<AdminEntity> getAll(){
        return (List<AdminEntity>) adminRepo.findAll();
    }

    public void addAdmin(AdminEntity adminEntity){ adminRepo.save(adminEntity);}

    public void deleteAdmin(int id){adminRepo.deleteById(id);}

//Course==========================================================================================================================

    public void addCourse(Course course){restTemplate.postForEntity("http://localhost:8001/addMs",course,Staff.class);}

    public List getCourse(){ return restTemplate.exchange("http://localhost:8001/course", HttpMethod.GET,null,List.class).getBody();}

    public Course getCourseById(int id){return restTemplate.exchange("http://localhost:8001/course/{id}", HttpMethod.GET,null,Course.class,id).getBody();}

    public void deleteCourse(int id){restTemplate.exchange("http://localhost:8001/course/{id}", HttpMethod.DELETE,null,Course.class,id).getBody();}

//Ms Staff==========================================================================================================================
    public void addStaff(Staff o){
        restTemplate.postForEntity("http://localhost:8002/addMs",o,Staff.class);
    }

    public List getAllStaff() {return restTemplate.exchange("http://localhost:8002/getAllMs/",HttpMethod.GET,null,List.class).getBody();}

    public List getStaffById(int id) {return restTemplate.exchange("http://localhost:8002/getByMs/{id}",HttpMethod.GET,null,List.class,id).getBody();}

    public List getStaffByName(String name){return restTemplate.exchange("http://localhost:8002/getByNameMs/{name}",HttpMethod.GET,null,List.class,name).getBody();}

    public void deleteStuff(int id){restTemplate.exchange("http://localhost:8002/delete/{id}", HttpMethod.DELETE,null,Staff.class,id).getBody();}

//MS Student==========================================================================================================================

    public List getAllStudent() {return restTemplate.exchange("http://localhost:8003/getAllMs/",HttpMethod.GET,null,List.class).getBody();}

    public void addStudent(Student student){restTemplate.postForEntity("http://localhost:8003/addMs",student,Staff.class);}

    public void deleteStudent(int id){restTemplate.exchange("http://localhost:8003/delete/{id}", HttpMethod.DELETE,null,Student.class,id).getBody();}

}
