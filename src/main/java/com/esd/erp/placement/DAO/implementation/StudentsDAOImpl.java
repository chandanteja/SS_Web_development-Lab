package com.esd.erp.placement.DAO.implementation;

import com.esd.erp.placement.bean.Students;
import com.esd.erp.placement.DAO.StudentsDAO;
import com.esd.erp.placement.utils.SessionUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class StudentsDAOImpl  implements  StudentsDAO
{

    @Override
    public void addStudent(Students s)
    {
        Session session = SessionUtility.getSession();
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(s);
            transaction.commit();
            //System.out.println("Added Employee to DB successfully");
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

