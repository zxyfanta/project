package com.cdutetc.eps.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdutetc.eps.common.ApiResponse;
import com.cdutetc.eps.common.BusinessException;
import com.cdutetc.eps.entity.Course;
import com.cdutetc.eps.service.impl.CourseServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseServiceImpl courseServiceImpl;

    //curd 
    // 获取全部专业代码
    //1 确定访问形式，：在restful风格中 ，无任何参数的get请求，表示获取全部信息
    @GetMapping
    public ApiResponse<List<Course>> getAllCourses(){
        return ApiResponse.success(courseServiceImpl.getAllCourses());
    }
    // 查询
    //通过id进行查询
    //get请求，/api/major-codes/{id}
    //pathVerable
    @GetMapping("/{id}")
    public ApiResponse<Course> getCourseById(@PathVariable Long id){
        return ApiResponse.success(courseServiceImpl.getCourseById(id).orElse(null));
    }



    //create 添加 在接收json数据时，应当使用 @RequestBody来标记
    @PostMapping
    public ApiResponse<Course> createCourse(@RequestBody Course course){
        return ApiResponse.success(courseServiceImpl.saveCourse(course));
    }

    // delete DeleteMapping("/{id}")
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteCourse(@PathVariable Long id){
        if(!courseServiceImpl.getCourseById(id).isPresent()){
            // TODO 添加全局异常处理
            throw BusinessException.notFound("课程");
        }
        courseServiceImpl.deleteCourse(id);
        return ApiResponse.success();
    }

    
}
