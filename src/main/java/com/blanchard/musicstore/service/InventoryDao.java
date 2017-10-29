package com.blanchard.musicstore.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blanchard.musicstore.domain.Inventory;

public class InventoryDao
{	
	SessionFactory sessionFactory;
	
	// CONSTRUCTOR
	public InventoryDao()
	{
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	/**
	 * Add a <code>Inventory</code> item to the database
	 * @param i the <code>Inventory</code> item
	 */
	public void add(Inventory i) 
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(i);
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * Finds an <code>Inventory</code> item in the database 
	 * @param id the id of the <code>Inventory</code> item
	 * @return the <code>Inventory</code> item if it's in the database, null if not
	 */
	public Inventory find(Long id)
	{
		Session session = sessionFactory.openSession();
		Inventory inventory = session.get(Inventory.class, id);
		session.close();
		return inventory;
	}

	/**
	 * Updates a <code>Inventory</code> item in the database 
	 * @param i the <code>Inventory</code> item
	 */
	public void update(Inventory i) 
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(i);	
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * Deletes a <code>Inventory</code> item in the database 
	 * @param i the <code>Inventory</code> item
	 */
	public void delete(Inventory i)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(i);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * Gets a list of all of the <code>Inventory</code> items in the database 
	 * @return the list of <code>Inventory</code> items
	 */
	@SuppressWarnings("unchecked")
	public List<Inventory> getList() 
	{
		Session session = sessionFactory.openSession();
		List<Inventory> inventory = (List<Inventory>) session.createQuery("from " + Inventory.class.getName()).list();
		session.close();
		return inventory;
	}
}
