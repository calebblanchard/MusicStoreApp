package com.blanchard.musicstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Stores the info for an Inventory item
 */
@Entity
@Table(name="inventory")
public class Inventory
{
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private int stock;
	
	public Inventory() {}
	
	@Autowired(required=true)
	public Inventory(String name, String description, int stock)
	{
		this.name = name;
		this.description = description;
		this.stock = stock;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getStock()
	{
		return stock;
	}

	public void setStock(int stock)
	{
		this.stock = stock;
	}
	
	@Override
	public String toString()
	{
		return id + " " + name + " " + description + " " + stock;
	}
}
