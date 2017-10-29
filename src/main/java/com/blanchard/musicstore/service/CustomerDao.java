package com.blanchard.musicstore.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blanchard.musicstore.domain.Customer;

public class CustomerDao
{	
	SessionFactory sessionFactory;
	
	// CONSTRUCTOR
	public CustomerDao()
	{
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	/**
	 * Add a <code>Customer</code> to the database
	 * @param c the <code>Customer</code>
	 */
	public void add(Customer c) 
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * Finds a <code>Customer</code> in the database 
	 * @param id the id of the <code>Customer</code>
	 * @return the <code>Customer</code> if it's in the database, null if not
	 */
	public Customer find(Long id)
	{
		Session session = sessionFactory.openSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}
	
	/**
	 * Updates a <code>Customer</code> in the database 
	 * @param c the <code>Customer</code>
	 */
	public void update(Customer c) 
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(c);	
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * Deletes a <code>Customer</code> in the database 
	 * @param c the <code>Customer</code>
	 */
	public void delete(Customer c)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(c);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * Gets a list of all of the <code>Customer</code>s in the database 
	 * @return the list of <code>Customer</code>s
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getList() 
	{
		Session session = sessionFactory.openSession();
		List<Customer> customers = (List<Customer>) session.createQuery("from " + Customer.class.getName()).list();
		session.close();
		return customers;
	}
}
