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
    private Tab tab;
    private SplitPane spane;
    private AnchorPane apTableView;
    private TableView<Material> tableM;
    private Button addButton;
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

    public void add(){
        String request = "CREATE TABLE public." + this.name +"\n"+
                "{" +
                "id integer NOT NULL DEFAULT nextval('" + this.name +"_id_seq'::regclass), \n";
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

    public Tab getDatabaseUiElements(){
        tab = new Tab();
        spane = new SplitPane();
        apTableView = new AnchorPane();
        tableM = new TableView<>();

        addButton = new Button();
        modifyButton = new Button();
        delButton = new Button();
        duplButton = new Button();
        totalValueButton = new Button();

        addButton.setOnAction(event -> {
         Dialog dialog = new Dialog();
         dialog.setTitle("Ajouter un/une " + this.name);
         GridPane gpane = new GridPane();
         dialog.getDialogPane().setContent(gpane);

         int x = 0;
         int y = 0;
         for(DbColumn c : columns){
             gpane.add(new Label(c.getName()), x, y);
             x++;
             //TODO Add button Database
         }

        });

        tab.setText(name);
        tab.setContent(spane);
        spane.getItems().add(apTableView);
        //TODO Switch this to controller
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
