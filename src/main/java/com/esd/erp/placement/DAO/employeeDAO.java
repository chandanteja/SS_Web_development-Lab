package com.esd.erp.placement.DAO;

import com.esd.erp.placement.bean.Employee;

public interface employeeDAO
{

    boolean verifyEmail(Employee emp);
    boolean addEmployee(Employee emp);

}
