/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.controllers;

import com.alestrio.isotope.DB;
import com.alestrio.isotope.database.Database;
import com.alestrio.isotope.database.DbColumn;
import com.alestrio.isotope.database.XmlSettings;
import com.alestrio.isotope.materials.Cylinder;
import com.alestrio.isotope.materials.FilamentSpool;
import com.alestrio.isotope.materials.RectangularPiece;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ControllerMP {
    DB db = new DB();
    private XmlSettings settings;
    @FXML
    TabPane tabBase = new TabPane();
    ArrayList<Database> aldb = XmlSettings.parseFile();

    /*--- PLAQUES ---*/
    @FXML
    private TableView<RectangularPiece> tableR = new TableView<>();
    @FXML
    private TableColumn<RectangularPiece, String> typeColumnR;
    @FXML
    private TableColumn<RectangularPiece, String> lengthColumnR;
    @FXML
    private TableColumn<RectangularPiece, String> remainingLengthColumnR;
    @FXML
    private TableColumn<RectangularPiece, String> widthColumnR;
    @FXML
    private TableColumn<RectangularPiece, String> remainingWidthColumnR;
    @FXML
    private TableColumn<RectangularPiece, String> thicknessColumnR;
    @FXML
    private TableColumn<RectangularPiece, String> remainingThicknessColumnR;
    @FXML
    private TableColumn<RectangularPiece, String> colorColumnR;
    @FXML
    private TableColumn<RectangularPiece, String> qtyColumnR;
    @FXML
    private TableColumn<RectangularPiece, String> priceCmColumnR;
    @FXML
    private TableColumn<RectangularPiece, String> totalPriceColumnR;


    /*--- TABLEVIEW CYLINDERS ---*/
    @FXML
    private TableView<Cylinder> tableC = new TableView<>();
    @FXML
    private TableColumn<Cylinder, String> diameterColumnC;
    @FXML
    private TableColumn<Cylinder, String> lengthColumnC;
    @FXML
    private TableColumn<Cylinder, String> remainingLengthColumnC;
    @FXML
    private TableColumn<Cylinder, String> typeColumnC;
    @FXML
    private TableColumn<Cylinder, String> colorColumnC;
    @FXML
    private TableColumn<Cylinder, String> priceCmColumnC;
    @FXML
    private TableColumn<Cylinder, String> totalPriceColumnC;
    @FXML
    private TableColumn<Cylinder, String> qtyColumnC;

    /*--- TABLEVIEW SPOOLS ---*/
    @FXML
    private TableView<FilamentSpool> tableF = new TableView<>();
    @FXML
    private TableColumn<FilamentSpool, String> typeColumnF;
    @FXML
    private TableColumn<FilamentSpool, String> colorColumnF;
    @FXML
    private TableColumn<FilamentSpool, String> diameterColumnF;
    @FXML
    private TableColumn<FilamentSpool, String> weightColumnF;
    @FXML
    private TableColumn<FilamentSpool, String> remainingWeightColumnF;
    @FXML
    private TableColumn<FilamentSpool, String> priceCmColumnF;
    @FXML
    private TableColumn<FilamentSpool, String> totalPriceColumnF;
    @FXML
    private TableColumn<FilamentSpool, String> qtyColumnF;
    /*-------------------------------------------------------------------*/

    public void initialize() {
        db.connect();
        db.createDatabase();
        showDbEntries();
        for (Database db : aldb) {
            db.addDb();
        }
    }

        /*--- ADD BUTTONS ---*/

    @FXML
    void clickAddBtnSpool() {
        Dialog<FilamentSpool> d = new Dialog<>();
        d.setTitle("Ajouter une bobine de filament");

        Label l1 = new Label("Matière");
        TextField txtTypeF = new TextField();
        Label l2 = new Label("Couleur");
        TextField txtColorF = new TextField();
        Label l3 = new Label("Diamètre");
        TextField txtDiameterF = new TextField();
        Label l4 = new Label("Poids");
        TextField txtWeightF = new TextField();
        Label l5 = new Label("Poids restant");
        TextField txtRemainingWeightF = new TextField();
        Label l6 = new Label("Quantité");
        TextField txtQty = new TextField();
        Label l7 = new Label("Prix de la bobine");
        TextField txtPrice = new TextField();
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

        GridPane g = new GridPane();
        g.add(l1, 1, 1);
        g.add(txtTypeF, 2, 1);
        g.add(l2, 1, 2);
        g.add(txtColorF, 2, 2);
        g.add(l3, 1, 3);
        g.add(txtDiameterF, 2, 3);
        g.add(l4, 1, 4);
        g.add(txtWeightF, 2, 4);
        g.add(l5, 1, 5);
        g.add(txtRemainingWeightF, 2, 5);
        g.add(l6, 1, 6);
        g.add(txtQty, 2, 6);
        g.add(l7, 1, 7);
        g.add(txtPrice, 2, 7);

        d.getDialogPane().setContent(g);
        d.getDialogPane().getButtonTypes().add(ok);

        d.setResultConverter(param -> {
            if (ok == param) {
                return new FilamentSpool(Double.parseDouble(txtDiameterF.getText()),
                        Double.parseDouble(txtWeightF.getText()),
                        Double.parseDouble(txtRemainingWeightF.getText()),
                        txtColorF.getText(),
                        txtTypeF.getText(),
                        Integer.parseInt(txtQty.getText()),
                        Double.parseDouble(txtPrice.getText()));
            } else
                return null;
        });
        Optional<FilamentSpool> f = d.showAndWait();
        if (f.isPresent()) {
            f.get().add();
        }
        showDbEntries();
    }

    @FXML
    void clickAddBtnRec() {
        Dialog<RectangularPiece> d = new Dialog<>();
        d.setTitle("Ajouter une plaque");

        Label l1 = new Label("Longueur");
        TextField txtLength = new TextField();
        Label l2 = new Label("Largeur");
        TextField txtWidth = new TextField();
        Label l3 = new Label("Epaisseur");
        TextField txtThickness = new TextField();
        Label l4 = new Label("Matière");
        TextField txtType = new TextField();
        Label l5 = new Label("Couleur");
        TextField txtColor = new TextField();
        Label l6 = new Label("Longueur restante");
        TextField txtRemainingLength = new TextField();
        Label l7 = new Label("Largeur restante");
        TextField txtRemainingWidth = new TextField();
        Label l8 = new Label("Epaisseur restante");
        TextField txtRemainingThickness = new TextField();
        Label l9 = new Label("Prix de la pièce");
        TextField txtPrice = new TextField();
        Label l10 = new Label("Quantité");
        TextField txtQty = new TextField();
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

        GridPane g = new GridPane();
        g.add(l1, 1, 1);
        g.add(txtLength, 2, 1);
        g.add(l2, 1, 2);
        g.add(txtWidth, 2, 2);
        g.add(l3, 1, 3);
        g.add(txtThickness, 2, 3);
        g.add(l4, 1, 4);
        g.add(txtType, 2, 4);
        g.add(l5, 1, 5);
        g.add(txtColor, 2, 5);
        g.add(l6, 1, 6);
        g.add(txtRemainingLength, 2, 6);
        g.add(l7, 1, 7);
        g.add(txtRemainingWidth, 2, 7);
        g.add(l8, 1, 8);
        g.add(txtRemainingThickness, 2, 8);
        g.add(l9, 1, 9);
        g.add(txtPrice, 2, 9);
        g.add(l10, 1, 10);
        g.add(txtQty, 2, 10);

        d.getDialogPane().setContent(g);
        d.getDialogPane().getButtonTypes().add(ok);

        d.setResultConverter(param -> {
            if (ok == param) {
                return new RectangularPiece(Double.parseDouble(txtLength.getText()),
                        Double.parseDouble(txtWidth.getText()),
                        Double.parseDouble(txtThickness.getText()),
                        txtType.getText(),
                        txtColor.getText(),
                        Double.parseDouble(txtRemainingLength.getText()),
                        Double.parseDouble(txtRemainingWidth.getText()),
                        Double.parseDouble(txtRemainingThickness.getText()),
                        Double.parseDouble(txtPrice.getText()),
                        Integer.parseInt(txtQty.getText()));
            } else
                return null;
        });
        Optional<RectangularPiece> f = d.showAndWait();
        if (f.isPresent())
            f.get().add();

        showDbEntries();
    }

    @FXML
    void clickAddBtnCylinder() {
        Dialog<Cylinder> d = new Dialog<>();
        d.setTitle("Ajouter un cylindre");

        Label l1 = new Label("Diamètre");
        TextField txtDiameter = new TextField();
        Label l2 = new Label("Longueur");
        TextField txtLength = new TextField();
        Label l3 = new Label("Matière");
        TextField txtType = new TextField();
        Label l4 = new Label("Couleur");
        TextField txtColor = new TextField();
        Label l5 = new Label("Prix de la pièce");
        TextField txtPrice = new TextField();
        Label l6 = new Label("Longueur restante");
        TextField txtRemainingLength = new TextField();
        Label l7 = new Label("Quantité");
        TextField txtQty = new TextField();
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

        GridPane g = new GridPane();
        g.add(l1, 1, 1);
        g.add(txtDiameter, 2, 1);
        g.add(l2, 1, 2);
        g.add(txtLength, 2, 2);
        g.add(l3, 1, 3);
        g.add(txtType, 2, 3);
        g.add(l4, 1, 4);
        g.add(txtColor, 2, 4);
        g.add(l5, 1, 5);
        g.add(txtPrice, 2, 5);
        g.add(l6, 1, 6);
        g.add(txtRemainingLength, 2, 6);
        g.add(l7, 1, 7);
        g.add(txtQty, 2, 7);

        d.getDialogPane().setContent(g);
        d.getDialogPane().getButtonTypes().add(ok);

        d.setResultConverter(param -> {
            if (ok == param) {
                return new Cylinder(Double.parseDouble(txtDiameter.getText()),
                        Double.parseDouble(txtLength.getText()),
                        txtType.getText(),
                        txtColor.getText(),
                        Double.parseDouble(txtPrice.getText()),
                        Double.parseDouble(txtRemainingLength.getText()),
                        Integer.parseInt(txtQty.getText()));
            } else
                return null;
        });
        Optional<Cylinder> f = d.showAndWait();
        if (f.isPresent()) {
            f.get().add();
        }
        showDbEntries();
    }

    /*--- MODIFY BUTTONS ---*/
    //TODO Boutons de modification
    @FXML
    void clickModBtnR() {
        RectangularPiece r = tableR.getSelectionModel().getSelectedItem();
        Dialog<RectangularPiece> d = new Dialog<>();
        d.setTitle("Modifier une plaque");

        Label l1 = new Label("Longueur");
        TextField txtLength = new TextField();
        txtLength.setText(String.valueOf(r.getLength()));
        Label l2 = new Label("Largeur");
        TextField txtWidth = new TextField();
        txtWidth.setText(String.valueOf(r.getWidth()));
        Label l3 = new Label("Epaisseur");
        TextField txtThickness = new TextField();
        txtThickness.setText(String.valueOf(r.getThickness()));
        Label l4 = new Label("Matière");
        TextField txtType = new TextField();
        txtType.setText(r.getType());
        Label l5 = new Label("Couleur");
        TextField txtColor = new TextField();
        txtColor.setText(r.getColor());
        Label l6 = new Label("Longueur restante");
        TextField txtRemainingLength = new TextField();
        txtRemainingLength.setText(String.valueOf(r.getRemainingLength()));
        Label l7 = new Label("Largeur restante");
        TextField txtRemainingWidth = new TextField();
        txtRemainingWidth.setText(String.valueOf(r.getRemainingWidth()));
        Label l8 = new Label("Epaisseur restante");
        TextField txtRemainingThickness = new TextField();
        txtRemainingThickness.setText(String.valueOf(r.getRemainingThickness()));
        Label l9 = new Label("Prix de la pièce");
        TextField txtPrice = new TextField();
        txtPrice.setText(String.valueOf(r.getPrice()));
        Label l10 = new Label("Quantité");
        TextField txtQty = new TextField();
        txtQty.setText(String.valueOf(r.getQty()));
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

        GridPane g = new GridPane();
        g.add(l1, 1, 1);
        g.add(txtLength, 2, 1);
        g.add(l2, 1, 2);
        g.add(txtWidth, 2, 2);
        g.add(l3, 1, 3);
        g.add(txtThickness, 2, 3);
        g.add(l4, 1, 4);
        g.add(txtType, 2, 4);
        g.add(l5, 1, 5);
        g.add(txtColor, 2, 5);
        g.add(l6, 1, 6);
        g.add(txtRemainingLength, 2, 6);
        g.add(l7, 1, 7);
        g.add(txtRemainingWidth, 2, 7);
        g.add(l8, 1, 8);
        g.add(txtRemainingThickness, 2, 8);
        g.add(l9, 1, 9);
        g.add(txtPrice, 2, 9);
        g.add(l10, 1, 10);
        g.add(txtQty, 2, 10);

        d.getDialogPane().setContent(g);
        d.getDialogPane().getButtonTypes().add(ok);

        d.setResultConverter(param -> {
            if (ok == param) {
                r.modify(Double.parseDouble(txtLength.getText()),
                        Double.parseDouble(txtWidth.getText()),
                        Double.parseDouble(txtThickness.getText()),
                        txtType.getText(),
                        txtColor.getText(),
                        Double.parseDouble(txtRemainingLength.getText()),
                        Double.parseDouble(txtRemainingWidth.getText()),
                        Double.parseDouble(txtRemainingThickness.getText()),
                        Double.parseDouble(txtPrice.getText()),
                        Integer.parseInt(txtQty.getText()));
                return null;
            } else
                return null;
        });
        d.showAndWait();
        showDbEntriesRec();
    }

    @FXML
    void clickModBtnC() {
        Cylinder c = tableC.getSelectionModel().getSelectedItem();
        Dialog<Cylinder> d = new Dialog<>();
        d.setTitle("Modifier un cylindre");

        Label l1 = new Label("Diamètre");
        TextField txtDiameter = new TextField();
        txtDiameter.setText(String.valueOf(c.getDiameter()));
        Label l2 = new Label("Longueur");
        TextField txtLength = new TextField();
        txtLength.setText(String.valueOf(c.getLength()));
        Label l3 = new Label("Matière");
        TextField txtType = new TextField();
        txtType.setText(c.getType());
        Label l4 = new Label("Couleur");
        TextField txtColor = new TextField();
        txtColor.setText(c.getColor());
        Label l5 = new Label("Prix de la pièce");
        TextField txtPrice = new TextField();
        txtPrice.setText(String.valueOf(c.getPrice()));
        Label l6 = new Label("Longueur restante");
        TextField txtRemainingLength = new TextField();
        txtRemainingLength.setText(String.valueOf(c.getRemainingLength()));
        Label l7 = new Label("Quantité");
        TextField txtQty = new TextField();
        txtQty.setText(String.valueOf(c.getQty()));
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

        GridPane g = new GridPane();
        g.add(l1, 1, 1);
        g.add(txtDiameter, 2, 1);
        g.add(l2, 1, 2);
        g.add(txtLength, 2, 2);
        g.add(l3, 1, 3);
        g.add(txtType, 2, 3);
        g.add(l4, 1, 4);
        g.add(txtColor, 2, 4);
        g.add(l5, 1, 5);
        g.add(txtPrice, 2, 5);
        g.add(l6, 1, 6);
        g.add(txtRemainingLength, 2, 6);
        g.add(l7, 1, 7);
        g.add(txtQty, 2, 7);

        d.getDialogPane().setContent(g);
        d.getDialogPane().getButtonTypes().add(ok);

        d.setResultConverter(param -> {
            if (ok == param) {
                c.modify(Double.parseDouble(txtDiameter.getText()),
                        Double.parseDouble(txtLength.getText()),
                        txtType.getText(),
                        txtColor.getText(),
                        Double.parseDouble(txtRemainingLength.getText()),
                        Integer.parseInt(txtQty.getText()),
                        Double.parseDouble(txtPrice.getText()));
                return null;
            } else
                return null;
        });
        d.showAndWait();
        showDbEntriesCylinders();
    }

    @FXML
    void clickModBtnF() {
        FilamentSpool s = tableF.getSelectionModel().getSelectedItem();
        Dialog<FilamentSpool> d = new Dialog<>();
        d.setTitle("Dupliquer une bobine de filament");

        Label l1 = new Label("Matière");
        TextField txtType = new TextField();
        txtType.setText(s.getType());
        Label l2 = new Label("Couleur");
        TextField txtColor = new TextField();
        txtColor.setText(s.getColor());
        Label l3 = new Label("Diamètre");
        TextField txtDiameter = new TextField();
        txtDiameter.setText(String.valueOf(s.getDiameter()));
        Label l4 = new Label("Poids");
        TextField txtWeight = new TextField();
        txtWeight.setText(String.valueOf(s.getInitialWeight()));
        Label l5 = new Label("Poids restant");
        TextField txtRemainingWeight = new TextField();
        txtRemainingWeight.setText(String.valueOf(s.getRemainingWeight()));
        Label l6 = new Label("Quantité");
        TextField txtQty = new TextField();
        txtQty.setText(String.valueOf(s.getQty()));
        Label l7 = new Label("Prix de la bobine");
        TextField txtPrice = new TextField();
        txtPrice.setText(String.valueOf(s.getPrice()));
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

        GridPane g = new GridPane();
        g.add(l1, 1, 1);
        g.add(txtType, 2, 1);
        g.add(l2, 1, 2);
        g.add(txtColor, 2, 2);
        g.add(l3, 1, 3);
        g.add(txtDiameter, 2, 3);
        g.add(l4, 1, 4);
        g.add(txtWeight, 2, 4);
        g.add(l5, 1, 5);
        g.add(txtRemainingWeight, 2, 5);
        g.add(l6, 1, 6);
        g.add(txtQty, 2, 6);
        g.add(l7, 1, 7);
        g.add(txtPrice, 2, 7);

        d.getDialogPane().setContent(g);
        d.getDialogPane().getButtonTypes().add(ok);

        d.setResultConverter(param -> {
            if (ok == param) {
                s.modify(Double.parseDouble(txtDiameter.getText()),
                        Double.parseDouble(txtWeight.getText()),
                        Double.parseDouble(txtRemainingWeight.getText()),
                        txtType.getText(),
                        txtColor.getText(),
                        Integer.parseInt(txtQty.getText()),
                        Double.parseDouble(txtPrice.getText()));
                return null;
            } else
                return null;
        });
        d.showAndWait();
        showDbEntriesSpool();
    }

    /*--- ERASE BUTTONS ---*/
    @FXML
    void clickDelBtnR() {
        RectangularPiece r = tableR.getSelectionModel().getSelectedItem();
        r.delete();
        showDbEntriesRec();
    }

    @FXML
    void clickDelBtnC() {
        Cylinder c = tableC.getSelectionModel().getSelectedItem();
        c.delete();
        showDbEntriesCylinders();
    }

    @FXML
    void clickDelBtnF() {
        FilamentSpool f = tableF.getSelectionModel().getSelectedItem();
        f.delete();
        showDbEntriesSpool();
    }

    /*--- DUPLICATE BUTTONS ---*/
    @FXML
    void clickDuplicateBtnR() {
        RectangularPiece r = tableR.getSelectionModel().getSelectedItem();
        Dialog<RectangularPiece> d = new Dialog<>();
        d.setTitle("Dupliquer une plaque");

        Label l1 = new Label("Longueur");
        TextField txtLength = new TextField();
        txtLength.setText(String.valueOf(r.getLength()));
        Label l2 = new Label("Largeur");
        TextField txtWidth = new TextField();
        txtWidth.setText(String.valueOf(r.getWidth()));
        Label l3 = new Label("Epaisseur");
        TextField txtThickness = new TextField();
        txtThickness.setText(String.valueOf(r.getThickness()));
        Label l4 = new Label("Matière");
        TextField txtType = new TextField();
        txtType.setText(r.getType());
        Label l5 = new Label("Couleur");
        TextField txtColor = new TextField();
        txtColor.setText(r.getColor());
        Label l6 = new Label("Longueur restante");
        TextField txtRemainingLength = new TextField();
        txtRemainingLength.setText(String.valueOf(r.getRemainingLength()));
        Label l7 = new Label("Largeur restante");
        TextField txtRemainingWidth = new TextField();
        txtRemainingWidth.setText(String.valueOf(r.getRemainingWidth()));
        Label l8 = new Label("Epaisseur restante");
        TextField txtRemainingThickness = new TextField();
        txtRemainingThickness.setText(String.valueOf(r.getRemainingThickness()));
        Label l9 = new Label("Prix de la pièce");
        TextField txtPrice = new TextField();
        txtPrice.setText(String.valueOf(r.getPrice()));
        Label l10 = new Label("Quantité");
        TextField txtQty = new TextField();
        txtQty.setText(String.valueOf(r.getQty()));
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

        GridPane g = new GridPane();
        g.add(l1, 1, 1);
        g.add(txtLength, 2, 1);
        g.add(l2, 1, 2);
        g.add(txtWidth, 2, 2);
        g.add(l3, 1, 3);
        g.add(txtThickness, 2, 3);
        g.add(l4, 1, 4);
        g.add(txtType, 2, 4);
        g.add(l5, 1, 5);
        g.add(txtColor, 2, 5);
        g.add(l6, 1, 6);
        g.add(txtRemainingLength, 2, 6);
        g.add(l7, 1, 7);
        g.add(txtRemainingWidth, 2, 7);
        g.add(l8, 1, 8);
        g.add(txtRemainingThickness, 2, 8);
        g.add(l9, 1, 9);
        g.add(txtPrice, 2, 9);
        g.add(l10, 1, 10);
        g.add(txtQty, 2, 10);

        d.getDialogPane().setContent(g);
        d.getDialogPane().getButtonTypes().add(ok);

        d.setResultConverter(param -> {
            if (ok == param) {
                return new RectangularPiece(Double.parseDouble(txtLength.getText()),
                        Double.parseDouble(txtWidth.getText()),
                        Double.parseDouble(txtThickness.getText()),
                        txtType.getText(),
                        txtColor.getText(),
                        Double.parseDouble(txtRemainingLength.getText()),
                        Double.parseDouble(txtRemainingWidth.getText()),
                        Double.parseDouble(txtRemainingThickness.getText()),
                        Double.parseDouble(txtPrice.getText()),
                        Integer.parseInt(txtQty.getText()));
            } else
                return null;
        });
        Optional<RectangularPiece> f = d.showAndWait();
        if (f.isPresent())
            f.get().add();

        showDbEntriesRec();
    }

    @FXML
    void clickDuplicateBtnC() {
        Cylinder c = tableC.getSelectionModel().getSelectedItem();
        Dialog<Cylinder> d = new Dialog<>();
        d.setTitle("Dupliquer un cylindre");

        Label l1 = new Label("Diamètre");
        TextField txtDiameter = new TextField();
        txtDiameter.setText(String.valueOf(c.getDiameter()));
        Label l2 = new Label("Longueur");
        TextField txtLength = new TextField();
        txtLength.setText(String.valueOf(c.getLength()));
        Label l3 = new Label("Matière");
        TextField txtType = new TextField();
        txtType.setText(c.getType());
        Label l4 = new Label("Couleur");
        TextField txtColor = new TextField();
        txtColor.setText(c.getColor());
        Label l5 = new Label("Prix de la pièce");
        TextField txtPrice = new TextField();
        txtPrice.setText(String.valueOf(c.getPrice()));
        Label l6 = new Label("Longueur restante");
        TextField txtRemainingLength = new TextField();
        txtRemainingLength.setText(String.valueOf(c.getRemainingLength()));
        Label l7 = new Label("Quantité");
        TextField txtQty = new TextField();
        txtQty.setText(String.valueOf(c.getQty()));
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

        GridPane g = new GridPane();
        g.add(l1, 1, 1);
        g.add(txtDiameter, 2, 1);
        g.add(l2, 1, 2);
        g.add(txtLength, 2, 2);
        g.add(l3, 1, 3);
        g.add(txtType, 2, 3);
        g.add(l4, 1, 4);
        g.add(txtColor, 2, 4);
        g.add(l5, 1, 5);
        g.add(txtPrice, 2, 5);
        g.add(l6, 1, 6);
        g.add(txtRemainingLength, 2, 6);
        g.add(l7, 1, 7);
        g.add(txtQty, 2, 7);

        d.getDialogPane().setContent(g);
        d.getDialogPane().getButtonTypes().add(ok);

        d.setResultConverter(param -> {
            if (ok == param) {
                return new Cylinder(Double.parseDouble(txtDiameter.getText()),
                        Double.parseDouble(txtLength.getText()),
                        txtType.getText(),
                        txtColor.getText(),
                        Double.parseDouble(txtPrice.getText()),
                        Double.parseDouble(txtRemainingLength.getText()),
                        Integer.parseInt(txtQty.getText()));
            } else
                return null;
        });
        Optional<Cylinder> f = d.showAndWait();
        if (f.isPresent()) {
            f.get().add();
        }
        showDbEntriesCylinders();
    }

    @FXML
    void clickDuplicateBtnF() {
        FilamentSpool s = tableF.getSelectionModel().getSelectedItem();
        Dialog<FilamentSpool> d = new Dialog<>();
        d.setTitle("Dupliquer une bobine de filament");

        Label l1 = new Label("Matière");
        TextField txtType = new TextField();
        txtType.setText(s.getType());
        Label l2 = new Label("Couleur");
        TextField txtColor = new TextField();
        txtColor.setText(s.getColor());
        Label l3 = new Label("Diamètre");
        TextField txtDiameter = new TextField();
        txtDiameter.setText(String.valueOf(s.getDiameter()));
        Label l4 = new Label("Poids");
        TextField txtWeight = new TextField();
        txtWeight.setText(String.valueOf(s.getInitialWeight()));
        Label l5 = new Label("Poids restant");
        TextField txtRemainingWeight = new TextField();
        txtRemainingWeight.setText(String.valueOf(s.getRemainingWeight()));
        Label l6 = new Label("Quantité");
        TextField txtQty = new TextField();
        txtQty.setText(String.valueOf(s.getQty()));
        Label l7 = new Label("Prix de la bobine");
        TextField txtPrice = new TextField();
        txtPrice.setText(String.valueOf(s.getPrice()));
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

        GridPane g = new GridPane();
        g.add(l1, 1, 1);
        g.add(txtType, 2, 1);
        g.add(l2, 1, 2);
        g.add(txtColor, 2, 2);
        g.add(l3, 1, 3);
        g.add(txtDiameter, 2, 3);
        g.add(l4, 1, 4);
        g.add(txtWeight, 2, 4);
        g.add(l5, 1, 5);
        g.add(txtRemainingWeight, 2, 5);
        g.add(l6, 1, 6);
        g.add(txtQty, 2, 6);
        g.add(l7, 1, 7);
        g.add(txtPrice, 2, 7);

        d.getDialogPane().setContent(g);
        d.getDialogPane().getButtonTypes().add(ok);

        d.setResultConverter(param -> {
            if (ok == param) {
                return new FilamentSpool(Double.parseDouble(txtDiameter.getText()),
                        Double.parseDouble(txtWeight.getText()),
                        Double.parseDouble(txtRemainingWeight.getText()),
                        txtType.getText(),
                        txtColor.getText(),
                        Integer.parseInt(txtQty.getText()),
                        Double.parseDouble(txtPrice.getText()));
            } else
                return null;
        });
        Optional<FilamentSpool> f = d.showAndWait();
        if (f.isPresent()) {
            f.get().add();
        }
        showDbEntriesSpool();
    }

    /*--- OTHER BUTTONS ---*/


    /*--- TOTAL VALUE BUTTONS ---*/
    @FXML
    void clickTotalValueR() {
        double i = 0;
        ObservableList<RectangularPiece> olr = db.getDbEntriesRecPieces();

        for (RectangularPiece r : olr) {
            i += r.getTotalPrice();
        }
        Dialog d = new Dialog();
        d.setTitle("Valeur totale des plaques");
        d.setContentText(String.format("Valeur totale : %s €", i));
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().add(ok);
        d.show();
    }

    @FXML
    void clickTotalValueC() {
        double i = 0;
        ObservableList<Cylinder> olc = db.getDbEntriesCylinders();

        for (Cylinder r : olc) {
            i += r.getTotalPrice();
        }
        Dialog d = new Dialog();
        d.setTitle("Valeur totale des cylindres");
        d.setContentText(String.format("Valeur totale : %s €", i));
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().add(ok);
        d.show();
    }

    @FXML
    void clickTotalValueF() {
        double i = 0;
        ObservableList<FilamentSpool> olf = db.getDbEntriesSpool();

        for (FilamentSpool r : olf) {
            i += r.getTotalPrice();
        }
        Dialog d = new Dialog();
        d.setTitle("Valeur totale des bobines de filament");
        d.setContentText(String.format("Valeur totale : %s €", i));
        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().add(ok);
        d.show();
    }

    @FXML
    void clickConnectionBtn() {
        System.out.println(db.connect());
        showDbEntries();
    }

    /*--- SHOWDBENTRIES... ---*/

    private void showDbEntriesRec() {
        tableR.getColumns().clear();
        ObservableList<RectangularPiece> olr = db.getDbEntriesRecPieces();
        Collection<TableColumn<RectangularPiece, String>> t = new ArrayList<>();
        tableR.setItems(olr);
        typeColumnR.setCellValueFactory(new PropertyValueFactory<>("type"));
        t.add(typeColumnR);
        lengthColumnR.setCellValueFactory(new PropertyValueFactory<>("length"));
        t.add(lengthColumnR);
        remainingLengthColumnR.setCellValueFactory(new PropertyValueFactory<>("remainingLength"));
        t.add(remainingLengthColumnR);
        widthColumnR.setCellValueFactory(new PropertyValueFactory<>("width"));
        t.add(widthColumnR);
        remainingWidthColumnR.setCellValueFactory(new PropertyValueFactory<>("remainingWidth"));
        t.add(remainingWidthColumnR);
        thicknessColumnR.setCellValueFactory(new PropertyValueFactory<>("thickness"));
        t.add(thicknessColumnR);
        remainingThicknessColumnR.setCellValueFactory(new PropertyValueFactory<>("remainingThickness"));
        t.add(remainingThicknessColumnR);
        colorColumnR.setCellValueFactory(new PropertyValueFactory<>("color"));
        t.add(colorColumnR);
        qtyColumnR.setCellValueFactory(new PropertyValueFactory<>("qty"));
        t.add(qtyColumnR);
        priceCmColumnR.setCellValueFactory(new PropertyValueFactory<>("priceCm"));
        t.add(priceCmColumnR);
        totalPriceColumnR.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        t.add(totalPriceColumnR);
        tableR.getColumns().addAll(t);
        tableR.setVisible(true);

        //TODO TableFilter<RectangularPiece> filter = new TableFilter<>(tableR);
    }

    private void showDbEntriesCylinders() {
        tableC.getColumns().clear();
        ObservableList<Cylinder> olc = db.getDbEntriesCylinders();
        Collection<TableColumn<Cylinder, String>> t = new ArrayList<>();
        tableC.setItems(olc);
        diameterColumnC.setCellValueFactory(new PropertyValueFactory<>("diameter"));
        t.add(diameterColumnC);
        lengthColumnC.setCellValueFactory(new PropertyValueFactory<>("length"));
        t.add(lengthColumnC);
        remainingLengthColumnC.setCellValueFactory(new PropertyValueFactory<>("remainingLength"));
        t.add(remainingLengthColumnC);
        typeColumnC.setCellValueFactory(new PropertyValueFactory<>("type"));
        t.add(typeColumnC);
        colorColumnC.setCellValueFactory(new PropertyValueFactory<>("color"));
        t.add(colorColumnC);
        priceCmColumnC.setCellValueFactory(new PropertyValueFactory<>("priceCm"));
        t.add(priceCmColumnC);
        totalPriceColumnC.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        t.add(totalPriceColumnC);
        qtyColumnC.setCellValueFactory(new PropertyValueFactory<>("qty"));
        t.add(qtyColumnC);
        tableC.getColumns().addAll(t);
        tableC.setVisible(true);

        //TODO TableFilter<Cylinder> filter = new TableFilter<>(tableC);
    }

    private void showDbEntriesSpool() {
        tableF.getColumns().clear();
        ObservableList<FilamentSpool> olf = db.getDbEntriesSpool();
        tableF.setItems(olf);
        Collection<TableColumn<FilamentSpool, String>> t = new ArrayList<>();
        typeColumnF.setCellValueFactory(new PropertyValueFactory<>("type"));
        t.add(typeColumnF);
        colorColumnF.setCellValueFactory(new PropertyValueFactory<>("color"));
        t.add(colorColumnF);
        diameterColumnF.setCellValueFactory(new PropertyValueFactory<>("diameter"));
        t.add(diameterColumnF);
        weightColumnF.setCellValueFactory(new PropertyValueFactory<>("initialWeight"));
        t.add(weightColumnF);
        remainingWeightColumnF.setCellValueFactory(new PropertyValueFactory<>("remainingWeight"));
        t.add(remainingWeightColumnF);
        priceCmColumnF.setCellValueFactory(new PropertyValueFactory<>("priceCm"));
        t.add(priceCmColumnF);
        totalPriceColumnF.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        t.add(totalPriceColumnF);
        qtyColumnF.setCellValueFactory(new PropertyValueFactory<>("qty"));
        t.add(qtyColumnF);

        tableF.getColumns().addAll(t);
        tableF.setVisible(true);

        //TODO TableFilter<FilamentSpool> filter = new TableFilter<>(tableF);
    }

    private void showDbEntries() {
        try {
            db.connect();
            showDbEntriesSpool();
            showDbEntriesRec();
            showDbEntriesCylinders();
            if(aldb != null){
                //TODO Get database items
                Tab tab;
                for(Database db : aldb){
                    tab = db.getDatabaseUiElements();
                    tabBase.getTabs().add(tab);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clickAddDbButton(){
        Dialog<Database> d = new Dialog<>();
        GridPane g = new GridPane();
        List<DbColumn> columns = new ArrayList<>();
        d.setTitle("Ajouter une table");



        ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
    }
}