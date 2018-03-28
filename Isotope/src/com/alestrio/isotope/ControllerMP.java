package com.alestrio.isotope;

import com.alestrio.isotope.materials.Cylinder;
import com.alestrio.isotope.materials.FilamentSpool;
import com.alestrio.isotope.materials.RectangularPiece;
import com.alestrio.isotope.materials.Screw;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public
class ControllerMP {
	DB db = new DB("jdbc:postgresql://localhost:5432/isotope","postgres","postgres");

	/*--- SCREW ---*/
	@FXML
	private TableView<Screw> tableS = new TableView<>();
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
	private Button    addBtnR;

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
	void clickAddBtnScrew () {
		Screw v = new Screw(Double.parseDouble(txtDiameterS.getText()) ,
				Double.parseDouble(txtLengthS.getText()) ,
				txtHeadS.getText() ,
				txtTypeS.getText() ,
				txtColorS.getText() ,
				Integer.parseInt(txtQtyS.getText()));
		if (db.addScrew(v))
			txtAreaS.appendText("Reussi !");
		showDbEntries();
	}

	@FXML
	void clickAddBtnSpool () {
		FilamentSpool v = new FilamentSpool(Double.parseDouble(txtDiameterF.getText()) ,
				Double.parseDouble(txtWeightF.getText()) ,
				Double.parseDouble(txtWeightF.getText()) ,
				txtTypeF.getText() ,
				txtColorF.getText());
		if (db.addSpool(v))
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
				Double.parseDouble(txtThicknessR.getText()));
		if (db.addRectangularPiece(v))
			txtAreaR.appendText("Reussi !");
		showDbEntries();
	}

	@FXML
	void clickAddBtnCylinder () {
		showDbEntries();
	}

	/*--- MODIFY BUTTONS ---*/



	/*--- ERASE BUTTONS ---*/



	/*--- OTHER BUTTONS ---*/

	@FXML
	void clickConnectionBtn() {
		System.out.println(db.getDriverState());
		System.out.println(db.connect());
		showDbEntries();
    }

	/*--- SHOWDBENTRIES... ---*/

	private void showDbEntriesScrews() throws Exception {
		tableS.getColumns().clear();
		ObservableList<Screw> ols = db.getDbEntriesScrew();
		tableS.setItems(ols);
		headColumnS.setCellValueFactory(new PropertyValueFactory<>("head"));
		diamColumnS.setCellValueFactory(new PropertyValueFactory<>("diameter"));
		lengthColumnS.setCellValueFactory(new PropertyValueFactory<>("length"));
		typeColumnS.setCellValueFactory(new PropertyValueFactory<>("type"));
		colorColumnS.setCellValueFactory(new PropertyValueFactory<>("color"));
		qtyColumnS.setCellValueFactory(new PropertyValueFactory<>("qty"));
		tableS.getColumns().addAll(headColumnS ,diamColumnS ,lengthColumnS ,typeColumnS ,colorColumnS ,qtyColumnS);
		tableS.setVisible(true);

	}

	private
	void showDbEntriesRec () throws Exception {
		tableR.getColumns().clear();
		ObservableList<RectangularPiece> olr = db.getDbEntriesRecPieces();
		tableR.setItems(olr);
		typeColumnR.setCellValueFactory(new PropertyValueFactory<>("type"));
		lengthColumnR.setCellValueFactory(new PropertyValueFactory<>("length"));
		remainingLengthColumnR.setCellValueFactory(new PropertyValueFactory<>("remainingLength"));
		widthColumnR.setCellValueFactory(new PropertyValueFactory<>("width"));
		remainingWidthColumnR.setCellValueFactory(new PropertyValueFactory<>("remainingWidth"));
		thicknessColumnR.setCellValueFactory(new PropertyValueFactory<>("thickness"));
		remainingThicknessColumnR.setCellValueFactory(new PropertyValueFactory<>("remainingThickness"));
		colorColumnR.setCellValueFactory(new PropertyValueFactory<>("color"));
		qtyColumnR.setCellValueFactory(new PropertyValueFactory<>("qty"));
		tableR.getColumns().addAll(typeColumnR ,lengthColumnR ,remainingLengthColumnR ,widthColumnR ,remainingWidthColumnR ,thicknessColumnR ,remainingThicknessColumnR ,colorColumnR ,qtyColumnR);
		tableR.setVisible(true);
	}

	private
	void showDbEntriesCylinders () throws Exception {
		tableC.getColumns().clear();
		ObservableList<Cylinder> olc = db.getDbEntriesCylinders();
		tableC.setItems(olc);
		diameterColumnC.setCellValueFactory(new PropertyValueFactory<>("diameter"));
		lengthColumnC.setCellValueFactory(new PropertyValueFactory<>("length"));
		remainingLengthColumnC.setCellValueFactory(new PropertyValueFactory<>("remainingLength"));
		typeColumnC.setCellValueFactory(new PropertyValueFactory<>("type"));
		colorColumnC.setCellValueFactory(new PropertyValueFactory<>("color"));
		qtyColumnC.setCellValueFactory(new PropertyValueFactory<>("qty"));
		tableC.getColumns().addAll(diameterColumnC ,lengthColumnC ,remainingLengthColumnC ,typeColumnC ,colorColumnC ,qtyColumnC);
		tableC.setVisible(true);
	}

	private
	void showDbEntriesSpool () throws Exception {
		tableF.getColumns().clear();
		ObservableList<FilamentSpool> olf = db.getDbEntriesSpool();
		tableF.setItems(olf);
		typeColumnF.setCellValueFactory(new PropertyValueFactory<>("type"));
		colorColumnF.setCellValueFactory(new PropertyValueFactory<>("color"));
		diameterColumnF.setCellValueFactory(new PropertyValueFactory<>("diameter"));
		weightColumnF.setCellValueFactory(new PropertyValueFactory<>("initialWeight"));
		remainingWeightColumnF.setCellValueFactory(new PropertyValueFactory<>("remainingWeight"));
		tableF.getColumns().addAll(typeColumnF ,colorColumnF ,diameterColumnF ,weightColumnF ,remainingWeightColumnF);
		tableF.setVisible(true);
	}

	private
	void showDbEntries () {
		try {
			showDbEntriesSpool();
			showDbEntriesRec();
			showDbEntriesCylinders();
			showDbEntriesScrews();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
