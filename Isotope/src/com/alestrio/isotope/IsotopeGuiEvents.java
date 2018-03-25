package com.alestrio.isotope;

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
	private TextArea txtArea;
	@FXML
	private Button addBtn;
	DB db = new DB("jdbc:postgresql://localhost:5432/isotope","postgres","postgres");
	@FXML
    private TableView<Screw> table = new TableView<>();
    @FXML
    private TableColumn<Screw, String> headColumn;
    @FXML
    private TableColumn<Screw, String> diamColumn;
    @FXML
    private TableColumn<Screw, String> lengthColumn;
    @FXML
    private TableColumn<Screw, String> typeColumn;
    @FXML
    private TableColumn<Screw, String> colorColumn;
    @FXML
    private TableColumn<Screw, String> qtyColumn;

	@FXML
	void clickAddBtn() {
		Screw v = new Screw(Integer.parseInt(txtDiameter.getText()),
				Integer.parseInt(txtLength.getText()),
				txtHead.getText(),
				txtType.getText(),
                txtColor.getText() ,
                Integer.parseInt(txtQty.getText()));
					txtArea.appendText("Reussi !");
	}
	
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

	private void showDbEntriesScrews() throws Exception {
        table.getColumns().clear();
		ObservableList<Screw> ols = db.getDbEntriesScrew();
        table.setItems(ols);
        headColumn.setCellValueFactory(new PropertyValueFactory<>("head"));
        diamColumn.setCellValueFactory(new PropertyValueFactory<>("diameter"));
        lengthColumn.setCellValueFactory(new PropertyValueFactory<>("length"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        qtyColumn.setCellValueFactory(new PropertyValueFactory<>("qty"));
        table.getColumns().addAll(headColumn ,diamColumn ,lengthColumn ,typeColumn ,colorColumn ,qtyColumn);
        table.setVisible(true);

    }
}
