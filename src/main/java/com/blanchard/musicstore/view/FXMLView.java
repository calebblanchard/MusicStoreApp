package com.blanchard.musicstore.view;

public enum FXMLView
{
	HOME_MENU 
	{
		@Override
		String getFXMLFile()
		{
			return "/fxml/homeMenu.fxml";
		}		
	},
	CUSTOMER_LIST 
	{
		@Override
		String getFXMLFile() 
		{
			return "/fxml/customerListView.fxml";
		}		
	},
	ADD_CUSTOMER 
	{
		@Override
		String getFXMLFile() 
		{
			return "/fxml/addCustomerView.fxml";
		}
	},
	INVENTORY_LIST 
	{
		@Override
		String getFXMLFile() 
		{
			return "/fxml/inventoryListView.fxml";
		}
	},
	ADD_INVENTORY 
	{
		@Override
		String getFXMLFile() 
		{
			return "/fxml/addInventoryView.fxml";
		}
	};
	
	abstract String getFXMLFile();
}
