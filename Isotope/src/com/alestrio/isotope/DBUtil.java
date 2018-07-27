/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope;

import com.alestrio.isotope.materials.Cylinder;
import com.alestrio.isotope.materials.FilamentSpool;
import com.alestrio.isotope.materials.RectangularPiece;
import com.alestrio.isotope.materials.Screw;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


abstract class AbsDB {

    private final String url;
    private final String user;
    private final String pswd;
    boolean isAlreadyConnected = false;
    private Connection conn;
    private Settings s = new Settings();

    AbsDB() {
        url = s.getDbUrl();
        user = s.getDbUser();
        pswd = s.getDbPswd();
    }


    protected boolean connect() {
        try {
            conn = DriverManager.getConnection(url, user, pswd);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    protected boolean disconnect() {
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


    protected void dbQuery(String query) {
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<FilamentSpool> getDbEntriesSpool() {
        List<FilamentSpool> list = new ArrayList<>();
        ObservableList<FilamentSpool> olf = FXCollections.observableList(list);
        Statement state;
        try {
            state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM bobines");

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
            ResultSet result = state.executeQuery("SELECT * FROM cylindres");

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

            ResultSet result = state.executeQuery("SELECT * FROM visserie");
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
            ResultSet result = state.executeQuery("SELECT * FROM rectangles");

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

    //TODO Method "createDatabase"

}

public class DBUtil {
    private DB db = new DB();

    public DBUtil() {
    }

    public DB getDb() {
        return this.db;
    }
}