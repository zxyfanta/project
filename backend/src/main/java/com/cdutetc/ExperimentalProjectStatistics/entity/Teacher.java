package com.cdutetc.ExperimentalProjectStatistics.entity;


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
     * 教工号
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
    // TODO 需要确认，是否包含，“主讲”字段
    /**
     * 是否主讲
     */
    @Column(name = "is_main_lecturer")
    private String isMainLecturer;
}
    