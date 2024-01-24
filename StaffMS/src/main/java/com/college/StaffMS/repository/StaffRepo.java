package com.college.StaffMS.repository;

import com.college.StaffMS.model.Staff;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StaffRepo extends CrudRepository<Staff,Integer> {

    public List findByName(String name);

    public Staff getByNameAndPassword(String name,String password);

    public List getById(int id);

}
