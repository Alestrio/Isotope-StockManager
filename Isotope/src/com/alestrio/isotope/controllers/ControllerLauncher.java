/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.controllers;

import com.alestrio.isotope.ui.GuiMP;
import com.alestrio.isotope.ui.GuiV;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public
class ControllerLauncher {
    @FXML
    Button v;
    @FXML
    Button mp;
    @FXML
    Button quit;

    @FXML
    private
    void vBtnClick (Event e) {
        GuiV g = new GuiV();
        try {
            g.launch(new Stage());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        ((Node) (e.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void mpButtonClick(Event e){
        GuiMP g = new GuiMP();
        try{
            g.launch(new Stage());
        }
        catch(Exception ioe){
            ioe.printStackTrace();
        }
        ((Node) (e.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void quitButtonClick(Event e){
        ((Node) (e.getSource())).getScene().getWindow().hide();
    }
}
