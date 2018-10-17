/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Material;


public class DbColumn {
    public String getValue() {
        return value;
    }

    private String name;
    private DB_TYPE dbt;
    private TableColumn tc = new TableColumn();
    private String property;
    private String value;
    public TextField tf;

    public void setValue(String value) {
        this.value = value;
    }
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

    DbColumn(String name, DB_TYPE dbt, String p){
        this.name = name;
        this.dbt = dbt;
        this.property = p;
        tc.setCellValueFactory(new PropertyValueFactory<Material, String>(property));
        tc.setText(this.name);
        tf = new TextField(null);
    }

    public TableColumn getTableColumn() {
       return tc;
    }
}
