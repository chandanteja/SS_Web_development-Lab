package com.esd.erp.placement.DAO;

import com.esd.erp.placement.bean.*;

public interface StudentsDAO
{
    void addStudent(Students s);
    void updatePlacementId(String roll,Integer pla);

}
