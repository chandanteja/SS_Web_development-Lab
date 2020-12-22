package com.esd.erp.placement.utils;

import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class SessionUtility
{

     public static final SessionFactory sessionFact;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            sessionFact = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Issue in creating Initial Session Factory : "+ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFact.openSession();
    }

}

