package com.esd.erp.placement.services;

import com.esd.erp.placement.bean.StudentCourses;
import com.esd.erp.placement.DAO.StudentCoursesDAO;
import com.esd.erp.placement.DAO.implementation.StudentCoursesDAOImpl;

public class StudentCoursesService
{
    StudentCoursesDAO scDAO = new StudentCoursesDAOImpl();
    public void addStudentCourses(StudentCourses sc)
    {
        scDAO.addStudentCourses(sc);
    }
}
