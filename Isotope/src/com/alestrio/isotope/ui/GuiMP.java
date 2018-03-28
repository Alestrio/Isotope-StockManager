package com.alestrio.isotope.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public
class GuiMP extends Application {

	private BorderPane mainContainer;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Isotope H");
        Parent root  = FXMLLoader.load(getClass().getResource("IsotopeMP.fxml"));
		Scene  scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    public
    void launch () {
        Application.launch();
	}



}
