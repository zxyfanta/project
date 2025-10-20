package com.cdutetc.eps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdutetc.eps.entity.Teacher;

//1 @Repository
//2 切换到interface 
//3 extends JapRepository<Teacher,Long>
@Repository
public interface TeacheRepository extends JpaRepository<Teacher,Long>{
    Optional<Teacher> findByEmployeeId(String employeeid);
    
}
