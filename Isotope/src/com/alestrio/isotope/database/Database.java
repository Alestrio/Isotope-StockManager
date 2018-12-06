/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import com.alestrio.isotope.DB;
import com.alestrio.isotope.materials.DBItem;
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
    protected String name;
    protected List<DbColumn> columns = new ArrayList<>();
    protected DB db = new DB();
    private TableView<Material> tableM;
    private Button modifyButton;
    private Button delButton;
    private Button duplButton;
    // TODO: Total Value button
    private Button totalValueButton;
    private PriceCount_type pct;


    public void setPct(PriceCount_type pct) {
        this.pct = pct;
    }

    public Database(){
        columns.add(new DbColumn("Prix", DB_TYPE.NUMERIC, "prix"));
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
        tableM = new TableView<>();

        Button addButton = new Button();
        modifyButton = new Button();
        delButton = new Button();
        duplButton = new Button();
        totalValueButton = new Button();

        addButton.setOnAction(event -> {
         DBItem item = new DBItem(this);
         Dialog dialog = new Dialog();
         dialog.setTitle("Ajouter un/une " + this.name);
         GridPane gpane = new GridPane();
         dialog.getDialogPane().setContent(gpane);
         int x = 1;
         int y = 1;
         for(DbColumn c : columns){
             gpane.add(new Label(c.getName()), x, y);
             x++;
             gpane.add(c.getTextField(), x, y);
             y++;
             x=1;
         }
            dialog.getDialogPane().getButtonTypes().add(new ButtonType("Valider", ButtonBar.ButtonData.OK_DONE));
            dialog.showAndWait();

            for(DbColumn c : columns){
                String name = c.getName();
                switch (name){
                    case "head" : item.setHead(c.getTextField().getText());
                    case "diameter" : item.setDiameter(Double.parseDouble(c.getTextField().getText()));
                    case "length" : item.setLength(Double.parseDouble(c.getTextField().getText()));
                    case "remaininglength" : item.setRemainingLength(Double.parseDouble(c.getTextField().getText()));
                    case "width" : item.setWidth(Double.parseDouble(c.getTextField().getText()));
                    case "remainingwidth" : item.setRemainingWidth(Double.parseDouble(c.getTextField().getText()));
                    case "thickness" : item.setThickness(Double.parseDouble(c.getTextField().getText()));
                    case "remainingthickness" : item.setRemainingThickness(Double.parseDouble(c.getTextField().getText()));
                    case "type" : item.setType(c.getTextField().getText());
                    case "initialweight" : item.setInitialWeight(Double.parseDouble(c.getTextField().getText()));
                    case "remainingweight" : item.setRemainingWeight(Double.parseDouble(c.getTextField().getText()));
                    case "color" : item.setColor(c.getTextField().getText());
                    case "qty" : item.setQty(Integer.parseInt(c.getTextField().getText()));
                    case "price" : item.setPrice(Double.parseDouble(c.getTextField().getText()));
                    case "pricecm" : item.setPriceCm(Double.parseDouble(c.getTextField().getText()));
                    case "pieceprice" : item.setPiecePrice(Double.parseDouble(c.getTextField().getText()));
                }

            }
         item.add();
        });
        //TODO  Modify button
        modifyButton.setOnAction(event -> {

            Dialog dialog = new Dialog();
            dialog.setTitle("Modifier un/une " + this.name);
            GridPane gpane = new GridPane();
            dialog.getDialogPane().setContent(gpane);
            int x = 1;
            int y = 1;
            for(DbColumn c : columns){
                gpane.add(new Label(c.getName()), x, y);
                x++;
                //TODO gpane.add(c.tf, x, y);
                y++;
                x=1;
            }
            for(DbColumn c : columns){
                //TODO c.setValue(c.tf.getText());
            }
            dialog.getDialogPane().getButtonTypes().add(new ButtonType("Valider", ButtonBar.ButtonData.OK_DONE));
            dialog.showAndWait();
        });
        // TODO: Delete Button
        delButton.setOnAction(event -> {

        });
        // TODO: Duplicate button
        duplButton.setOnAction(event -> {

        });

        tab.setText(name);
        tab.setContent(spane);
        spane.getItems().add(apTableView);
        AnchorPane apButtons = new AnchorPane();
        apButtons.getChildren().add(addButton);
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
