package com.alestrio.isotope.controllers;

import com.alestrio.isotope.DB;
import com.alestrio.isotope.materials.Screw;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Collection;

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
    private TextArea  txtArea;
    @FXML
    private Button    addBtn;
    @FXML
    private Button delBtn;


    @FXML
    void clickAddButton() {
        Screw v = new Screw(Double.parseDouble(txtDiameter.getText()) ,
                Double.parseDouble(txtLength.getText()) ,
                txtHead.getText() ,
                txtType.getText() ,
                txtColor.getText() ,
                Integer.parseInt(txtQty.getText()));
        if (db.addScrew(v))
            txtArea.appendText("Reussi !");
        try {
            showDbEntriesScrews();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clickDelButton(){
        db.eraseScrew(tableS.getSelectionModel().getSelectedItem());
        try{
            showDbEntriesScrews();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void showDbEntriesScrews () throws Exception {
        tableS.getColumns().clear();
        ObservableList<Screw>                  ols = db.getDbEntriesScrew();
        Collection<TableColumn<Screw, String>> t   = new ArrayList<>();
        tableS.setItems(ols);
        headColumnS.setCellValueFactory(new PropertyValueFactory<>("head"));
        t.add(headColumnS);
        diamColumnS.setCellValueFactory(new PropertyValueFactory<>("diameter"));
        t.add(diamColumnS);
        lengthColumnS.setCellValueFactory(new PropertyValueFactory<>("length"));
        t.add(lengthColumnS);
        typeColumnS.setCellValueFactory(new PropertyValueFactory<>("type"));
        t.add(typeColumnS);
        colorColumnS.setCellValueFactory(new PropertyValueFactory<>("color"));
        t.add(colorColumnS);
        qtyColumnS.setCellValueFactory(new PropertyValueFactory<>("qty"));
        t.add(qtyColumnS);
        tableS.getColumns().addAll(t);
        tableS.setVisible(true);
    }

    @FXML
    void clickConnectionBtn () {
        System.out.println(db.getDriverState());
        System.out.println(db.connect());
        try {
            showDbEntriesScrews();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
