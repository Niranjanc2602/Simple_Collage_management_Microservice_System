package com.college.AdminMS.repository;

import com.college.AdminMS.model.AdminEntity;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepo extends CrudRepository<AdminEntity,Integer> {

    public AdminEntity getByNameAndPassword(String name,String password);
}
