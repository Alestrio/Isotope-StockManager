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
import javafx.stage.Stage;

import java.io.IOException;

public class GuiV extends Application
{

    public
    void launch (Stage primaryStage) throws IOException {
        DB db = new DB("jdbc:postgresql://localhost:5432/isotope" ,"postgres" ,"postgre");
        primaryStage.setTitle("Isotope H Alpha 1");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/IsotopeV.fxml"));
        Parent root = loader.load();
        Scene  scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

            //TODO find a solution to show db entries on start of the programm
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
