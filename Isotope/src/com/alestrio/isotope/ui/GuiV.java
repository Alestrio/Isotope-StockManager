package com.alestrio.isotope.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public
class GuiV {
    private BorderPane mainContainer;


    public
    void launch (Stage primaryStage) throws IOException {
        primaryStage.setTitle("Isotope H");
        Parent root  = FXMLLoader.load(getClass().getResource("fxml/IsotopeV.fxml"));
        Scene  scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
