package com.esd.erp.placement.DAO.implementation;

import com.esd.erp.placement.DAO.StudentCoursesDAO;
import com.esd.erp.placement.bean.StudentCourses;
import com.esd.erp.placement.utils.SessionUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentCoursesDAOImpl implements StudentCoursesDAO {
    @Override
    public void addStudentCourses(StudentCourses sc)
    {
        Session session = SessionUtility.getSession();
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(sc);
            transaction.commit();
            System.out.println("Adding Student courses to DB");
           // return true;
        }
        catch (HibernateException exception)
        {
            System.out.print(exception.getLocalizedMessage());

           // return false;
        }
        finally
        {
            session.close();
        }
    }
}
