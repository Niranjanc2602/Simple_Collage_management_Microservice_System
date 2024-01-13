package com.college.admin.repository;

import com.college.admin.model.AdminEntity;

import java.util.List;

public interface AdminRepo {

    int save();

    int update(AdminEntity admin,int id);

    int delete(int id);

    List<AdminEntity> getAll();

    AdminEntity getById(int id);

}
