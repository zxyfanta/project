package com.cdutetc.eps.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cdutetc.eps.entity.Teacher;
import com.cdutetc.eps.repository.TeacheRepository;
import com.cdutetc.eps.service.TeacherService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{
    private final TeacheRepository teacheRepository;

    @Override
    public List<Teacher> getAllTeachers(){
        return teacheRepository.findAll();
    }

    @Override
    public Optional<Teacher> getTeacherById(Long id){
        return teacheRepository.findById(id);
    }

    @Override
    public Teacher saveTeacher(Teacher teacher){
        return teacheRepository.save(teacher);
    }
    @Override
    public void deleteTeacher(Long id){
        teacheRepository.deleteById(id);
    }
    @Override
    public Optional<Teacher> getByEmployeeid(String employeeid){
        // TODO 在 MajorCodeTableRepoitory中实现按姓名查询。
        return teacheRepository.findByEmployeeId(employeeid);
    }

    
}
