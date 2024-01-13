package com.college.admin.repository;

import com.college.admin.model.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepoImpl implements AdminRepo{

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public int save() {
        return jdbcTemplate.update("INSERT INTO user VALUES(?,?,?)",new Object[]{4,"shon","1234"});
    }

    @Override
    public int update(AdminEntity admin, int id) {
        return jdbcTemplate.update("UPDATE admin SET name=? ,password= ? where id=?",new Object[]{admin.getName(),admin.getPassword(),admin.getId()});
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM admin WHERE id=?",id);
    }

    @Override
    public List<AdminEntity> getAll() {
        return jdbcTemplate.query("SELECT * FROM admin",new BeanPropertyRowMapper<AdminEntity>(AdminEntity.class));
    }

    @Override
    public AdminEntity getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM admin WHERE id = ?", new BeanPropertyRowMapper<AdminEntity>(AdminEntity.class),id);
    }

}
