package com.esd.erp.placement.services;

import com.esd.erp.placement.bean.Placement;
import com.esd.erp.placement.DAO.implementation.PlacementDAOImpl;
import com.esd.erp.placement.DAO.PlacementDAO;
import com.esd.erp.placement.bean.Students;

public class PlacementService {

    PlacementDAO studentsDAO = new PlacementDAOImpl();
    public void addCompany(Placement p)
    {
        studentsDAO.addCompany(p);
    }

}
