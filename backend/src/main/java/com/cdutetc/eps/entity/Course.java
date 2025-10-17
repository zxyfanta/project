package com.cdutetc.eps.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * 课程表实体类
 * 移除了直接关联成绩录入教师的字段，通过关联表管理
 */
@Data
@Entity
@Table(name = "course")
public class Course {

    /**
     * 序号（主键）
     */
    @Id
    private Integer id;

    /**
     * 学年
     */
    @Column(name = "school_year", nullable = false)
    private String schoolYear;

    /**
     * 学期
     */
    @Column(name = "semester", nullable = false)
    private Integer semester;

    /**
     * 开课类型
     */
    @Column(name = "course_type")
    private String courseType;

    /**
     * 开课学院
     */
    @Column(name = "offering_college", nullable = false)
    private String offeringCollege;

    /**
     * 课程代码
     */
    @Column(name = "course_code", nullable = false, unique = true)
    private String courseCode;

    /**
     * 课程名称
     */
    @Column(name = "course_name", nullable = false)
    private String courseName;

    /**
     * 学分
     */
    @Column(name = "credit", nullable = false)
    private BigDecimal credit;

    /**
     * 场地类别
     */
    @Column(name = "venue_type")
    private String venueType;

    /**
     * 任务落实时间
     */
    @Column(name = "task_assignment_time")
    private LocalDateTime taskAssignmentTime;

    /**
     * 教学班
     */
    @Column(name = "teaching_class")
    private String teachingClass;

    @Column(name = "is_main_teaching_class")
    private String isMainTeachingClass;

    @Column(name = "is_combined_class")
    private String isCombinedClass;

    @Column(name = "main_teaching_class")
    private String mainTeachingClass;

    @Column(name = "teaching_class_composition")
    private String teachingClassComposition;

    @Column(name = "teaching_class_size")
    private Integer teachingClassSize;

    @Column(name = "teaching_class_capacity")
    private Integer teachingClassCapacity;

    @Column(name = "enrolled_students")
    private Integer enrolledStudents;

    @Column(name = "task_number")
    private Integer taskNumber;

    @Column(name = "weekly_hours")
    private Integer weeklyHours;

    @Column(name = "start_end_weeks")
    private String startEndWeeks;

    @Column(name = "start_week")
    private Integer startWeek;

    @Column(name = "end_week")
    private Integer endWeek;

    @Column(name = "scheduling_weeks")
    private String schedulingWeeks;

    @Column(name = "scheduling_start_week")
    private Integer schedulingStartWeek;

    @Column(name = "scheduling_end_week")
    private Integer schedulingEndWeek;

    @Column(name = "course_end_time")
    private LocalDateTime courseEndTime;

    @Column(name = "class_hour_type")
    private String classHourType;

    @Column(name = "total_task_hours")
    private Integer totalTaskHours;

    @Column(name = "scheduled_hours")
    private Integer scheduledHours;

    @Column(name = "course_weekly_hours")
    private String courseWeeklyHours;

    @Column(name = "total_course_hours")
    private Integer totalCourseHours;

    @Column(name = "total_theoretical_hours")
    private Integer totalTheoreticalHours;

    @Column(name = "total_practical_hours")
    private Integer totalPracticalHours;

    @Column(name = "course_category", nullable = false)
    private String courseCategory;

    @Column(name = "course_nature", nullable = false)
    private String courseNature;

    @Column(name = "offering_status", nullable = false)
    private String offeringStatus;

    @Column(name = "class_time")
    private String classTime;

    @Column(name = "teaching_location")
    private String teachingLocation;

    @Column(name = "major_direction")
    private String majorDirection;

    @Column(name = "regular_enrollment")
    private Integer regularEnrollment;

    @Column(name = "non_repeating_enrollment")
    private Integer nonRepeatingEnrollment;

    @Column(name = "is_scheduled")
    private String isScheduled;

    @Column(name = "repeating_students")
    private Integer repeatingStudents;

    @Column(name = "merge_count")
    private Integer mergeCount;

    @Column(name = "student_college")
    private String studentCollege;

    @Column(name = "grade_composition")
    private String gradeComposition;

    @Column(name = "major_composition")
    private String majorComposition;

    /**
     * 关联的教师列表（通过关联表）
     */
    @OneToMany(mappedBy = "courseId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseTeacher> courseTeachers = new ArrayList<>();
}
