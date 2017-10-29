package com.blanchard.musicstore.service;

import java.util.List;

import com.blanchard.musicstore.domain.Customer;

public class CustomerService
{
	private static CustomerService customerService;
	private CustomerDao customerDao;

	private CustomerService()
	{
		this.customerDao = new CustomerDao();		
	}
	
	public static CustomerService getInstance()
	{
		if(customerService == null)
			customerService = new CustomerService();
		return customerService;
	}

	public void add(Customer c) 
	{
		customerDao.add(c);
	}

	public Customer find(Long id)
	{
		return customerDao.find(id);
	}

	public void update(Customer c) 
	{
		customerDao.update(c);
	}
	
	public void delete(Customer c)
	{
		customerDao.delete(c);
	}

	public List<Customer> getList() 
	{
		return customerDao.getList();
	}
}
