package com.blanchard.musicstore.service;

import java.util.List;

import com.blanchard.musicstore.domain.Inventory;

public class InventoryService
{
	private static InventoryService inventoryService;
	private InventoryDao inventoryDao;

	private InventoryService()
	{
		this.inventoryDao = new InventoryDao();		
	}
	
	public static InventoryService getInstance()
	{
		if(inventoryService == null)
			inventoryService = new InventoryService();
		return inventoryService;
	}

	public void add(Inventory i) 
	{
		inventoryDao.add(i);
	}

	public Inventory find(Long id)
	{
		return inventoryDao.find(id);
	}

	public void update(Inventory i) 
	{
		inventoryDao.update(i);
	}
	
	public void delete(Inventory i)
	{
		inventoryDao.delete(i);
	}

	public List<Inventory> getList() 
	{
		return inventoryDao.getList();
	}
}
