package com.cdutetc.eps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdutetc.eps.entity.Teacher;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long>{
    Optional<Teacher> findByEmployeeId(String employeeId);

}
