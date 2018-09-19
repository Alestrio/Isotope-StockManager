/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import com.alestrio.isotope.DB;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Material;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Database {
    private String name;
    private List<DbColumn> columns = new ArrayList<>();
    private DB db = new DB();
    private TableView<Material> tableM;
    private Button modifyButton;
    private Button delButton;
    private Button duplButton;
    private Button totalValueButton;


    public Database(){   }

    public void setColumns(ArrayList<DbColumn> s){
        this.columns = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DbColumn> getColumns() {
        return columns;
    }

    public void addColumn(DbColumn s){
        columns.add(s);

    }

    public void addDb(){
        String request = "CREATE TABLE public." + this.name +"\n"+
                "{" +
                "id serial, \n";
        for(DbColumn c : columns){
            request = request.concat(c.getName() + " " + c.getDbt().getType() + "\n");
        }
        request = request.concat("} \n" +
                "WITH (\n" +
                "  OIDS=FALSE\n" +
                ");\n" +
                "ALTER TABLE public.bobines\n" +
                "  OWNER TO postgres;");
        try {
            db.dbQuery(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Collection<TableColumn> createColumnsFx(){
        List<TableColumn> tcl = new ArrayList<>();
        for(DbColumn c : columns){
            tcl.add(c.getTableColumn());
            tableM.getColumns().add(c.getTableColumn());
        }
        return tcl;
    }

    private void add(){
        String addQuery = "INSERT INTO public." + this.name + " (";
        int i = 0;
        for(DbColumn c : columns){
            addQuery.concat(c.getName());
            i++;
            if(columns.get(i) != null){
                addQuery.concat(", ");
            }
        }
        i=0;
        addQuery.concat(") VALUES (");
        for(DbColumn c : columns){
            addQuery.concat(c.getValue());
            i++;
            if(columns.get(i) != null){
                addQuery.concat(", ");
            }
        }
        addQuery.concat(")");
        try {
            db.dbQuery(addQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Tab getDatabaseUiElements(){
        Tab tab = new Tab();
        SplitPane spane = new SplitPane();
        AnchorPane apTableView = new AnchorPane();
        tableM = new TableView<>();

        Button addButton = new Button();
        modifyButton = new Button();
        delButton = new Button();
        duplButton = new Button();
        totalValueButton = new Button();

        addButton.setOnAction(event -> {
         Dialog dialog = new Dialog();
         dialog.setTitle("Ajouter un/une " + this.name);
         GridPane gpane = new GridPane();
         dialog.getDialogPane().setContent(gpane);
         int x = 1;
         int y = 1;
         for(DbColumn c : columns){
             gpane.add(new Label(c.getName()), x, y);
             x++;
             gpane.add(c.tf, x, y);
             y++;
             x=1;
         }
         for(DbColumn c : columns){
             c.setValue(c.tf.getText());
         }
         add();
        });

        tab.setText(name);
        tab.setContent(spane);
        spane.getItems().add(apTableView);
        AnchorPane apButtons = new AnchorPane();
        spane.getItems().add(apButtons);
        apTableView.getChildren().add(tableM);
        spane.setDividerPosition(0, 0.85);
        apTableView.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        for(DbColumn tc : columns)
            tableM.getColumns().add(tc.getTableColumn());
        tableM.setVisible(true);
        return tab;
    }
}
