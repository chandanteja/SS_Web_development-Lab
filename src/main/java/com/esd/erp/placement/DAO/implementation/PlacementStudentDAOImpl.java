package com.esd.erp.placement.DAO.implementation;

import com.esd.erp.placement.DAO.PlacementStudentDAO;
import com.esd.erp.placement.bean.PlacementStudent;
import com.esd.erp.placement.utils.SessionUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlacementStudentDAOImpl implements PlacementStudentDAO
{
    @Override
    public  void  setAcceptance(PlacementStudent ps)
    {
        // Need to write code for setting acceptance of offer;

    }

    @Override
    public void addPlacStud(PlacementStudent ps)
    {
        Session session = SessionUtility.getSession();
        try {
            Transaction transaction = session.beginTransaction();

            session.save(ps);
            transaction.commit();
            //return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            //return false;
        }finally {
            session.close();
        }
    }
}


