package com.blanchard.musicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.blanchard.musicstore.domain.Inventory;
import com.blanchard.musicstore.service.InventoryService;
import com.blanchard.musicstore.view.FXMLView;
import com.blanchard.musicstore.view.MainViewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

@Component
public class AddInventoryViewController
{
	private MainViewController mainViewController; // reference to the MainViewController

	private static InventoryService inventoryService; // reference to the InventoryService

	// Buttons
	@FXML private Button backButton;
	@FXML private Button addButton;

	// Labels
	@FXML private Label nameLabel;
	@FXML private Label descriptionLabel;
	@FXML private Label stockLabel;

	// TextFields
	@FXML private TextField nameInput;
	@FXML private TextField descriptionInput;
	@FXML private TextField stockInput;

	// CONSTRUCTORS
	
	public AddInventoryViewController() {}

	@Lazy
	@Autowired(required=true)
	private AddInventoryViewController(MainViewController mainViewController)
	{
		this.mainViewController = mainViewController;
		inventoryService = InventoryService.getInstance();
	}

	/**
	 * Switches to the Inventory_List view when the "Back" button is clicked
	 */
	@FXML private void goBackToInventoryList()
	{
		mainViewController.switchToScene(FXMLView.INVENTORY_LIST);
	}

	/**
	 * When the "Add Inventory" button is clicked, if the inventory item info is
	 * valid, creates a new <code>Inventory</code> and adds it to the database
	 * Afterwards, sends the user back to the Inventory_List view
	 */
	@FXML private void addInventoryClicked()
	{
		if(validateInventory())
		{			
			Inventory inventory = retrieveInventory();
			inventoryService.add(inventory);
			goBackToInventoryList();
		}
	}

	/**
	 * Gets an <code>Inventory</code> item's info from the Add_Inventory view fields 
	 * and creates and returns a new <code>Inventory</code> with the info
	 * @return an <code>Inventory</code> with the <code>Inventory</code> item's info
	 */
	private Inventory retrieveInventory() 
	{
		return new Inventory(nameInput.getText(), descriptionInput.getText(), 
				Integer.parseInt(stockInput.getText()));
	}
	
	/**
	 * Validates that all of the fields for a to be added <code>Inventory</code> item are filled
	 * @return true if all of the fields are filled, false otherwise
	 */
	private boolean validateInventory()
	{
		if(!nameInput.getText().isEmpty() 
				&& !descriptionInput.getText().isEmpty()
				&& !stockInput.getText().isEmpty())
			return true;
		else
			return false;
	}	
}