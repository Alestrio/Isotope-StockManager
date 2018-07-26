/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope;

import com.alestrio.isotope.controllers.ControllerV;
import com.alestrio.isotope.materials.Cylinder;
import com.alestrio.isotope.materials.FilamentSpool;
import com.alestrio.isotope.materials.RectangularPiece;
import com.alestrio.isotope.materials.Screw;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DB extends Thread{

	private final String     url;
	private final String     user;
	private final String     pswd;
	private       Connection conn;

	public
	DB (String a ,String b ,String c) {
		url = a;
		user = b;
		pswd = c;
		connect();
	}
	
	public boolean connect() {
		try {
			conn = DriverManager.getConnection(url, user, pswd);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean getDriverState() {
		try {
            Class.forName("org.postgresql.Driver");
            return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean getConnectionState() throws SQLException {
		boolean b;
		b = conn.isValid(MAX_PRIORITY);
        return b;
	}

	public void dbQuery(String query){
		try {
			Statement state = conn.createStatement();
			state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public
	ObservableList<FilamentSpool> getDbEntriesSpool () throws Exception {
        List<FilamentSpool>           list   = new ArrayList<>();
        ObservableList<FilamentSpool> olf    = FXCollections.observableList(list);
		Statement                     state  = conn.createStatement();
		ResultSet                     result = state.executeQuery("SELECT * FROM bobines");

		while (result.next()) {
			double a = result.getDouble("diameter");
			double b = result.getDouble("initialweight");
			double c = result.getDouble("remainingweight");
			String d = result.getString("type");
			String e = result.getString("color");
			int f = result.getInt("qty");
			double g = result.getDouble("price");
			olf.add(new FilamentSpool(a ,b ,c ,d ,e, f, g));
		}
        return olf;
    }

    public
	ObservableList<Cylinder> getDbEntriesCylinders () throws Exception {
        List<Cylinder>           list   = new ArrayList<>();
        ObservableList<Cylinder> olc    = FXCollections.observableList(list);
		Statement                state  = conn.createStatement();
		ResultSet                result = state.executeQuery("SELECT * FROM cylindres");

		while (result.next()) {
			double a = result.getDouble("diameter");
			double b = result.getDouble("length");
			String c = result.getString("type");
			String d = result.getString("color");
			int    e = result.getInt("price");
			double f = result.getDouble("remainingLength");
			int g = result.getInt("qty");
			olc.add(new Cylinder(a ,b ,c ,d ,e ,f, g));
		}
        return olc;
    }

    public
    ObservableList<Screw> getDbEntriesScrew (){
        int i = 0;

		List<Screw>           list = new ArrayList<>();
        ObservableList<Screw> ols  = FXCollections.observableList(list);

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
            int    f = result.getInt("qty");
            double g = result.getDouble("price");
            ols.add(new Screw(a ,b ,c ,d ,e ,f, g));
        }
	} catch (SQLException e) {
		e.printStackTrace();
		ols = null;
	}
	 return ols;
    }

    public
	ObservableList<RectangularPiece> getDbEntriesRecPieces () {
        List<RectangularPiece>           list   = new ArrayList<>();
        ObservableList<RectangularPiece> olr    = FXCollections.observableList(list);
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
				olr.add(new RectangularPiece(a, b, c, d, e, g, h, i, j, k));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			olr = null;
		}
		return olr;
    }

}