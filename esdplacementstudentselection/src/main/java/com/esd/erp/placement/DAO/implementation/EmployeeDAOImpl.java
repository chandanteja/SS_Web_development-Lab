package com.esd.erp.placement.DAO.implementation;

import com.esd.erp.placement.bean.Employee;
import com.esd.erp.placement.DAO.employeeDAO;
import com.esd.erp.placement.utils.SessionUtility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EmployeeDAOImpl implements employeeDAO
{

    @Override
    public boolean verifyEmail(Employee emp) {
        Session session = SessionUtility.getSession();
        try
        {
            if(emp.getDepartment().equals("Outreach"))
            {
                Query query = session.createQuery("from Employee where email=:email and department=: dept ");
                query.setParameter("email", emp.getEmail());
                query.setParameter("dept", emp.getDepartment());
                if (query.getResultList().size() == 1)
                {
                    return true;
                }
            }
            else
                return false;
        }
        catch (HibernateException exception)
        {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
        finally
        {
            session.close();
        }
        return false;
    }

    @Override
    public boolean addEmployee(Employee emp)
    {

        Session session = SessionUtility.getSession();
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(emp);
            transaction.commit();
            System.out.println("Added Employee to DB successfully");
            return true;
        }
        catch (HibernateException exception)
        {
            System.out.print(exception.getLocalizedMessage());
          //  System.err.println("Unable to add employee to DB");
            return false;
        }
        finally
        {
            session.close();
        }
    }

}
