/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Material;


public class DbColumn {

    private String name;
    private DB_TYPE dbt;
    private TableColumn tc = new TableColumn();
    private TextField tf = new TextField();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DB_TYPE getDbt() {
        return dbt;
    }

    public void setDbt(DB_TYPE dbt) {
        this.dbt = dbt;
    }

    DbColumn(String name, DB_TYPE dbt, String property){
        this.name = name;
        this.dbt = dbt;
        tc.setCellValueFactory(new PropertyValueFactory<Material, String>("property"));
        tc.setText(this.name);
    }

    public TableColumn getTableColumn() {
       return tc;
    }

    public TextField getTextField() {
        return tf;
    }

    public void setTextTextField(String text){
        tf.setText(text);
    }
}
