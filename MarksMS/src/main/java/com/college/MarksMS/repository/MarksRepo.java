package com.college.MarksMS.repository;

import com.college.MarksMS.model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MarksRepo extends CrudRepository<Marks,Integer> {

    public List getByStdId(int stdId);

    public List getByStaffId(int staffId);
}
