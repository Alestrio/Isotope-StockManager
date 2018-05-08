/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.ui;

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
		primaryStage.setTitle("Isotope H");
		Parent root  = FXMLLoader.load(getClass().getResource("fxml/IsotopeMP.fxml"));
		Scene  scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	@Override
	public void start(Stage primaryStage) throws Exception {

	}
}
