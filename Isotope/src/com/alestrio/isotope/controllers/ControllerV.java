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
    private TextField txtHead;
    @FXML
    private TextField txtDiameter;
    @FXML
    private TextField txtLength;
    @FXML
    private TextField txtType;
    @FXML
    private TextField txtColor;
    @FXML
    private TextField txtQty;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtQtyN;
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
        Screw v = new Screw(Double.parseDouble(txtDiameter.getText()) ,
                Double.parseDouble(txtLength.getText()) ,
                txtHead.getText() ,
                txtType.getText() ,
                txtColor.getText() ,
                Integer.parseInt(txtQty.getText()),
                Double.parseDouble(txtPrice.getText()));
        if(!isSimilar(v)){
            if(!v.add()){
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("ERREUR !");
                alert.setContentText("Impossible d'ajouter la vis");
            }
            else
                txtArea.appendText("Reussi !");
        }
        else
            txtArea.appendText("Item similaire");
        showDbEntriesScrews();
    }

    @FXML
    void clickQtyChangeButton(){
        Screw v = tableS.getSelectionModel().getSelectedItem();
        v.setQty(Integer.parseInt(txtQtyN.getText()));
        if(!v.qtyChange()){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR !");
            alert.setContentText("Impossible de changer la quantité");
        }
        showDbEntriesScrews();

    }

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
