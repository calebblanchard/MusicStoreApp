package com.blanchard.musicstore.view;

import java.io.IOException;

import com.blanchard.musicstore.spring.config.SpringFXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainViewController
{
	private final Stage primaryStage;
	private final SpringFXMLLoader springFXMLLoader;

	public MainViewController(SpringFXMLLoader springFXMLLoader, Stage stage)
	{
		this.springFXMLLoader = springFXMLLoader;
		this.primaryStage = stage;
	}

	public void switchToScene(final FXMLView view)
	{
		Parent root;
		try {
			root = springFXMLLoader.load(view.getFXMLFile());
			prepareSceneAndShow(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void prepareSceneAndShow(final Parent root)
	{
		Scene scene = primaryStage.getScene();

		if(scene == null)
			scene = new Scene(root);
		scene.setRoot(root);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
