package com.blanchard.musicstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.blanchard.musicstore.view.FXMLView;
import com.blanchard.musicstore.view.MainViewController;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Entry point for the application
 */
@SpringBootApplication
public class App extends Application
{
	protected ConfigurableApplicationContext springContext;
	protected MainViewController mainViewController;
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	
	@Override
	public void init() throws Exception
	{
		springContext = SpringApplication.run(App.class);      
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		mainViewController = springContext.getBean(MainViewController.class, primaryStage);
		mainViewController.switchToScene(FXMLView.HOME_MENU);
	}
}
