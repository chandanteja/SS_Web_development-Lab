package com.esd.erp.placement.bean;

import javax.persistence.*;

@Entity
@Table(name = "Student_Courses")
public class StudentCourses
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer SC_Id;

    @Column(nullable = false)
    private String Course_name;

    @ManyToOne
    @JoinColumn(name="Student_ID",nullable = false)
    private Students Student_ID;     // FK to ID in students table

    @Column(nullable = false)
    private Double Grade;

    public StudentCourses(Integer SC_Id, String course_name, Students student_ID, Double grade) {
        this.SC_Id = SC_Id;
        Course_name = course_name;
        Student_ID = student_ID;
        Grade = grade;
    }

    public StudentCourses() {
    }

    public Integer getSC_Id() {
        return SC_Id;
    }

    public void setSC_Id(Integer SC_Id) {
        this.SC_Id = SC_Id;
    }

    public String getCourse_name() {
        return Course_name;
    }

    public void setCourse_name(String course_name) {
        Course_name = course_name;
    }

    public Students getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(Students student_ID) {
        Student_ID = student_ID;
    }

    public Double getGrade() {
        return Grade;
    }

    public void setGrade(Double grade) {
        Grade = grade;
    }
}
