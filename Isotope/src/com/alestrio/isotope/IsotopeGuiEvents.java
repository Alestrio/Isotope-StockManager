package com.alestrio.isotope;

import com.alestrio.isotope.materials.Screw;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
	DB db = new DB("jdbc:postgresql://localhost:5432/","postgres","postgres");
	
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
}
