package com.esd.erp.placement.services;


import com.esd.erp.placement.bean.PlacementFilter;
import com.esd.erp.placement.DAO.implementation.PlacementFilterDAOImpl;
import com.esd.erp.placement.DAO.PlacementFilterDAO;


public class PlacementFilterService
{
    PlacementFilterDAO pfDAO = new PlacementFilterDAOImpl();
    public void addPlacementFilterEntry(PlacementFilter pf)
    {
        pfDAO.addPlacementFilterEntry(pf);
    }
}
