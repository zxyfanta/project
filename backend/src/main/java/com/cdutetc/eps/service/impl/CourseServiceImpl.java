package com.cdutetc.eps.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cdutetc.eps.entity.Course;
import com.cdutetc.eps.repository.CourseRepository;
import com.cdutetc.eps.service.CourseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long id){
        return courseRepository.findById(id);
    }

    @Override
    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }
    @Override
    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }
    @Override
    public Optional<Course> getByCourseName(String courseName){
        return courseRepository.findByCourseName(courseName);
    }

    
}
