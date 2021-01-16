package com.esd.erp.placement.services;

import com.esd.erp.placement.bean.Students;
import com.esd.erp.placement.DAO.implementation.StudentsDAOImpl;
import com.esd.erp.placement.DAO.StudentsDAO;

public class StudentsService {

    StudentsDAO studentsDAO = new StudentsDAOImpl();
    public void addStudent(Students s)
    {
        studentsDAO.addStudent(s);
    }

}
