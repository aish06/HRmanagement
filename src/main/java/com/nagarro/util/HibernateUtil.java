package com.nagarro.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.nagarro.models.HRModel;

public class HibernateUtil
{
	private static SessionFactory sessionFactory;
	
	public static Session getSessionInstance()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(HRModel.class);
    	sessionFactory= con.buildSessionFactory();
    	Session session=sessionFactory.openSession();
    	return session;
	}
}