package com.nagarro.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nagarro.models.HRModel;
import com.nagarro.util.*;
public class HRDaoImpl implements HRDao
{
	public HRModel getHRUser(String userId,String password)
	{
		HRModel user=null;
    	Session session=HibernateUtil.getSessionInstance();
    	Transaction t=session.beginTransaction();
    	try
    	{
    		Query q=session.createQuery("from HRModel where userId=:userId and password=:password");
    		q.setParameter("userId",userId);
    		q.setParameter("password",password);
    		user=(HRModel)q.uniqueResult();
    	}
    	catch(HibernateException e)
    	{
    		user=null;
    		System.out.println(e.getMessage());
    	}
    	return user;
	}
}