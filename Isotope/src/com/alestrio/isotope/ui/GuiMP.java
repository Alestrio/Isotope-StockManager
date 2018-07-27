/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.ui;

import com.alestrio.isotope.DB;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public
class GuiMP extends Application {

	private BorderPane mainContainer;


    public
    void launch (Stage primaryStage) throws IOException {
		primaryStage.setTitle("Isotope H Alpha 1");
		Parent root  = FXMLLoader.load(getClass().getResource("fxml/IsotopeMP.fxml"));
		Scene  scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(javafx.stage.WindowEvent event) {
				DB db = new DB();
				db.disconnectIt();
				try {
					stop();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}


	@Override
	public void start(Stage primaryStage) throws Exception {

	}
}
