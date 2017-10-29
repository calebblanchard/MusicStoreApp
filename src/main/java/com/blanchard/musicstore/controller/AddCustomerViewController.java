package com.blanchard.musicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.blanchard.musicstore.datatypes.Address;
import com.blanchard.musicstore.datatypes.CustomerName;
import com.blanchard.musicstore.domain.Customer;
import com.blanchard.musicstore.service.CustomerService;
import com.blanchard.musicstore.view.FXMLView;
import com.blanchard.musicstore.view.MainViewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller for the Add_Customer view.
 * Manages the addition and removal of <code>Customer</code>s from the database
 */
@Component
public class AddCustomerViewController
{
	private MainViewController mainViewController; // reference to the MainViewController
	
	private CustomerService customerService; // reference to the CustomerService
	
	// Buttons
	@FXML private Button backButton;
	@FXML private Button addButton;
	
	// Labels
	@FXML private Label firstNameLabel;
	@FXML private Label middleInitialLabel;
	@FXML private Label lastNameLabel;
	@FXML private Label streetAddressLabel;
	@FXML private Label streetNameLabel;
	@FXML private Label townLabel;
	@FXML private Label stateLabel;
	@FXML private Label zipCodeLabel;

	// TextFields
	@FXML private TextField firstNameInput;
	@FXML private TextField middleInitialInput;
	@FXML private TextField lastNameInput;
	@FXML private TextField streetAddressInput;
	@FXML private TextField streetNameInput;
	@FXML private TextField townInput;
	@FXML private TextField stateInput;
	@FXML private TextField zipCodeInput;
	
	// CONSTRUCTORS
	
	public AddCustomerViewController() {}
	
	@Lazy @Autowired(required=true)
	public AddCustomerViewController(MainViewController mainViewController)
	{
		this.mainViewController = mainViewController;
		customerService = CustomerService.getInstance();
	}
	
	/**
	 * Switches to the Customer_List view when the "Back" button is clicked
	 */
	@FXML private void goBackToCustomerList()
	{
		mainViewController.switchToScene(FXMLView.CUSTOMER_LIST);
	}
	
	/**
	 * When the "Add Customer" button is clicked, if the customer info is 
	 * valid, creates a new <code>Customer</code> and adds it to the database
	 * Afterwards, sends the user back to the Customer_List view
	 */
	@FXML private void addCustomerClicked()
	{
		if(validateCustomer())
		{
			CustomerName name = retrieveCustomerName();
			Address address = retrieveCustomerAddress();
			customerService.add(new Customer(name, address));
			goBackToCustomerList();
		}			
	}
	
	/**
	 * Gets the <code>Customer</code>'s name info and creates
	 * and returns a new <code>CustomerName</code> with the info
	 * @return a <code>CustomerName</code> with the <code>Customer</code>'s name info
	 */
	private CustomerName retrieveCustomerName()
	{
		 return new CustomerName(firstNameInput.getText(), 
				 middleInitialInput.getText(), lastNameInput.getText());
	}
	
	/**
	 * Gets the <code>Customer</code>'s address info and creates 
	 * and returns a new <code>Address</code> with the info
	 * @return an <code>Address</code> with the <code>Customer</code>'s address info
	 */
	private Address retrieveCustomerAddress()
	{
		return new Address(streetAddressInput.getText(), streetNameInput.getText(), 
				townInput.getText(), stateInput.getText(), 
				Integer.parseInt(zipCodeInput.getText()));
	}
	
	/**
	 * Validates that all of the fields for a to be added customer are filled
	 * @return true if all of the fields are filled, false otherwise
	 */
	private boolean validateCustomer()
	{
		if(!firstNameInput.getText().isEmpty() 
				&& !middleInitialInput.getText().isEmpty()
				&& !lastNameInput.getText().isEmpty() 
				&& !streetAddressInput.getText().isEmpty() 
				&& !streetNameInput.getText().isEmpty() 
				&& !townInput.getText().isEmpty() 
				&& !stateInput.getText().isEmpty() 
				&& !zipCodeInput.getText().isEmpty())
			return true;
		else
			return false;
	}	
}