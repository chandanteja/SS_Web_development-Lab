package com.esd.erp.placement.DAO.implementation;

import com.esd.erp.placement.DAO.PlacementDAO;
import com.esd.erp.placement.bean.Placement;
import com.esd.erp.placement.bean.PlacementStudent;

import com.esd.erp.placement.utils.SessionUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

    @Override
    public List<Object[]> getAppliedStudentsData()
    {
        List<Object[]> appliedStud=null;
        Session session = SessionUtility.getSession();
        System.out.println("Inside getAppstud data of controller");


        try {

            System.out.println("Inside PlacementDAOImpl.java");
            //As of now used SQL query, but later need to change to HQL query and use query.setParameter() to set values correctly. Native SQL query limits the portability of the application.
            Query query = session.createSQLQuery("select distinct s.roll_num,s.first_name,s.email,s.cgpa,s.Specialization,ps.Status,ps.Placement_id from Placement_Student ps, Students s where ps.Stud_id=s.student_id and ps.Status=\"PENDING\"");

            appliedStud = query.list();

          //  System.out.println("size of result: " + appliedStud.size());
          //  System.out.println("size of result: " + appliedStud.get(0)[0]);
          //  System.out.println("size of result: " + appliedStud.get(0)[1]);
          //  System.out.println("size of result: " + appliedStud.get(0)[2]);

         //   System.out.println("size of result: " + appliedStud.get(1)[0]);
          //  System.out.println("size of result: " + appliedStud.get(1)[1]);
          //  System.out.println("size of result: " + appliedStud.get(1)[2]);

            return appliedStud;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return appliedStud;
    }
}
