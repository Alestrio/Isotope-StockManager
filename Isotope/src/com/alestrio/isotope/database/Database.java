/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import com.alestrio.isotope.DB;
import com.alestrio.isotope.materials.AbsMaterial;
import com.alestrio.isotope.materials.DBItem;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Material;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Database {
    protected String name;
    protected List<DbColumn> columns = new ArrayList<>();
    protected DB db = new DB();
    private TableView<AbsMaterial> tableM;
    private Button modifyButton;
    private Button delButton;
    private Button duplButton;
    // TODO: Total Value button
    private Button totalValueButton;
    private PriceCount_type pct;
    private Button addButton;


    public void setPct(PriceCount_type pct) {
        this.pct = pct;
    }

    public Database(){
        columns.add(new DbColumn("price", DB_TYPE.NUMERIC, "price", "Prix"));
        columns.add(new DbColumn("totalPrice", DB_TYPE.NUMERIC, "totalPrice", "Prix total"));
    }

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

    public PriceCount_type getPct() {
        return pct;
    }

    public void addDb(){
        db.connect();
        int dbNumber = columns.size();
        String request = "CREATE TABLE public." + this.name + " \n " +
                "(" +
                "id serial, \n ";
        int i = 1;
        for(DbColumn c : columns){
            if (i < dbNumber) {
                request = request.concat(c.getName() + " " + c.getDbt().getType() + ", \n ");
            } else {
                request = request.concat(c.getName() + " " + c.getDbt().getType() + " \n ");
            }
            i++;

        }
        request = request.concat(") \n " +
                "WITH ( \n " +
                "  OIDS=FALSE \n " +
                "); \n " +
                "ALTER TABLE public." + this.name + " \n " +
                "  OWNER TO postgres;");
        //System.out.println(request);
        try {
            db.dbQuery(request);
        } catch (Exception e) {
            System.out.println("\"" + this.name + "\" already exists");
            //e.printStackTrace();
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
        Tab tab = new Tab();
        SplitPane spane = new SplitPane();
        AnchorPane apTableView = new AnchorPane();
        tableM = new TableView<AbsMaterial>();
        VBox btnVbox = new VBox();


        addButton = new Button();
        addButton.setText("Ajouter");
        modifyButton = new Button();
        modifyButton.setText("Modifier");
        delButton = new Button();
        delButton.setText("Supprimer");
        duplButton = new Button();
        duplButton.setText("Dupliquer");
        totalValueButton = new Button();
        totalValueButton.setText("Valeur totale");

        tab.setText(name);
        tab.setContent(spane);
        spane.getItems().add(apTableView);

        btnVbox.getChildren().add(addButton);
        btnVbox.getChildren().add(modifyButton);
        btnVbox.getChildren().add(delButton);
        btnVbox.getChildren().add(duplButton);
        btnVbox.getChildren().add(totalValueButton);

        btnVbox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnVbox.setPrefHeight(Double.MAX_VALUE);
        btnVbox.setPadding(new Insets(0,0,0,0));

        addButton.setMinWidth(btnVbox.getWidth());
        addButton.setMaxWidth(Double.MAX_VALUE);
        addButton.setPrefHeight(150.0);
        addButton.setMaxHeight(Double.MAX_VALUE);

        modifyButton.setMinWidth(btnVbox.getWidth());
        modifyButton.setMaxWidth(Double.MAX_VALUE);
        modifyButton.setPrefHeight(150.0);
        modifyButton.setMaxHeight(Double.MAX_VALUE);

        duplButton.setMinWidth(btnVbox.getWidth());
        duplButton.setMaxWidth(Double.MAX_VALUE);
        duplButton.setPrefHeight(150.0);
        duplButton.setMaxHeight(Double.MAX_VALUE);

        delButton.setMinWidth(btnVbox.getWidth());
        delButton.setMaxWidth(Double.MAX_VALUE);
        delButton.setPrefHeight(150.0);
        delButton.setMaxHeight(Double.MAX_VALUE);

        totalValueButton.setMinWidth(btnVbox.getWidth());
        totalValueButton.setMaxWidth(Double.MAX_VALUE);
        totalValueButton.setPrefHeight(150.0);
        totalValueButton.setMaxHeight(Double.MAX_VALUE);


        spane.getItems().add(btnVbox);
        apTableView.getChildren().add(tableM);
        apTableView.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        tableM.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        apTableView.setPadding(new Insets(0,0,0,0));
        tableM.setPadding(new Insets(0,0,0,0));
        tableM.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        apTableView.setTopAnchor(tableM,0.0);
        apTableView.setBottomAnchor(tableM, 0.0);
        apTableView.setLeftAnchor(tableM, 0.0);
        apTableView.setRightAnchor(tableM, 0.0);
        spane.setDividerPosition(0, 0.85);
        for(DbColumn tc : columns)
            tableM.getColumns().add(tc.getTableColumn());
        tableM.setItems(db.getExternalDbEntries(this));
        tableM.setVisible(true);
        List<DbColumn> opcol = columns;
        opcol.remove(1);

        addButton.setOnAction(event -> {
         DBItem item = new DBItem(this);
         Dialog dialog = new Dialog();
         dialog.setTitle("Ajouter un/une " + this.name);
         GridPane gpane = new GridPane();
         dialog.getDialogPane().setContent(gpane);
         int x = 1;
         int y = 1;


         for(DbColumn c : opcol){
             gpane.add(new Label(c.getDisplayName()), x, y);
             x++;
             gpane.add(c.getTextField(), x, y);
             y++;
             x=1;
         }
            dialog.getDialogPane().getButtonTypes().add(new ButtonType("Valider", ButtonBar.ButtonData.OK_DONE));
            dialog.showAndWait();

            for(DbColumn c : opcol){
                String name = c.getName();
                switch (name){
                    case "head" : item.setHead(c.getTextField().getText());
                        break;
                    case "diameter" : item.setDiameter(Double.parseDouble(c.getTextField().getText()));
                        break;
                    case "length" : item.setLength(Double.parseDouble(c.getTextField().getText()));
                        break;
                    case "remaininglength" : item.setRemainingLength(Double.parseDouble(c.getTextField().getText()));
                        break;
                    case "width" : item.setWidth(Double.parseDouble(c.getTextField().getText()));
                        break;
                    case "remainingwidth" : item.setRemainingWidth(Double.parseDouble(c.getTextField().getText()));
                        break;
                    case "thickness" : item.setThickness(Double.parseDouble(c.getTextField().getText()));
                        break;
                    case "remainingthickness" : item.setRemainingThickness(Double.parseDouble(c.getTextField().getText()));
                        break;
                    case "type" : item.setType(c.getTextField().getText());
                        break;
                    case "initialweight" : item.setInitialWeight(Double.parseDouble(c.getTextField().getText()));
                        break;
                    case "remainingweight" : item.setRemainingWeight(Double.parseDouble(c.getTextField().getText()));
                        break;
                    case "color" : item.setColor(c.getTextField().getText());
                        break;
                    case "qty" : item.setQty(Integer.parseInt(c.getTextField().getText()));
                        break;
                    case "price" : item.setPrice(Double.parseDouble(c.getTextField().getText()));
                        break;
                    case "pricecm" : item.setPriceCm(Double.parseDouble(c.getTextField().getText()));
                        break;
                    case "pieceprice" : item.setPiecePrice(Double.parseDouble(c.getTextField().getText()));
                        break;
                }

            }
            item.add();
            tableM.setItems(db.getExternalDbEntries(this));
        });

        modifyButton.setOnAction(event -> {
            AbsMaterial item = tableM.getSelectionModel().getSelectedItem();
            Dialog dialog = new Dialog();
            dialog.setTitle("Modifier un/une " + this.name);
            GridPane gpane = new GridPane();
            dialog.getDialogPane().setContent(gpane);
            int x = 1;
            int y = 1;
            for(DbColumn c : opcol) {
                gpane.add(new Label(c.getDisplayName()), x, y);
                x++;
                gpane.add(c.getTextField(), x, y);
                y++;
                x = 1;
                TextField tf = c.getTextField();
                String name = c.getName();
                switch (name) {
                    case "head":
                        tf.setText(item.getHead());
                        break;
                    case "diameter":
                        tf.setText(Double.toString(item.getDiameter()));
                        break;
                    case "length":
                        tf.setText(Double.toString(item.getLength()));
                        break;
                    case "remaininglength":
                        tf.setText(Double.toString(item.getRemainingLength()));
                        break;
                    case "width":
                        tf.setText(Double.toString(item.getWidth()));
                        break;
                    case "remainingwidth":
                        tf.setText(Double.toString(item.getRemainingWidth()));
                        break;
                    case "thickness":
                        tf.setText(Double.toString(item.getThickness()));
                        break;
                    case "remainingthickness":
                        tf.setText(Double.toString(item.getRemainingThickness()));
                        break;
                    case "type":
                        tf.setText(item.getType());
                        break;
                    case "initialweight":
                        tf.setText(Double.toString(item.getInitialWeight()));
                        break;
                    case "remainingweight":
                        tf.setText(Double.toString(item.getRemainingWeight()));
                        break;
                    case "color":
                        tf.setText(item.getColor());
                        break;
                    case "qty":
                        tf.setText(Integer.toString(item.getQty()));
                        break;
                    case "price":
                        tf.setText(Double.toString(item.getPrice()));
                        break;
                    case "pricecm":
                        tf.setText(Double.toString(item.getPriceCm()));
                        break;
                    case "pieceprice":
                        tf.setText(Double.toString(item.getPiecePrice()));
                        break;
                }
            }

            dialog.getDialogPane().getButtonTypes().add(new ButtonType("Valider", ButtonBar.ButtonData.OK_DONE));
            dialog.showAndWait();

            for(DbColumn col : opcol) {
                String colname = col.getName();
                switch (colname) {
                    case "head":
                        item.setHead(col.getTextField().getText());
                        break;
                    case "diameter":
                        item.setDiameter(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "length":
                        item.setLength(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "remaininglength":
                        item.setRemainingLength(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "width":
                        item.setWidth(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "remainingwidth":
                        item.setRemainingWidth(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "thickness":
                        item.setThickness(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "remainingthickness":
                        item.setRemainingThickness(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "type":
                        item.setType(col.getTextField().getText());
                        break;
                    case "initialweight":
                        item.setInitialWeight(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "remainingweight":
                        item.setRemainingWeight(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "color":
                        item.setColor(col.getTextField().getText());
                        break;
                    case "qty":
                        item.setQty(Integer.parseInt(col.getTextField().getText()));
                        break;
                    case "price":
                        item.setPrice(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "pricecm":
                        item.setPriceCm(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "pieceprice":
                        item.setPiecePrice(Double.parseDouble(col.getTextField().getText()));
                        break;
                }
            }
                item.delete();
                item.add();
                tableM.setItems(db.getExternalDbEntries(this));
        });

        delButton.setOnAction(event -> {
            tableM.getSelectionModel().getSelectedItem().delete();
            tableM.setItems(db.getExternalDbEntries(this));
        });

        duplButton.setOnAction(event -> {
            AbsMaterial item = tableM.getSelectionModel().getSelectedItem();
            Dialog dialog = new Dialog();
            dialog.setTitle("Modifier un/une " + this.name);
            GridPane gpane = new GridPane();
            dialog.getDialogPane().setContent(gpane);
            int x = 1;
            int y = 1;
            for(DbColumn c : opcol) {
                gpane.add(new Label(c.getDisplayName()), x, y);
                x++;
                gpane.add(c.getTextField(), x, y);
                y++;
                x = 1;
                TextField tf = c.getTextField();
                String name = c.getName();
                switch (name) {
                    case "head":
                        tf.setText(item.getHead());
                        break;
                    case "diameter":
                        tf.setText(Double.toString(item.getDiameter()));
                        break;
                    case "length":
                        tf.setText(Double.toString(item.getLength()));
                        break;
                    case "remaininglength":
                        tf.setText(Double.toString(item.getRemainingLength()));
                        break;
                    case "width":
                        tf.setText(Double.toString(item.getWidth()));
                        break;
                    case "remainingwidth":
                        tf.setText(Double.toString(item.getRemainingWidth()));
                        break;
                    case "thickness":
                        tf.setText(Double.toString(item.getThickness()));
                        break;
                    case "remainingthickness":
                        tf.setText(Double.toString(item.getRemainingThickness()));
                        break;
                    case "type":
                        tf.setText(item.getType());
                        break;
                    case "initialweight":
                        tf.setText(Double.toString(item.getInitialWeight()));
                        break;
                    case "remainingweight":
                        tf.setText(Double.toString(item.getRemainingWeight()));
                        break;
                    case "color":
                        tf.setText(item.getColor());
                        break;
                    case "qty":
                        tf.setText(Integer.toString(item.getQty()));
                        break;
                    case "price":
                        tf.setText(Double.toString(item.getPrice()));
                        break;
                    case "pricecm":
                        tf.setText(Double.toString(item.getPriceCm()));
                        break;
                    case "pieceprice":
                        tf.setText(Double.toString(item.getPiecePrice()));
                        break;
                }
            }

            dialog.getDialogPane().getButtonTypes().add(new ButtonType("Valider", ButtonBar.ButtonData.OK_DONE));
            dialog.showAndWait();

            for(DbColumn col : opcol) {
                String colname = col.getName();
                switch (colname) {
                    case "head":
                        item.setHead(col.getTextField().getText());
                        break;
                    case "diameter":
                        item.setDiameter(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "length":
                        item.setLength(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "remaininglength":
                        item.setRemainingLength(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "width":
                        item.setWidth(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "remainingwidth":
                        item.setRemainingWidth(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "thickness":
                        item.setThickness(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "remainingthickness":
                        item.setRemainingThickness(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "type":
                        item.setType(col.getTextField().getText());
                        break;
                    case "initialweight":
                        item.setInitialWeight(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "remainingweight":
                        item.setRemainingWeight(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "color":
                        item.setColor(col.getTextField().getText());
                        break;
                    case "qty":
                        item.setQty(Integer.parseInt(col.getTextField().getText()));
                        break;
                    case "price":
                        item.setPrice(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "pricecm":
                        item.setPriceCm(Double.parseDouble(col.getTextField().getText()));
                        break;
                    case "pieceprice":
                        item.setPiecePrice(Double.parseDouble(col.getTextField().getText()));
                        break;
                }
            }
            item.add();
            tableM.setItems(db.getExternalDbEntries(this));
        });

        totalValueButton.setOnAction(event -> {
            List<AbsMaterial> entries = db.getExternalDbEntries(this);
            double totalValue=0;
            for(AbsMaterial mat : entries)
                totalValue += mat.getTotalPrice();

            Dialog dialog = new Dialog();
            dialog.setTitle("Valeur totale");
            dialog.setContentText("Valeur total de/d' " + this.name + " : " + totalValue + " €");
            dialog.getDialogPane().getButtonTypes().add(new ButtonType("Valider", ButtonBar.ButtonData.OK_DONE));
            dialog.showAndWait();
            });


        return tab;
    }

}
