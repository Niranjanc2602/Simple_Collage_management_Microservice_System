package com.college.StaffMS.service;

import com.college.StaffMS.model.Marks;
import com.college.StaffMS.model.Staff;
import com.college.StaffMS.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    StaffRepo staffRepo;

    RestTemplate restTemplate = new RestTemplate();

    public void addStaff(Staff staff){
        staffRepo.save(staff);
    }

    public List getAllStaff(){
        return (List) staffRepo.findAll();
    }

    public Optional<Staff> getByStaffId(int id){
        return staffRepo.findById(id);
    }

    public Staff getByNameAndPassword(String name,String password){
        return staffRepo.getByNameAndPassword(name,password);
    }
//Ms Admin Communication=========================================================================================================
    public List getByStaffIdMs(int id){
        return staffRepo.getById(id);
        //return Collections.singletonList(staffRepo.findById(id));
    }

    public List getByStaffNameMs(String name){return staffRepo.findByName(name);}

    public void deleteStaff(int id){
        staffRepo.deleteById(id);
    }

//Ms Student

    public List getStudentCourse(int course){
        return restTemplate.exchange("http://localhost:8003/getByMs/{course}", HttpMethod.GET,null,List.class,course).getBody();
    }

//Ms Marks

    public void addMarks(Marks marks){
        restTemplate.postForEntity("http://localhost:8004/addMs",marks,Marks.class);
    }

    public List getStaffMark(int staffId){
        return restTemplate.exchange("http://localhost:8004/getByStaffId/{staffId}", HttpMethod.GET,null,List.class,staffId).getBody();
    }

    public List getMarks(int stdId){
        return restTemplate.exchange("http://localhost:8004/getByMs/{stdId}", HttpMethod.GET,null,List.class,stdId).getBody();
    }


}
