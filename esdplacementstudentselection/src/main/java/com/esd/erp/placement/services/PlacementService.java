package com.esd.erp.placement.services;

import com.esd.erp.placement.bean.Placement;
import com.esd.erp.placement.DAO.implementation.PlacementDAOImpl;
import com.esd.erp.placement.DAO.PlacementDAO;

import java.util.List;


public class PlacementService {

    PlacementDAO placementDAO = new PlacementDAOImpl();
    public void addCompany(Placement p)
    {
        placementDAO.addCompany(p);
    }
    public List<Placement> getOrganizations()
    {
        return placementDAO.getOrganizations();
    }

}
