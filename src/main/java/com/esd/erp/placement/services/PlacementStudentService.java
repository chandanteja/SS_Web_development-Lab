package com.esd.erp.placement.services;

import com.esd.erp.placement.DAO.PlacementStudentDAO;
import com.esd.erp.placement.DAO.implementation.PlacementStudentDAOImpl;
import com.esd.erp.placement.bean.PlacementStudent;

public class PlacementStudentService
{

    PlacementStudentDAO placStudDAO =  new PlacementStudentDAOImpl();

    public void addPlacStud(PlacementStudent ps){
        placStudDAO.addPlacStud(ps);
    }
}
