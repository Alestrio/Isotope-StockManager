/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope;

import com.alestrio.isotope.database.Database;
import com.alestrio.isotope.database.DbColumn;
import com.alestrio.isotope.materials.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Material;

import javax.print.attribute.standard.JobStateReason;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DB {

    private final String url;
    private final String user;
    private final String pswd;
    private Connection conn;
    private Settings s = new Settings();

    public DB() {
        url = s.getDbUrl();
        user = s.getDbUser();
        pswd = s.getDbPswd();
    }


    public
    boolean connect () {
        try {
            conn = DriverManager.getConnection(url, user, pswd);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public
    boolean disconnect () {
        try {
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    protected boolean getDriverState() {
        try {
            Class.forName("org.postgresql.Driver");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }


    public
    void dbQuery (String query) throws SQLException {
            Statement state = conn.createStatement();
            state.executeUpdate(query);
    }

    public ObservableList<FilamentSpool> getDbEntriesSpool() {
        List<FilamentSpool> list = new ArrayList<>();
        ObservableList<FilamentSpool> olf = FXCollections.observableList(list);
        Statement state;
        try {
            state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM \"bobines\"");

            while (result.next()) {
                double a = result.getDouble("diameter");
                double b = result.getDouble("initialweight");
                double c = result.getDouble("remainingweight");
                String d = result.getString("type");
                String e = result.getString("color");
                int f = result.getInt("qty");
                double g = result.getDouble("price");
                int h = result.getInt("id");
                olf.add(new FilamentSpool(a, b, c, d, e, f, g, h));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            olf = null;
        }
        return olf;
    }

    public ObservableList<Cylinder> getDbEntriesCylinders() {
        List<Cylinder> list = new ArrayList<>();
        ObservableList<Cylinder> olc = FXCollections.observableList(list);
        Statement state = null;
        try {
            state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM \"cylindres\"");

            while (result.next()) {
                double a = result.getDouble("diameter");
                double b = result.getDouble("length");
                String c = result.getString("type");
                String d = result.getString("color");
                int e = result.getInt("price");
                double f = result.getDouble("remainingLength");
                int g = result.getInt("qty");
                int h = result.getInt("id");
                olc.add(new Cylinder(a, b, c, d, e, f, g, h));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            olc = null;
        }
        return olc;
    }

    public ObservableList<Screw> getDbEntriesScrew() {

        List<Screw> list = new ArrayList<>();
        ObservableList<Screw> ols = FXCollections.observableList(list);

        Statement state;
        try {
            state = conn.createStatement();

            ResultSet result = state.executeQuery("SELECT * FROM \"visserie\"");
            while (result.next()) {
                double a = result.getDouble("diameter");
                double b = result.getDouble("length");
                String c = result.getString("head");
                String d = result.getString("type");
                String e = result.getString("color");
                int f = result.getInt("qty");
                double g = result.getDouble("price");
                int h = result.getInt("id");
                ols.add(new Screw(a, b, c, d, e, f, g, h));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            ols = null;
        }
        return ols;
    }

    public ObservableList<RectangularPiece> getDbEntriesRecPieces() {
        List<RectangularPiece> list = new ArrayList<>();
        ObservableList<RectangularPiece> olr = FXCollections.observableList(list);
        Statement state;
        try {
            state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM \"rectangles\"");

            while (result.next()) {
                double a = result.getDouble("length");
                double b = result.getDouble("width");
                double c = result.getDouble("thickness");
                String d = result.getString("type");
                String e = result.getString("color");
                double g = result.getDouble("remainingLength");
                double h = result.getDouble("remainingWidth");
                double i = result.getDouble("remainingThickness");
                double j = result.getDouble("price");
                int k = result.getInt("qty");
                int l = result.getInt("id");
                olr.add(new RectangularPiece(a, b, c, d, e, g, h, i, j, k, l));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            olr = null;
        }
        return olr;
    }

    public void createDatabase(){
        try{
            //Si ça n'existe pas
            this.dbQuery("CREATE TABLE public.bobines\n" +
                    "(\n" +
                    "  id serial,\n" +
                    "  type text,\n" +
                    "  diameter numeric,\n" +
                    "  initialweight numeric,\n" +
                    "  remainingweight numeric,\n" +
                    "  color text,\n" +
                    "  qty integer,\n" +
                    "  price numeric,\n" +
                    "  pricecm numeric\n" +
                    ")\n" +
                    "WITH (\n" +
                    "  OIDS=FALSE\n" +
                    ");");
        }
        catch(SQLException e){
            //Si ça existe
            System.out.println("\"bobines\" table already exists");
        }

        try{
            this.dbQuery("CREATE TABLE public.cylindres\n" +
                    "(\n" +
                    "  id serial,\n" +
                    "  diameter numeric,\n" +
                    "  length numeric,\n" +
                    "  color text,\n" +
                    "  type text,\n" +
                    "  remaininglength numeric,\n" +
                    "  price numeric,\n" +
                    "  pricecm numeric,\n" +
                    "  qty integer\n" +
                    ")\n" +
                    "WITH (\n" +
                    "  OIDS=FALSE\n" +
                    ");");
        }
        catch(SQLException e){
            System.out.println("\"cylindres\" table already exists");
        }

        try{
            this.dbQuery("CREATE TABLE public.rectangles\n" +
                    "(\n" +
                    "  id serial,\n" +
                    "  length numeric,\n" +
                    "  width numeric,\n" +
                    "  thickness numeric,\n" +
                    "  type text,\n" +
                    "  color text,\n" +
                    "  remaininglength numeric,\n" +
                    "  remainingwidth numeric,\n" +
                    "  remainingthickness numeric,\n" +
                    "  price numeric,\n" +
                    "  pricecm numeric,\n" +
                    "  qty integer\n" +
                    ")\n" +
                    "WITH (\n" +
                    "  OIDS=FALSE\n" +
                    ");");
        }
        catch(SQLException e){
            System.out.println("\"rectangles\" table already exists");
        }

        try{
            this.dbQuery("CREATE TABLE public.visserie\n" +
                    "(\n" +
                    "  id serial,\n" +
                    "  diameter numeric,\n" +
                    "  length numeric,\n" +
                    "  head text,\n" +
                    "  type text,\n" +
                    "  qty integer,\n" +
                    "  color text,\n" +
                    "  price numeric,\n" +
                    "  totalprice numeric\n" +
                    ")\n" +
                    "WITH (\n" +
                    "  OIDS=FALSE\n" +
                    ");");
        }
        catch(SQLException e){
            System.out.println("\"visserie\" table already exists");
        }
    }

    public ObservableList<AbsMaterial> getExternalDbEntries(Database database){
        this.connect();
        List<AbsMaterial> list = new ArrayList<>();
        ObservableList<AbsMaterial> oldb = FXCollections.observableList(list);
        Statement state;
        try {
            state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM \""+database.getName().toLowerCase()+"\"");
            List<DbColumn> columns = database.getColumns();

            while (result.next()) {

                DBItem item = new DBItem(database);



                for(DbColumn col : columns) {
                    if (col.getName().equalsIgnoreCase("length")) {
                        double a = result.getDouble("length");
                        item.setLength(a);
                    }
                    if(col.getName().equalsIgnoreCase("width")){
                        double b = result.getDouble("width");
                        item.setWidth(b);
                    }
                    if(col.getName().equalsIgnoreCase("thickness")){
                        double c = result.getDouble("thickness");
                        item.setThickness(c);
                    }
                    if(col.getName().equalsIgnoreCase("type")){
                        String d = result.getString("type");
                        item.setType(d);
                    }
                    if(col.getName().equalsIgnoreCase("color")){
                        String e = result.getString("color");
                        item.setColor(e);
                    }
                    if(col.getName().equalsIgnoreCase("remaininlength")){
                        double g = result.getDouble("remaininglength");
                        item.setRemainingLength(g);
                    }
                    if(col.getName().equalsIgnoreCase("remainingwidth")){
                        double h = result.getDouble("remainingwidth");
                        item.setRemainingWidth(h);
                    }
                    if(col.getName().equalsIgnoreCase("remainingthickness")){
                        double i = result.getDouble("remainingthickness");
                        item.setRemainingThickness(i);
                    }
                    if(col.getName().equalsIgnoreCase("price")){
                        double j = result.getDouble("price");
                        item.setPrice(j);
                    }
                    if(col.getName().equalsIgnoreCase("qty")){
                        int k = result.getInt("qty");
                        item.setQty(k);
                    }
                    if(col.getName().equalsIgnoreCase("id")){
                        int l = result.getInt("id");
                        item.setId(l);
                    }
                    if(col.getName().equalsIgnoreCase("head")){
                        String a = result.getString("head");
                        item.setHead(a);
                    }
                    if(col.getName().equalsIgnoreCase("diameter")){
                        Double a = result.getDouble("diameter");
                        item.setDiameter(a);
                    }
                    if(col.getName().equalsIgnoreCase("initialweight")){
                        Double a = result.getDouble("initialweight");
                        item.setInitialWeight(a);
                    }
                    if(col.getName().equalsIgnoreCase("remainingweight")){
                        Double a = result.getDouble("remainingweight");
                        item.setRemainingWeight(a);
                    }
                    if(col.getName().equalsIgnoreCase("pricecm")){
                        Double a = result.getDouble("pricecm");
                        item.setPriceCm(a);
                    }
                    if(col.getName().equalsIgnoreCase("pieceprice")){
                        Double a = result.getDouble("pieceprice");
                        item.setPiecePrice(a);
                    }
                }

                oldb.add(item);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            oldb = null;
        }
        catch (NullPointerException e){
            e.printStackTrace();
            oldb = null;
        }
        return oldb;
    }

}
