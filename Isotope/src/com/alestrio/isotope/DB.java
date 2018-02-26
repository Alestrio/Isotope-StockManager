package com.alestrio.isotope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alestrio.isotope.materials.* ;

public class DB extends Thread{
	
	private String url = "";
	private String user = "";
	private String pswd = "";
	Connection conn;
	
	public DB(String a, String b, String c) {
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
			// TODO Auto-generated catch block
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
		
		if(b)
			return true;
		else
			return false;
	}
	//-------- SPOOL --------
	public boolean eraseSpool(int id) {
		return false;
	}

	public boolean addSpool(FilamentSpool m) {
		float spoolDiameter = m.getDiameter();
		float initialWeight = m.getInitialWeight();
		float remainingWeight = m.getRemainingWeight();
		return false;
		
	}
	
	//-------- CYLINDERS --------
	public boolean eraseCylinder(int id) {
		ResultSet b;
		boolean c = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("DELETE " + id + " FROM cylindres");
			c = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}
	
	public boolean addCylinder(Cylinder c) {
		ResultSet b;
		boolean d = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("INSERT INTO cylindres (diameter, length, type)"
					+ " VALUES (" + c.getDiameter() + ", "+ c.getLength() +", "
					+ c.getType());
			d = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	//-------- SCREWS --------
	public boolean eraseScrew(int id) {
		return false;
		
	}
	
	public boolean addScrew(Screw s) {
		return false;
		
	}
	
	//-------- RECTANGULAR PIECES ---------
	public boolean eraseRectangularPiece(int id) {
		return false;
		
	}
	
	public boolean addRectangularPiece(RectangularPiece r) {
		return false;
		
	}
}
