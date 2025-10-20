-- Sample data for H2 (teachers, courses, course_teacher)
-- Passwords: password for employeeId 'abc' is '123123' encoded with BCrypt

INSERT INTO teacher (id, employee_info, department, employee_id, name, gender, birth_date, password, role)
VALUES (1, 'info-1', 'Computer Science', 'abc', 'Alice Zhang', 'F', DATE '1985-04-12', '$2a$10$/fu2yZt2VgeJSKuYwxRNN.rWcH/99Q2cx1WwK2OEF9Fd2AHU59yXy', 'ROLE_TEACHER');

INSERT INTO course (id, school_year, semester, course_type, offering_college, course_code, course_name, credit, course_category, course_nature, offering_status)
VALUES (1001, '2024-2025', 1, '必修', 'Engineering', 'CS101', 'Introduction to CS', 3.0, '专业课', '理论', '开课');

INSERT INTO course_teacher (id, course_id, teacher_id, is_main_teacher, is_grade_entry_teacher)
VALUES (1, 1001, 1, TRUE, TRUE);
