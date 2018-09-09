/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Material;


public class DbColumn {
    private String name;
    private DB_TYPE dbt;
    private TableColumn tc = new TableColumn();
    private String property;

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
    }

    public TableColumn getTableColumn() {
        tc.setCellValueFactory(new PropertyValueFactory<Material, String>(property));
       return tc;
    }
}
