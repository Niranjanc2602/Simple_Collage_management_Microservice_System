package com.college.MarksMS.controller;

import com.college.MarksMS.model.Marks;
import com.college.MarksMS.repository.MarksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarksController {

    @Autowired
    MarksRepo marksRepo;

    @PostMapping("/addMs")
    public void addStaffByMs(@RequestBody Marks staff){marksRepo.save(staff);}

    @GetMapping("getByMs/{id}")
    public List getByIdMs(@PathVariable int id){return marksRepo.getByStdId(id);}

    @GetMapping("getByStaffId/{id}")
    public List getByStaff(@PathVariable int id){return marksRepo.getByStaffId(id);}
}
