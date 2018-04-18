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

	private final String     url;
	private final String     user;
	private final String     pswd;
	private       Connection conn;

	public
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
		boolean b;
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

	public
	boolean addSpool (FilamentSpool m) {
		ResultSet b;
		boolean d = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("INSERT INTO bobines (type, diameter, initialweight, remainingweight, color)"
					+ " VALUES ('" + m.getType() + "', " + m.getDiameter() + ", " + m.getInitialWeight() + ", "
					+ m.getRemainingWeight() + ", '" + m.getColor() + "')");
			d = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
		
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
			olf.add(new FilamentSpool(a ,b ,c ,d ,e));
		}
        return olf;
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
			int    e = result.getInt("qty");
			double f = result.getDouble("remainingLength");
			olc.add(new Cylinder(a ,b ,c ,d ,e ,f));
		}
        return olc;
    }
	
	//-------- SCREWS --------
	public boolean eraseScrew(Screw s) {
		ResultSet b;
		boolean c = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("DELETE FROM visserie WHERE diameter = " + s.getDiameter()+" , length = " + s.getLength() + ", type = '" +s.getType()+"' color = '" + s.getColor()+
			"', qty=" +s.getQty() + ", remainingLength = " + s.getRemainingLength());
			c = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
		
	}

    public
    boolean addScrew (Screw s) {
		ResultSet b;
		boolean d = true;
		try {
			Statement state = conn.createStatement();
            b = state.executeQuery("INSERT INTO visserie (diameter, length, head, type, color, qty) VALUES (" + s.getDiameter() + ", " + s.getLength() + ", '" + s.getHead() + "', '" + s.getType() + "', '" + s.getColor() + "', " + s.getQty() + ")");
			d = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
		
	}

    public
    ObservableList<Screw> getDbEntriesScrew () throws Exception {
        int i = 0;

		List<Screw>           list = new ArrayList<>();
        ObservableList<Screw> ols  = FXCollections.observableList(list);

        Statement state  = conn.createStatement();
        ResultSet result = state.executeQuery("SELECT * FROM visserie");
        while (result.next()) {
            double a = result.getDouble("diameter");
            double b = result.getDouble("length");
            String c = result.getString("head");
            String d = result.getString("type");
            String e = result.getString("color");
            int    f = result.getInt("qty");
            ols.add(new Screw(a ,b ,c ,d ,e ,f));
        }

        return ols;
    }
	
	//-------- RECTANGULAR PIECES ---------
	public
	void eraseRectangularPiece (RectangularPiece r) {
		
	}

	public
	boolean addRectangularPiece (RectangularPiece r) {
		ResultSet b;
		boolean d = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("INSERT INTO rectangles (length, width, thickness, type, color, remainingLength, remainingWidth, remainingThickness)"
					+ " VALUES (" + r.getLength() + ", "+ r.getWidth() +", "
					+ r.getThickness() + ", '" + r.getType() + "', '" + r.getColor() + "', " + r.getRemainingLength() + ", "
					+ r.getRemainingWidth() + ", " + r.getRemainingThickness() + ") ");
			d = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

    public
	ObservableList<RectangularPiece> getDbEntriesRecPieces () throws Exception {
        List<RectangularPiece>           list   = new ArrayList<>();
        ObservableList<RectangularPiece> olr    = FXCollections.observableList(list);
		Statement                        state  = conn.createStatement();
		ResultSet                        result = state.executeQuery("SELECT * FROM rectangles");

		while (result.next()) {
			double a = result.getDouble("length");
			double b = result.getDouble("width");
			double c = result.getDouble("thickness");
			String d = result.getString("type");
			String e = result.getString("color");
			double g = result.getDouble("remainingLength");
			double h = result.getDouble("remainingWidth");
			double i = result.getDouble("remainingThickness");
			olr.add(new RectangularPiece(a ,b ,c ,d ,e ,g ,h ,i));
		}

        return olr;
    }
}