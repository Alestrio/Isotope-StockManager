/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.ui;

import com.alestrio.isotope.Logging;
import com.alestrio.isotope.Settings;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GuiLauncher extends Application {
    static Logging log = new Logging();
    static Date date = new Date();
    static SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy '/' hh:mm:ss");



    public static void main(String[] args) {
        log.writeLog("########## Isotope Launched ##########");
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Settings s = new Settings();
        primaryStage.setTitle(s.getVer());
        Parent root = FXMLLoader.load(getClass().getResource("fxml/IsotopeLauncher.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}