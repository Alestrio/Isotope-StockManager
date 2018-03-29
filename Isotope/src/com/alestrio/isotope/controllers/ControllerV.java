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
    private final DB               db     = new DB("jdbc:postgresql://localhost:5432/isotope" ,"postgres" ,"postgres");
    /*--- SCREW ---*/
    @FXML
    private final TableView<Screw> tableS = new TableView<>();
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
    private TextField txtHeadS;
    @FXML
    private TextField txtDiameterS;
    @FXML
    private TextField txtLengthS;
    @FXML
    private TextField txtTypeS;
    @FXML
    private TextField txtColorS;
    @FXML
    private TextField txtQtyS;
    @FXML
    private TextArea  txtAreaS;
    @FXML
    private Button    addBtnS;


    @FXML
    void clickAddBtnScrew () {
        Screw v = new Screw(Double.parseDouble(txtDiameterS.getText()) ,
                Double.parseDouble(txtLengthS.getText()) ,
                txtHeadS.getText() ,
                txtTypeS.getText() ,
                txtColorS.getText() ,
                Integer.parseInt(txtQtyS.getText()));
        if (db.addScrew(v))
            txtAreaS.appendText("Reussi !");
        try {
            showDbEntriesScrews();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public
    void showDbEntriesScrews () throws Exception {
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
