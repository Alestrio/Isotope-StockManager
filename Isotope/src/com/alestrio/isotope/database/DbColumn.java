/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import com.alestrio.isotope.materials.AbsMaterial;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class DbColumn {

    private String name;
    private String displayName;
    private DB_TYPE dbt;
    private transient TableColumn tc = new TableColumn();
    protected transient TextField tf = new TextField();
    protected String property;

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

    public String getDisplayName() {
        return displayName;
    }

    public String getProperty() {
        return property;
    }

    public DbColumn(String name, DB_TYPE dbt, String property, String dispname){
        this.name = name;
        this.dbt = dbt;
        this.property = property;
        tc.setCellValueFactory(new PropertyValueFactory<AbsMaterial, String>(property));
        this.displayName = dispname;
        tc.setText(this.displayName);

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
