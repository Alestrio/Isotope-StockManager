package com.alestrio.isotope.controllers;

import com.alestrio.isotope.DB;
import com.alestrio.isotope.materials.Screw;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

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


    @FXML
    void clickAddButton() {
        Screw v = new Screw(Double.parseDouble(txtDiameter.getText()) ,
                Double.parseDouble(txtLength.getText()) ,
                txtHead.getText() ,
                txtType.getText() ,
                txtColor.getText() ,
                Integer.parseInt(txtQty.getText()),
                Double.parseDouble(txtPrice.getText()));
        if(!isSimilar(v))
            if (db.addScrew(v))
                txtArea.appendText("Reussi !");
        else
            txtArea.appendText("Item similaire");
        showDbEntriesScrews();
    }

    @FXML
    void clickQtyChangeButton(){
        Screw v = tableS.getSelectionModel().getSelectedItem();
        v.setQty(Integer.parseInt(txtQtyN.getText()));
        db.qtyChangeScrew(v);
        try{
            showDbEntriesScrews();
        }
        catch(Exception e){
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

    public void showDbEntriesScrews () {
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
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        t.add(priceColumn);
        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        t.add(totalPriceColumn);

        tableS.getColumns().addAll(t);
        tableS.setVisible(true);
    }

    @FXML
    void clickConnectionBtn () {
        System.out.println(db.getDriverState());
        System.out.println(db.connect());
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

    boolean isSimilar(Screw s) {
        List<Screw> screwList = db.getDbEntriesScrew();
        Iterator<Screw> i = screwList.iterator();
        while (i.hasNext()){
            Screw f = i.next();
            if (f.getColor().equals(s.getColor()) && f.getType().equals(s.getType()) && f.getHead().equals(s.getHead()) && f.getLength() == s.getLength() && f.getDiameter() == s.getDiameter() && f.getQty() == s.getQty() && f.getPrice() == s.getPrice())
                return true;
        }
        return false;
    }
}
