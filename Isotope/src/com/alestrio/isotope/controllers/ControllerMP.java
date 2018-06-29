/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.controllers;

import com.alestrio.isotope.DB;
import com.alestrio.isotope.materials.Cylinder;
import com.alestrio.isotope.materials.FilamentSpool;
import com.alestrio.isotope.materials.RectangularPiece;
import com.alestrio.isotope.materials.Screw;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Collection;

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

	@FXML
	private TextField txtTypeR;
	@FXML
	private TextField txtLengthR;
	@FXML
	private TextField txtWidthR;
	@FXML
	private TextField txtThicknessR;
	@FXML
	private TextField txtColorR;
	@FXML
	private TextArea  txtAreaR;
	@FXML
	private TextField txtPriceR;
	@FXML
	private TextField newTxtLengthR;
	@FXML
	private TextField  newTxtWidthR;
	@FXML
	private TextField newTxtThicknessR;

	@FXML
	private Button    addBtnR;
	@FXML
	private Button duplicateBtnR;
	@FXML
	private Button saveBtnR;
	@FXML
	private Button delBtnR;

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
	private TableColumn<Cylinder, String> qtyColumnC;

	@FXML
	private TextField txtDiameterC;
	@FXML
	private TextField txtLengthC;
	@FXML
	private TextField txtRemainingLengthC;
	@FXML
	private TextField txtTypeC;
	@FXML
	private TextField txtColorC;
	@FXML
	private TextField txtQtyC;
	@FXML
	private TextArea  txtAreaC;
	@FXML
	private Button    addBtnC;

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
	private TextField txtTypeF;
	@FXML
	private TextField txtColorF;
	@FXML
	private TextField txtDiameterF;
	@FXML
	private TextField txtWeightF;
	@FXML
	private TextField txtRemainingWeightF;
	@FXML
	private TextArea  txtAreaF;
	@FXML
	private Button    addBtnF;

	/*-------------------------------------------------------------------*/

	/*--- ADD BUTTONS ---*/

	@FXML
	void clickAddBtnSpool () {
		FilamentSpool v = new FilamentSpool(Double.parseDouble(txtDiameterF.getText()) ,
				Double.parseDouble(txtWeightF.getText()) ,
				Double.parseDouble(txtWeightF.getText()) ,
				txtTypeF.getText() ,
				txtColorF.getText());
		if (v.add())
			txtAreaF.appendText("Reussi !");
		showDbEntries();
	}

	@FXML
	void clickAddBtnRec () {
		RectangularPiece v = new RectangularPiece(Double.parseDouble(txtLengthR.getText()) ,
				Double.parseDouble(txtWidthR.getText()) ,
				Double.parseDouble(txtThicknessR.getText()) ,
				txtTypeR.getText() ,
				txtColorR.getText() ,
				Double.parseDouble(txtLengthR.getText()) ,
				Double.parseDouble(txtWidthR.getText()) ,
				Double.parseDouble(txtThicknessR.getText()),
				Double.parseDouble(txtPriceR.getText()));
		if (v.add())
			txtAreaR.appendText("Reussi !");
		showDbEntries();
	}

	@FXML
	void clickAddBtnCylinder () {
		Cylinder c = new Cylinder(
				Double.parseDouble(diameterColumnC.getText()),
				Double.parseDouble(lengthColumnC.getText()),
				typeColumnC.getText(),
				colorColumnC.getText(),
				Integer.parseInt(qtyColumnC.getText()),
				Double.parseDouble(remainingLengthColumnC.getText())
		);
		if (c.add())
			txtAreaC.appendText("Reussi !");
		showDbEntries();
		showDbEntries();
	}

	/*--- MODIFY BUTTONS ---*/
	@FXML
	void onDuplicateButtonClickR(){
		RectangularPiece v = tableR.getSelectionModel().getSelectedItem();
		v.add();
	}

	@FXML
	void onSaveButtonClick(){

	}


	/*--- ERASE BUTTONS ---*/



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
		priceCmColumnR.setCellValueFactory(new PropertyValueFactory<>("price"));
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