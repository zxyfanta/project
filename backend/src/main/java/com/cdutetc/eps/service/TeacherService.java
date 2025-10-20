package com.cdutetc.eps.service;

import java.util.List;
import java.util.Optional;

import com.cdutetc.eps.entity.Teacher;

public interface TeacherService {
    // 查所有
    List<Teacher> getAllTeachers();
    // 根据id查询
    Optional<Teacher> getTeacherById(Long id);
    // 添加
    Teacher saveTeacher(Teacher teacher);
    // 根据id 删除
    void deleteTeacher(Long id);
    // 根据教师名称查询
    Optional<Teacher> getByEmployeeid(String teacherName);
    
}
