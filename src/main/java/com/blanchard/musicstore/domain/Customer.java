package com.blanchard.musicstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.blanchard.musicstore.datatypes.Address;
import com.blanchard.musicstore.datatypes.CustomerName;

/**
 * Stores the info for a Customer
 */
@Entity
@Table(name="customer")
public class Customer
{
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private CustomerName name;
	private Address address;

	public Customer() {}
	
	@Autowired(required=true)
	public Customer(CustomerName name, Address address)
	{
		this.name = name;
		this.address = address;
	}

	public Long getId() 
	{
		return id;
	}

	public CustomerName getName()
	{
		return name;
	}

	public Address getAddress()
	{
		return address;
	}

	@Override
	public String toString()
	{
		return id + " " + name + " " + address;
	}
}
