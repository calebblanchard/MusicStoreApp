package com.blanchard.musicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.blanchard.musicstore.view.FXMLView;
import com.blanchard.musicstore.view.MainViewController;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

@Component
public class HomeViewController
{
	private MainViewController mainViewController; // reference to the MainViewController

	// Buttons
	@FXML private Button manageCustomers;
	@FXML private Button manageInventory;
	@FXML private Button manageOrders; // TODO: Managing Orders not yet implemented
	@FXML private Button exit;

	// CONSTRUCTORS

	public HomeViewController() {}

	@Lazy @Autowired(required=true)
	public HomeViewController(MainViewController mainViewController)
	{
		this.mainViewController = mainViewController;
	}

	/**
	 * Switches to the Customer_List view when the "Manage Customers" button is clicked
	 */
	@FXML private void manageCustomersClicked()
	{
		mainViewController.switchToScene(FXMLView.CUSTOMER_LIST);
	}

	/**
	 * Switches to the Inventory_List view when the "Manage Inventory" button is clicked
	 */
	@FXML private void manageInventoryClicked()
	{
		mainViewController.switchToScene(FXMLView.INVENTORY_LIST);
	}

	/**
	 * Shuts down the app when the Exit Button is clicked
	 */
	@FXML private void exitButtonClicked()
	{
		Platform.exit();
	}
}