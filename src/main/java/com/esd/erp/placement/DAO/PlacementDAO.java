package com.esd.erp.placement.DAO;

import com.esd.erp.placement.bean.Placement;

import java.util.List;

public interface PlacementDAO
{
    void addCompany(Placement p);
    public List<Placement> getOrganizations();

}
