package com.college.admin.controller;

import com.college.admin.model.AdminEntity;
import com.college.admin.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminRepo adminRepo;

    @GetMapping("/admin")
    public List<AdminEntity> getUser(){
        return adminRepo.getAll();
    }

    @GetMapping("/admin/{id}")
    public AdminEntity getAdminById(@PathVariable int id){
        return adminRepo.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAdmin(@PathVariable int id){
        int r = adminRepo.delete(id);
        System.out.println(r);
    }

    @PostMapping("/save")
    public void saveAdmin(){
        int r = adminRepo.save();
        System.out.println(r);
    }

}
