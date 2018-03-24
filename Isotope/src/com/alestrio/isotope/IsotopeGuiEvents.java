package com.alestrio.isotope;

import com.alestrio.isotope.materials.Screw;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
	private TableView<Screw> table;
	@FXML
	private TableColumn<Screw, String> head;
	@FXML
	private TableColumn<Screw, String> diameter;
	@FXML
	private TableColumn<Screw, String> length;
	@FXML
	private TableColumn<Screw, String> type;
	@FXML
	private TableColumn<Screw, String> color;
	@FXML
	private TableColumn<Screw, String> qty;
	
	@FXML
	void clickAddBtn() {
		Screw v = new Screw(Integer.parseInt(txtDiameter.getText()),
				Integer.parseInt(txtLength.getText()),
				txtHead.getText(),
				txtType.getText(),
				txtColor.getText());
				if(db.addScrew(v, Integer.parseInt(txtQty.getText())))
					txtArea.appendText("Réussi !");
	}
	
	@FXML
	void clickConnectionBtn() {
		System.out.println(db.getDriverState());
		System.out.println(db.connect());
	}
	
	void showDbEntriesScrews() throws Exception {
		int i = 0;
		Screw[] s = db.getDbEntriesScrew();

		final ObservableList<Screw> data = FXCollections.observableArrayList();
			    while(i < s.length) {
			    	data.add(new Screw (s[i].getDiameter(), s[i].getLength(), s[i].getHead(), s[i].getType(), s[i].getColor()));
			    	i++;
			    }
			    table.setItems(data);
			    
			    
			    
		
	}
}
