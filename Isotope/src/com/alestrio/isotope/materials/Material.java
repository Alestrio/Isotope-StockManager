package com.alestrio.isotope.materials;

public interface Material {
	//Screws
	
	public String getHead();
	
	//Tubes or cylinders / screws
	public int getDiameter();
	
	public int getLength();
	
	//Rectangular pieces
	public int getWidth();
	
	public int getThickness();
	
	//3D printers spools
	public String getType();
	
	public int getRemainingWeight();
	
	public int getInitialWeight();
}
