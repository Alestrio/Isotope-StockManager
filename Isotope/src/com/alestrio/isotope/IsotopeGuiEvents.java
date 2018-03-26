package com.alestrio.isotope;

import com.alestrio.isotope.materials.RectangularPiece;
import com.alestrio.isotope.materials.Screw;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class IsotopeGuiEvents {
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
	private Button    addBtnScrew;
	DB db = new DB("jdbc:postgresql://localhost:5432/isotope","postgres","postgres");

	/*--- TABLE VIEW SCREW ---*/
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

	/*--- TABLEVIEW PLAQUES ---*/
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

	/*--- TABLEVIEW SPOOLS ---*/


	/*--- TABLEVIEW CYLINDERS ---*/

	/*-------------------------------------------------------------------*/

	/*--- ADD BUTTONS ---*/

	@FXML
	void clickAddBtnScrew () {
		Screw v = new Screw(Integer.parseInt(txtDiameter.getText()),
				Integer.parseInt(txtLength.getText()),
				txtHead.getText(),
				txtType.getText(),
                txtColor.getText() ,
                Integer.parseInt(txtQty.getText()));
					txtArea.appendText("Reussi !");
	}

	void clickAddBtnSpool () {

	}

	void clickAddBtnRec () {

	}

	void clickAddBtnCylinder () {

	}

	/*--- MODIFY BUTTONS ---*/



	/*--- ERASE BUTTONS ---*/



	/*--- OTHER BUTTONS ---*/

	@FXML
	void clickConnectionBtn() {
		System.out.println(db.getDriverState());
		System.out.println(db.connect());
        try {
            showDbEntriesScrews();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
	void showDbEntriesRec () {

	}

	private
	void showDbEntriesCylinders () {

	}

	private
	void showDbEntriesSpool () {

	}
}
