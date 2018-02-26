package com.alestrio.isotope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.alestrio.isotope.materials.* ;

public class DB extends Thread{
	
	private String url = "";
	private String urlM = url+"bobines";
	private String urlC = url+"cylindres";
	private String urlS = url+"visserie";
	private String urlR = url+"rectangles";
	private String user = "";
	private String pswd = "";
	Connection connM, connC, connS, connR;
	
	public DB(String a, String b, String c) {
		url = a;
		user = b;
		pswd = c;
	}
	
	public boolean connect() {
		try {
			connM = DriverManager.getConnection(urlM, user, pswd);
			connC = DriverManager.getConnection(urlC, user, pswd);
			connS = DriverManager.getConnection(urlS, user, pswd);
			connR = DriverManager.getConnection(urlR, user, pswd);
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
		boolean c = true;
		boolean d = true;
		boolean e = true;
		try {
			b = connM.isValid(MAX_PRIORITY);
			c = connC.isValid(MAX_PRIORITY);
			d = connS.isValid(MAX_PRIORITY);
			e = connR.isValid(MAX_PRIORITY);
		} catch (SQLException f) {
			f.printStackTrace();
			b = false;
			c = false;
			d = false;
			e = false;
		}
		
		if(b && c && d && e)
			return true;
		else
			return false;
	}
	
	public boolean eraseSpool(int id) {
		return false;
	}

	public boolean addSpool(FilamentSpool m) {
		float spoolDiameter = m.getDiameter();
		float initialWeight = m.getInitialWeight();
		float remainingWeight = m.getRemainingWeight();
		return false;
		
	}
	
	public boolean eraseCylinder(int id) {
		return false;
		
	}
	
	public boolean addCylinder(Cylinder c) {
		return false;
		
	}
	
	public boolean eraseScrew(int id) {
		return false;
		
	}
	
	public boolean addScrew(Screw s) {
		return false;
		
	}
	
	public boolean eraseRectangularPiece(int id) {
		return false;
		
	}
	
	public boolean addRectangularPiece(RectangularPiece r) {
		return false;
		
	}
}
