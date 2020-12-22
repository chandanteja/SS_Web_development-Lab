package com.esd.erp.placement.DAO.implementation;

import com.esd.erp.placement.DAO.PlacementDAO;
import com.esd.erp.placement.bean.Placement;
import com.esd.erp.placement.utils.SessionUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PlacementDAOImpl implements PlacementDAO {

    @Override
    public void addCompany(Placement p)
    {
        Session session = SessionUtility.getSession();
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(p);
            transaction.commit();
           // System.out.println("Added Employee to DB successfully");
            //return true;
        }
        catch (HibernateException exception)
        {
            System.out.print(exception.getLocalizedMessage());
            //  System.err.println("Unable to add employee to DB");
            //return false;
        }
        finally
        {
            session.close();
        }
    }

    @Override
    public List<Placement> getOrganizations()
    {
        Session session = SessionUtility.getSession();
        List<Placement> orgs = new ArrayList<>();
        try {
            for (final Object placement : session.createQuery("from Placement ").list()) {
                orgs.add((Placement) placement);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return orgs;

    }
}
