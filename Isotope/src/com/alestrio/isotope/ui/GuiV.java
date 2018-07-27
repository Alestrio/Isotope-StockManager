/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.ui;

import com.alestrio.isotope.DB;
import com.alestrio.isotope.DBUtil;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class GuiV extends Application
{

    public
    void launch (Stage primaryStage) throws IOException {
        primaryStage.setTitle("Isotope H Alpha 1");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/IsotopeV.fxml"));
        Parent root = loader.load();
        Scene  scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<javafx.stage.WindowEvent>() {
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

            //TODO find a solution to show db entries on start of the programm
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }


}
