package com.esd.erp.placement.services;

import com.esd.erp.placement.bean.Placement;
import com.esd.erp.placement.DAO.implementation.PlacementDAOImpl;
import com.esd.erp.placement.DAO.PlacementDAO;

import java.util.List;


public class PlacementService {

    PlacementDAO placementDAO = new PlacementDAOImpl();
    private Integer companyId;

    public void addCompany(Placement p)
    {

        placementDAO.addCompany(p);
    }

    public List<Placement> getOrganizations()
    {
        return placementDAO.getOrganizations();
    }


   /* public void getCompanyId(Integer id)
    {
            companyId=id;
            System.out.println("received Company Id from Placement COntroller: "+companyId);
    }
    public void sendCompanyId()
    {
        placementDAO.getCompanyData(companyId);
    }
    *
    */

    public List<Object[]> getAppliedStudentsData()
    {
        System.out.println("Inside getAppstud data of service");

        return placementDAO.getAppliedStudentsData();
    }
}
