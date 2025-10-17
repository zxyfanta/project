package com.cdutetc.eps.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


/**
 * 课程与教师关联表
 * 用于表示一门课程关联一位或多位教师
 */
@Data
@Entity
@Table(name = "course_teacher")
public class CourseTeacher {

    /**
     * 关联记录ID（主键）
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO 修改为教师表和课程表中对应的字段

    /**
     * 课程ID（外键）
     */
    @Column(name = "course_id", nullable = false)
    private Long courseId;

    /**
     * 教师ID（外键）
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    /**
     * 是否为主讲教师
     */
    @Column(name = "is_main_teacher")
    private Boolean isMainTeacher;
        /**
     * 是否为成绩录入教师
     */
    @Column(name = "is_grade_entry_teacher")
    private Boolean isGradeEntryTeacher;
}
