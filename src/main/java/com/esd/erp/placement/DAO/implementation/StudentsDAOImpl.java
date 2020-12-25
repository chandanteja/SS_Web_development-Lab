package com.esd.erp.placement.DAO.implementation;

import com.esd.erp.placement.bean.Students;
import com.esd.erp.placement.DAO.StudentsDAO;
import com.esd.erp.placement.utils.SessionUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


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

    @Override
    public void updatePlacementId(String roll,Integer pla){

        Session session = SessionUtility.getSession();
        try
        {
            String roll_no=roll;
            Integer i=pla;
            Transaction transaction = session.beginTransaction();
            Query q=session.createQuery("update Students set placement_status_id=:n where roll_num=:num");
            //Query q=session.createQuery("update User set name=:n where id=:i");
            q.setParameter("n",i);
            q.setParameter("num",roll_no);

            int status=q.executeUpdate();
            System.out.println(status);
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

