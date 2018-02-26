package com.alestrio.isotope;

import com.alestrio.isotope.materials.Material;

public class DB extends Thread{
	
	private String url = "";
	private String user = "";
	private String pswd = "";
	
	public DB(String a, String b, String c) {
		url = a;
		user = b;
		pswd = c;
	}
	
	public boolean connect() {
		return false;
		
	}
	
	public boolean getConnectionState() {
		return false;
	}

	public boolean getDriverState() {
		return false;
	}
	
	public boolean erase(int id) {
		return false;
	}

	public boolean add(String name, Material m) {
		return false;
		
	}
	
}
