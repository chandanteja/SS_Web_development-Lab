package com.esd.erp.placement.DAO.implementation;

import com.esd.erp.placement.DAO.PlacementFilterDAO;
import com.esd.erp.placement.bean.PlacementFilter;
import com.esd.erp.placement.utils.SessionUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PlacementFilterDAOImpl  implements PlacementFilterDAO
{
    @Override
    public void addPlacementFilterEntry(PlacementFilter pf)
    {
        Session session = SessionUtility.getSession();
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(pf);
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
}

