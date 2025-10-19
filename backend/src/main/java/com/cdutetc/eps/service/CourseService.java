package com.cdutetc.eps.service;

import java.util.List;
import java.util.Optional;

import com.cdutetc.eps.entity.Course;

public  interface CourseService {
    // 查所有
    List<Course> getAllCourses();
    // 根据id查询
    Optional<Course> getCourseById(Long id);
    // 添加
    Course saveCourse(Course course);
    // 根据id 删除
    void deleteCourse(Long id);
    // 根据专业名称查询
    Optional<Course> getByCourseName(String courseName);
    
}
