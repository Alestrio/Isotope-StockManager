/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.ui;

import com.alestrio.isotope.DB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public
class GuiMP extends Application {

	private BorderPane mainContainer;


    public
    void launch (Stage primaryStage) throws IOException {
		DB db = new DB("jdbc:postgresql://localhost:5432/isotope" ,"postgres" ,"postgres");
		primaryStage.setTitle("Isotope H Alpha 1");
		Parent root  = FXMLLoader.load(getClass().getResource("fxml/IsotopeMP.fxml"));
		Scene  scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		db.connect();

	}


	@Override
	public void start(Stage primaryStage) throws Exception {

	}
}
