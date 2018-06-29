/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.controllers;

import com.alestrio.isotope.DB;
import com.alestrio.isotope.materials.Screw;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public
class ControllerV {
    private final DB db = new DB("jdbc:postgresql://localhost:5432/isotope" ,"postgres" ,"postgre");
    /*--- SCREW ---*/
    @FXML
    private TableView<Screw> tableS;
    @FXML
    private TableColumn<Screw, String> headColumnS;
    @FXML
    private TableColumn<Screw, String> diamColumnS;
    @FXML
    private TableColumn<Screw, String> lengthColumnS;
    @FXML
    private TableColumn<Screw, String> typeColumnS;
    @FXML
    private TableColumn<Screw, String> colorColumnS;
    @FXML
    private TableColumn<Screw, String> qtyColumnS;
    @FXML
    private TableColumn<Screw, String> totalPriceColumn;
    @FXML
    private TableColumn<Screw, String> priceColumn;

    @FXML
    private TextArea  txtArea;
    @FXML
    private Button    addBtn;
    @FXML
    private Button delBtn;
    @FXML
    private Button qtyBtn;

    private Alert alert;

    @FXML
    void clickAddButton() {
        Dialog d = new Dialog();
        d.setTitle("Ajouter une vis");

        Label label1 = new Label("Tête");
        TextField txtHead = new TextField();
        Label label2 = new Label("Diamètre");
        TextField txtDiameter = new TextField();
        Label label3 = new Label("Longueur");
        TextField txtLength = new TextField();
        Label label4 = new Label("Matière");
        TextField txtType = new TextField();
        Label label5 = new Label("Couleur");
        TextField txtColor = new TextField();
        Label label6 = new Label("Quantité");
        TextField txtQty = new TextField();
        Label label7 = new Label("Prix à l'unité");
        TextField txtPrice = new TextField();

        GridPane g = new GridPane();
        g.add(label1, 1, 1);
        g.add(txtHead, 2, 1);
        g.add(label2, 2, 2);
        g.add(txtDiameter, 3, 2);
        g.add(label3, 3, 3);
        g.add(txtLength, 4, 3);
        g.add(label4, 4, 4);
        g.add(txtType, 5, 4);
        //TODO Finish dialog



    }

    /*@FXML
    void clickQtyChangeButton(){
        Screw v = tableS.getSelectionModel().getSelectedItem();
        v.setQty(Integer.parseInt(txtQtyN.getText()));
        if(!v.qtyChange()){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR !");
            alert.setContentText("Impossible de changer la quantité");
        }
        showDbEntriesScrews();

    }*/

    @FXML
    void clickDelButton(){
        tableS.getSelectionModel().getSelectedItem().delete();
            showDbEntriesScrews();
    }

    @FXML
    public void showDbEntriesScrews () {
        if(!(tableS == null))
            tableS.getColumns().clear();
        ObservableList<Screw>                  ols = db.getDbEntriesScrew();
        Collection<TableColumn<Screw, String>> t   = new ArrayList<>();
        this.headColumnS.setCellValueFactory(new PropertyValueFactory<>("head"));
        t.add(headColumnS);
        this.diamColumnS.setCellValueFactory(new PropertyValueFactory<>("diameter"));
        t.add(diamColumnS);
        this.lengthColumnS.setCellValueFactory(new PropertyValueFactory<>("length"));
        t.add(lengthColumnS);
        this.typeColumnS.setCellValueFactory(new PropertyValueFactory<>("type"));
        t.add(typeColumnS);
        this.colorColumnS.setCellValueFactory(new PropertyValueFactory<>("color"));
        t.add(colorColumnS);
        this.qtyColumnS.setCellValueFactory(new PropertyValueFactory<>("qty"));
        t.add(qtyColumnS);
        this.priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        t.add(priceColumn);
        this.totalPriceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        t.add(totalPriceColumn);

        this.tableS.setItems(ols);
        this.tableS.getColumns().addAll(t);
        this.tableS.setVisible(true);
    }

    @FXML
    void clickConnectionBtn () throws SQLException {
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
        else
            showDbEntriesScrews();
    }

    @FXML
    void clickTotalValue(){
        Dialog<String> t = new Dialog<>();
        Window w = t.getDialogPane().getScene().getWindow();
        List<Screw> screwList = db.getDbEntriesScrew();
        Iterator<Screw> i = screwList.iterator();
        double j = 0;
        while (i.hasNext()){
            Screw f = i.next();
            j+=f.getTotalPrice();
        }
        t.setContentText("La valeur totale est de " +j+"€");
        t.setTitle("Valeur totale");

        w.setOnCloseRequest(event -> w.hide());
        t.showAndWait();
    }

    private boolean isSimilar(Screw s) {
        List<Screw> screwList = db.getDbEntriesScrew();
        for (Screw f : screwList) {
            if (f.getColor().equals(s.getColor()) && f.getType().equals(s.getType()) && f.getHead().equals(s.getHead()) && f.getLength() == s.getLength() && f.getDiameter() == s.getDiameter() && f.getQty() == s.getQty() && f.getPrice() == s.getPrice())
                return true;
        }
        return false;
    }
}
