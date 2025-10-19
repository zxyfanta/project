package com.cdutetc.eps.repository;

import java.util.Optional;

// 1 class 改为 interface
// 2 extends JapRepository
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cdutetc.eps.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>{
    Optional<Course> findByCourseName(String courseName);

}