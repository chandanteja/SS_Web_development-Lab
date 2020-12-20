package com.esd.erp.placement.DAO.implementation;

import com.esd.erp.placement.DAO.PlacementDAO;
import com.esd.erp.placement.bean.Placement;
import com.esd.erp.placement.utils.SessionUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
