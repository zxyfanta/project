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
import com.cdutetc.eps.entity.Teacher;
import com.cdutetc.eps.service.TeacherService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherServiceImpl;

    @GetMapping("/{id}")
    public ApiResponse<Teacher> getTeacherById(@PathVariable Long id){
        return ApiResponse.success(teacherServiceImpl.getTeacherById(id).orElse(null));
    }

    // 获取全部专业代码
    //1 确定访问形式，：在restful风格中 ，无任何参数的get请求，表示获取全部信息
    @GetMapping("")
    public ApiResponse<List<Teacher>> getAllTeachers(){
        return ApiResponse.success(teacherServiceImpl.getAllTeachers());
    }


    //create 添加 在接收json数据时，应当使用 @RequestBody来标记
    @PostMapping("")
    public ApiResponse<Teacher> createTeacher(@RequestBody Teacher teacher){
        return ApiResponse.success(teacherServiceImpl.saveTeacher(teacher));
    }

    // delete DeleteMapping("/{id}")
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteTeacher(@PathVariable Long id){
        if(!teacherServiceImpl.getTeacherById(id).isPresent()){
            throw BusinessException.notFound("教师");
        }
        teacherServiceImpl.deleteTeacher(id);
        return ApiResponse.success();
    }



}
