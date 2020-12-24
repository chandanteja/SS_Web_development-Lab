package com.esd.erp.placement.DAO;

import com.esd.erp.placement.bean.Placement;

import java.util.List;

public interface PlacementDAO
{

    void addCompany(Placement p);
    public List<Placement> getOrganizations();
    public List<Object[]> getAppliedStudentsData();
    public List<Object[]> getEligibleStudentsData();
}
