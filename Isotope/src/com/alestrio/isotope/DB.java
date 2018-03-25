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


public class DB extends Thread{

    List<Screw>           list = new ArrayList<Screw>();
    ObservableList<Screw> ols  = FXCollections.observableList(list);
    private String     url;
    private String     user;
    private String     pswd;
    private Connection conn;

    DB (String a ,String b ,String c) {
		url = a;
		user = b;
		pswd = c;
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
	
	public boolean getConnectionState() {
		boolean b = true;
		try {
			b = conn.isValid(MAX_PRIORITY);
		} catch (SQLException f) {
			f.printStackTrace();
			b = false;
		}

        return b;
	}
	//-------- SPOOL --------
	public boolean eraseSpool(int id) {
		ResultSet b;
		boolean c = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("DELETE FROM bobines WHERE id="+id);
			c = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public boolean addSpool(FilamentSpool m, int qty) {
		ResultSet b;
		boolean d = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("INSERT INTO bobines (type, diameter, initialWeight, remainingWeight, color, qty)"
					+ " VALUES (" + m.getType() + ", " + m.getDiameter() + ", "+ m.getInitialWeight() +", "
					+ m.getRemainingWeight() + ", " + m.getColor() + ", " + qty);
			d = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
		
	}
	
	//-------- CYLINDERS --------
	public boolean eraseCylinder(int id) {
		ResultSet b;
		boolean c = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("DELETE FROM cylinders WHERE id="+id);
			c = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return c;
		
	}
	
	public boolean addCylinder(Cylinder c, int qty) {
		ResultSet b;
		boolean d = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("INSERT INTO cylindres (diameter, length, color, type, remainingLength, qty)"
					+ " VALUES (" + c.getDiameter() + ", "+ c.getLength() +", "
					+ c.getColor() + ", " + c.getType() + ", " + c.getRemainingLength() + ", " + qty);
			d = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
		
	}
	
	//-------- SCREWS --------
	public boolean eraseScrew(int id) {
		ResultSet b;
		boolean c = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("DELETE FROM visserie WHERE id="+id);
			c = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
		
	}
	
	public boolean addScrew(Screw s, int qty) {
		ResultSet b;
		boolean d = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("INSERT INTO visserie (diameter, length, head, type, color, qty) VALUES ("+s.getDiameter()+", "+s.getLength()+", '"+s.getHead()+"', '"+s.getType()+"', '"+s.getColor()+"', "+qty+")");
			d = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
		}
		return d;
		
	}
	
	//-------- RECTANGULAR PIECES ---------
	public boolean eraseRectangularPiece(int id) { 
		ResultSet b;
		boolean c = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("DELETE FROM rectangles WHERE id="+id);
			c = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
		}
		return c;
		
	}
	
	public boolean addRectangularPiece(RectangularPiece r, int qty) {
		ResultSet b;
		boolean d = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("INSERT INTO rectangles (length, width, thickness, type, color, remainingLength, remainingWidth, remainingThickness, qty)"
					+ " VALUES (" + r.getLength() + ", "+ r.getWidth() +", "
					+ r.getThickness() + ", " + r.getType() + ", " + r.getColor() + ", " + r.getRemainingLength() + ", "
					+ r.getRemainingWidth() + ", " + r.getRemainingThickness() + ", " + qty);
			d = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
		}
		return d;
	}

    public ObservableList<Screw> getDbEntriesScrew() throws Exception {
		 int i = 0;

	      Statement state = conn.createStatement();
	      ResultSet result = state.executeQuery("SELECT * FROM visserie");
        while (result.next()) {
            double a = result.getDouble("diameter");
            double b = result.getDouble("length");
            String c = result.getString("head");
            String d = result.getString("type");
            String e = result.getString("color");
            ols.add(new Screw(a ,b ,c ,d ,e));
        }

        return ols;
	 }
}