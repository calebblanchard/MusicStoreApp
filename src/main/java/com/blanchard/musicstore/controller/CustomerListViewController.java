package com.blanchard.musicstore.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.blanchard.musicstore.datatypes.Address;
import com.blanchard.musicstore.datatypes.CustomerName;
import com.blanchard.musicstore.domain.Customer;
import com.blanchard.musicstore.service.CustomerService;
import com.blanchard.musicstore.view.FXMLView;
import com.blanchard.musicstore.view.MainViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

@Component
public class CustomerListViewController implements Initializable
{	
	private MainViewController mainViewController; // reference to the MainViewController

	private static CustomerService customerService;  // reference to the CustomerService

	// Buttons
	@FXML private Button backButton;
	@FXML private Button addCustomerButton;
	@FXML private Button removeCustomerButton;

	// TableView and TableColumns
	@FXML private TableView<Customer> customerTable;
	@FXML private TableColumn<CustomerName, String> name;
	@FXML private TableColumn<Address, String> address;


	// CONSTRUCTORS

	public CustomerListViewController() {}

	@Lazy
	@Autowired(required=true)
	public CustomerListViewController(MainViewController mainViewController)
	{
		this.mainViewController = mainViewController;
		customerService = CustomerService.getInstance();	
	}

	@Override
	public void initialize(URL location, ResourceBundle bundle)
	{
		name.setCellValueFactory(new PropertyValueFactory<CustomerName, String>("name"));
		address.setCellValueFactory(new PropertyValueFactory<Address, String>("address"));
		refreshCustomerList();
	}

	/**
	 * Switches to the Home_Menu view when the "Back" button is clicked
	 */
	@FXML private void goBackToHomeView()
	{
		mainViewController.switchToScene(FXMLView.HOME_MENU);
	}

	/**
	 * Switches to the Add_Customer view when the "Add Customer" button is clicked
	 */
	@FXML private void addCustomerClicked()
	{
		mainViewController.switchToScene(FXMLView.ADD_CUSTOMER);
	}

	/**
	 * Loads/updates the list of customers listed in the TableView
	 */
	private void refreshCustomerList()
	{
		customerTable.setItems(getCustomers());
		customerTable.refresh();
	}

	/**
	 * Gets a list of all customers in the database that can be displayed in a TableView
	 * @return the list of <code>Customer</code>s
	 */
	private ObservableList<Customer> getCustomers()
	{
		return FXCollections.observableArrayList(customerService.getList());
	}
}