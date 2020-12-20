package com.esd.erp.placement.services;

import com.esd.erp.placement.bean.Employee;
import com.esd.erp.placement.DAO.employeeDAO;
import com.esd.erp.placement.DAO.implementation.EmployeeDAOImpl;


public class EmployeeService
{
    employeeDAO empDAO = new EmployeeDAOImpl();

    public boolean verifyEmail(Employee emp){
        return empDAO.verifyEmail(emp);
    }
    public void addEmployee(Employee emp){
        empDAO.addEmployee(emp);
    }

}


