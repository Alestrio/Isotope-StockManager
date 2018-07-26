/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.controllers;

import com.alestrio.isotope.DB;
import com.alestrio.isotope.materials.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public
class ControllerMP {
	private final DB db = new DB("jdbc:postgresql://localhost:5432/isotope" ,"postgres" ,"postgres");

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

	/*--- ADD BUTTONS ---*/

	@FXML
	void clickAddBtnSpool () {
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
		g.add(l7,1,7);
		g.add(txtPrice, 2,7);

		d.getDialogPane().setContent(g);
		d.getDialogPane().getButtonTypes().add(ok);

		d.setResultConverter(param -> {
			if(ok == param) {
				return new FilamentSpool(Double.parseDouble(txtDiameterF.getText()),
						Double.parseDouble(txtWeightF.getText()),
						Double.parseDouble(txtRemainingWeightF.getText()),
						txtColorF.getText(),
						txtTypeF.getText(),
						Integer.parseInt(txtQty.getText()),
						Double.parseDouble(txtPrice.getText()));
			}
			else
				return null;
		});
		Optional<FilamentSpool> f = d.showAndWait();
		if (f.isPresent()) {
			if(!f.get().isSimilar()){
				f.get().add();
			}
		}
		showDbEntries();
	}

	@FXML
	void clickAddBtnRec () {
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
		g.add(l6, 1,6);
		g.add(txtRemainingLength,2,6);
		g.add(l7, 1,7);
		g.add(txtRemainingWidth,2,7);
		g.add(l8, 1,8);
		g.add(txtRemainingThickness, 2, 8);
		g.add(l9, 1,9);
		g.add(txtPrice, 2,9);
		g.add(l10, 1, 10);
		g.add(txtQty, 2, 10);

		d.getDialogPane().setContent(g);
		d.getDialogPane().getButtonTypes().add(ok);

		d.setResultConverter(param -> {
			if(ok == param) {
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
			}
			else
				return null;
		});
		Optional<RectangularPiece> f = d.showAndWait();
		if (f.isPresent()) {
			if(!f.get().isSimilar()){
				f.get().add();
			}
		}
		showDbEntries();
	}

	@FXML
	void clickAddBtnCylinder () {
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
		g.add(l6, 1,6);
		g.add(txtRemainingLength,2,6);
		g.add(l7, 1, 7);
		g.add(txtQty, 2, 7);

		d.getDialogPane().setContent(g);
		d.getDialogPane().getButtonTypes().add(ok);

		d.setResultConverter(param -> {
			if(ok == param) {
				return new Cylinder(Double.parseDouble(txtDiameter.getText()),
						Double.parseDouble(txtLength.getText()),
						txtType.getText(),
						txtColor.getText(),
						Double.parseDouble(txtPrice.getText()),
						Double.parseDouble(txtRemainingLength.getText()),
						Integer.parseInt(txtQty.getText()));
			}
			else
				return null;
		});
		Optional<Cylinder> f = d.showAndWait();
		if (f.isPresent()) {
			if(!f.get().isSimilar()){
				f.get().add();
			}
		}
		showDbEntries();
	}

	/*--- MODIFY BUTTONS ---*/

		//TODO Boutons de modification

	/*--- ERASE BUTTONS ---*/

		//TODO Boutons de suppression

	/*--- OTHER BUTTONS ---*/

	@FXML
	void clickConnectionBtn() {
		System.out.println(db.getDriverState());
		System.out.println(db.connect());
		showDbEntries();
    }

	/*--- SHOWDBENTRIES... ---*/

	private
	void showDbEntriesRec () throws Exception {
		tableR.getColumns().clear();
		ObservableList<RectangularPiece>                  olr = db.getDbEntriesRecPieces();
		Collection<TableColumn<RectangularPiece, String>> t   = new ArrayList<>();
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
	}

	private
	void showDbEntriesCylinders () throws Exception {
		tableC.getColumns().clear();
		ObservableList<Cylinder>                  olc = db.getDbEntriesCylinders();
		Collection<TableColumn<Cylinder, String>> t   = new ArrayList<>();
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
	}

	private
	void showDbEntriesSpool () throws Exception {
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
	}

	private
	void showDbEntries () {
		try {
			showDbEntriesSpool();
			showDbEntriesRec();
			showDbEntriesCylinders();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}