package com.blanchard.musicstore.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.blanchard.musicstore.domain.Inventory;
import com.blanchard.musicstore.service.InventoryService;
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
public class InventoryListViewController implements Initializable 
{
	private MainViewController mainViewController; // reference to the MainViewController

	private static InventoryService inventoryService;  // reference to the InventoryService

	@FXML private Button backButton;
	@FXML private TableView<Inventory> inventoryTable;
	@FXML private TableColumn<String, String> name;
	@FXML private TableColumn<String, String> description;
	@FXML private TableColumn<Integer, String> stock;
	@FXML private Button addInventoryButton;
	@FXML private Button removeInventoryButton;

	// CONSTRUCTORS
	
	public InventoryListViewController() {}

	@Lazy
	@Autowired(required=true)
	public InventoryListViewController(MainViewController mainViewController)
	{
		this.mainViewController = mainViewController;
		inventoryService = InventoryService.getInstance();
	}

	@Override
	public void initialize(URL location, ResourceBundle bundle)
	{
		name.setCellValueFactory(new PropertyValueFactory<String, String>("name"));
		description.setCellValueFactory(new PropertyValueFactory<String, String>("description"));
		stock.setCellValueFactory(new PropertyValueFactory<Integer, String>("stock"));
		refreshInventoryList();
	}

	/**
	 * Switches to the Home_Menu view when the "Back" button is clicked
	 */
	@FXML private void goBackToHomeView()
	{
		mainViewController.switchToScene(FXMLView.HOME_MENU);
	}

	/**
	 * Switches to the Add_Inventory view when the "Add Inventory" button is clicked
	 */
	@FXML private void addInventoryClicked()
	{
		mainViewController.switchToScene(FXMLView.ADD_INVENTORY);
	}	

	/**
	 * Loads/updates the list of inventory items listed in the TableView
	 */
	private void refreshInventoryList()
	{
		inventoryTable.setItems(getInventory());
		inventoryTable.refresh();
	}

	/**
	 * Gets a list of all inventory items in the database that can be displayed in a TableView
	 * @return the list of <code>Inventory</code> items
	 */
	private ObservableList<Inventory> getInventory()
	{
		return FXCollections.observableArrayList(inventoryService.getList());
	}
}