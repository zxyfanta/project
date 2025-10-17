package com.cdutetc.eps.entity;


import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

/**
 * 教师表实体类
 * 包含教师的基本信息
 */
@Data
@Entity
@Table(name = "teacher")
public class Teacher {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 职工信息
     */
    @Column(name = "employee_info")
    private String employeeInfo;

    /**
     * 教师部门
     */
    @Column(name = "department")
    private String department;

    /**
     * 教工号/登录username
     */
    @Column(name = "employee_id", unique = true, nullable = false)
    private String employeeId;

    /**
     * 教师名称
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 教师性别
     */
    @Column(name = "gender")
    private String gender;

    /**
     * 教师出生日期
     */
    @Column(name = "birth_date")
    private LocalDate birthDate;

    /**
     * 密码 
     */
    @Column(name = "password")
    private String password;
    /**
     * role角色 
     */
    @Column(name = "role")
    private String role;
}
    