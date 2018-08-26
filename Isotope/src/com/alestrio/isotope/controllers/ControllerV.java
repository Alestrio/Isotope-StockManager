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
import javafx.stage.Window;
import org.controlsfx.control.table.TableFilter;

import java.util.*;

public class ControllerV {
    DB db = new DB();
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



    public void initialize(){
        db.connect();
        db.createDatabase();
        showDbEntriesScrews();
    }

    @FXML
    void clickAddButton() {
        Dialog<Screw> d = new Dialog<>();
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
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

        GridPane g = new GridPane();
        g.add(label1, 1, 1);
        g.add(txtHead, 2, 1);
        g.add(label2, 1, 2);
        g.add(txtDiameter, 2, 2);
        g.add(label3, 1, 3);
        g.add(txtLength, 2, 3);
        g.add(label4, 1, 4);
        g.add(txtType, 2, 4);
        g.add(label5, 1, 5);
        g.add(txtColor, 2, 5);
        g.add(label6, 1, 6);
        g.add(txtQty, 2, 6);
        g.add(label7, 1, 7);
        g.add(txtPrice, 2, 7);

        d.getDialogPane().setContent(g);
        d.getDialogPane().getButtonTypes().add(ok);

        d.setResultConverter(param -> {
            if (ok == param)
                return new Screw(Double.parseDouble(txtDiameter.getText()),
                        Double.parseDouble(txtLength.getText()),
                        txtHead.getText(),
                        txtType.getText(),
                        txtColor.getText(),
                        Integer.parseInt(txtQty.getText()),
                        Double.parseDouble(txtPrice.getText()));
            else
                return null;
        });

        Optional<Screw> s = d.showAndWait();
        if (s.isPresent()) {
            s.get().add();
            showDbEntriesScrews();
        } else
            System.out.println("Non présent");


    }

    @FXML
    void clickDelButton() {
        tableS.getSelectionModel().getSelectedItem().delete();
        showDbEntriesScrews();
    }

    public void showDbEntriesScrews() {
        if (!(tableS == null))
            tableS.getColumns().clear();
        ObservableList<Screw> ols = db.getDbEntriesScrew();
        Collection<TableColumn<Screw, String>> t = new ArrayList<>();
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

        TableFilter<Screw> filter = new TableFilter<>(tableS);
    }

    @FXML
    void clickModifyButton() {
        Screw s = tableS.getSelectionModel().getSelectedItem();
        Dialog<Screw> d = new Dialog<>();
        d.setTitle("Modifier une vis");

        Label label1 = new Label("Tête");
        TextField txtHead = new TextField();
        txtHead.setText(s.getHead());
        Label label2 = new Label("Diamètre");
        TextField txtDiameter = new TextField();
        txtDiameter.setText(String.valueOf(s.getDiameter()));
        Label label3 = new Label("Longueur");
        TextField txtLength = new TextField();
        txtLength.setText(String.valueOf(s.getLength()));
        Label label4 = new Label("Matière");
        TextField txtType = new TextField();
        txtType.setText(s.getType());
        Label label5 = new Label("Couleur");
        TextField txtColor = new TextField();
        txtColor.setText(s.getColor());
        Label label6 = new Label("Quantité");
        TextField txtQty = new TextField();
        txtQty.setText(String.valueOf(s.getQty()));
        Label label7 = new Label("Prix à l'unité");
        TextField txtPrice = new TextField();
        txtPrice.setText(String.valueOf(s.getPrice()));
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

        GridPane g = new GridPane();
        g.add(label1, 1, 1);
        g.add(txtHead, 2, 1);
        g.add(label2, 1, 2);
        g.add(txtDiameter, 2, 2);
        g.add(label3, 1, 3);
        g.add(txtLength, 2, 3);
        g.add(label4, 1, 4);
        g.add(txtType, 2, 4);
        g.add(label5, 1, 5);
        g.add(txtColor, 2, 5);
        g.add(label6, 1, 6);
        g.add(txtQty, 2, 6);
        g.add(label7, 1, 7);
        g.add(txtPrice, 2, 7);

        d.getDialogPane().setContent(g);
        d.getDialogPane().getButtonTypes().add(ok);

        d.setResultConverter(param -> {
            if (ok == param)
                s.modify(Double.parseDouble(txtDiameter.getText()),
                        Double.parseDouble(txtLength.getText()),
                        txtHead.getText(),
                        txtType.getText(),
                        txtColor.getText(),
                        Integer.parseInt(txtQty.getText()),
                        Double.parseDouble(txtPrice.getText()));
            return null;
        });
        d.showAndWait();
        showDbEntriesScrews();
    }

    @FXML
    void clickTotalValue() {
        Dialog<String> t = new Dialog<>();
        Window w = t.getDialogPane().getScene().getWindow();
        List<Screw> screwList = db.getDbEntriesScrew();
        Iterator<Screw> i = screwList.iterator();
        double j = 0;
        while (i.hasNext()) {
            Screw f = i.next();
            j += f.getTotalPrice();
        }
        t.setContentText("La valeur totale est de " + j + "€");
        t.setTitle("Valeur totale");

        w.setOnCloseRequest(event -> w.hide());
        t.showAndWait();
    }

    @FXML
    void clickDuplicateBtn() {
        Screw s = tableS.getSelectionModel().getSelectedItem();
        Dialog<Screw> d = new Dialog<>();
        d.setTitle("Ajouter une vis");

        Label label1 = new Label("Tête");
        TextField txtHead = new TextField();
        txtHead.setText(s.getHead());
        Label label2 = new Label("Diamètre");
        TextField txtDiameter = new TextField();
        txtDiameter.setText(String.valueOf(s.getDiameter()));
        Label label3 = new Label("Longueur");
        TextField txtLength = new TextField();
        txtLength.setText(String.valueOf(s.getLength()));
        Label label4 = new Label("Matière");
        TextField txtType = new TextField();
        txtType.setText(s.getType());
        Label label5 = new Label("Couleur");
        TextField txtColor = new TextField();
        txtColor.setText(s.getColor());
        Label label6 = new Label("Quantité");
        TextField txtQty = new TextField();
        txtQty.setText(String.valueOf(s.getQty()));
        Label label7 = new Label("Prix à l'unité");
        TextField txtPrice = new TextField();
        txtPrice.setText(String.valueOf(s.getPrice()));
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

        GridPane g = new GridPane();
        g.add(label1, 1, 1);
        g.add(txtHead, 2, 1);
        g.add(label2, 1, 2);
        g.add(txtDiameter, 2, 2);
        g.add(label3, 1, 3);
        g.add(txtLength, 2, 3);
        g.add(label4, 1, 4);
        g.add(txtType, 2, 4);
        g.add(label5, 1, 5);
        g.add(txtColor, 2, 5);
        g.add(label6, 1, 6);
        g.add(txtQty, 2, 6);
        g.add(label7, 1, 7);
        g.add(txtPrice, 2, 7);

        d.getDialogPane().setContent(g);
        d.getDialogPane().getButtonTypes().add(ok);

        d.setResultConverter(param -> {
            if (ok == param)
                return new Screw(Double.parseDouble(txtDiameter.getText()),
                        Double.parseDouble(txtLength.getText()),
                        txtHead.getText(),
                        txtType.getText(),
                        txtColor.getText(),
                        Integer.parseInt(txtQty.getText()),
                        Double.parseDouble(txtPrice.getText()));
            else
                return null;
        });

        Optional<Screw> c = d.showAndWait();
        if (c.isPresent()) {
            c.get().add();
            showDbEntriesScrews();
        } else
            System.out.println("Non présent");
    }

    @FXML
    void clickDestockBtn() {
        Screw v = tableS.getSelectionModel().getSelectedItem();
        Dialog d = new Dialog();
        GridPane g = new GridPane();

        d.setTitle("Déstocker une vis");

        Label l1 = new Label("Déstocker");
        TextField txtQty = new TextField();
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

        g.add(l1, 1, 1);
        g.add(txtQty, 2, 1);

        d.getDialogPane().setContent(g);
        d.getDialogPane().getButtonTypes().add(ok);
        d.setResultConverter(param -> {
            if (ok == param) {
                v.modify(v.getQty() - Integer.parseInt(txtQty.getText()));
                return null;
            } else
                return null;
        });
        d.showAndWait();
        showDbEntriesScrews();
    }

    @FXML
    void clickStockBtn(){
        Screw v = tableS.getSelectionModel().getSelectedItem();
        Dialog d = new Dialog();
        GridPane g = new GridPane();

        d.setTitle("Stocker une vis");

        Label l1 = new Label("Stocker");
        TextField txtQty = new TextField();
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

        g.add(l1, 1, 1);
        g.add(txtQty, 2, 1);

        d.getDialogPane().setContent(g);
        d.getDialogPane().getButtonTypes().add(ok);
        d.setResultConverter(param -> {
            if (ok == param) {
                v.modify(v.getQty() + Integer.parseInt(txtQty.getText()));
                return null;
            } else
                return null;
        });
        d.showAndWait();
        showDbEntriesScrews();
    }
}


