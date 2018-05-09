/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.ui;

import com.alestrio.isotope.DB;
import com.alestrio.isotope.controllers.ControllerV;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class GuiV extends Application
{
    private BorderPane mainContainer;
    private Alert alert;

    public
    void launch (Stage primaryStage) throws IOException, SQLException {
        DB db = new DB("jdbc:postgresql://localhost:5432/isotope" ,"postgres" ,"postgre");
        primaryStage.setTitle("Isotope H");
        Parent root  = FXMLLoader.load(getClass().getResource("fxml/IsotopeV.fxml"));
        Scene  scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


        if(!db.getDriverState()){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR !");
            alert.setContentText("Problème de driver JDBC");
        }
        db.connect();
        if(!db.getConnectionState()){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR !");
            alert.setContentText("Impossible de se connecter à la base de données");
        }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Method[] f = ControllerV.class.getDeclaredMethods();
            int i = 0;
            while(f.length != i){
                System.out.println(f[i].getName());
                if(f[i].getName().equals("showDbEntriesScrews")) {
                    try {
                        f[i].invoke(new ControllerV());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                i++;
        }



    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
