package com.alestrio.isotope.materials;

public interface Material {
	//Screws
	String getHead();
	
	//Tubes or cylinders / screws
	float getDiameter();

	int getLength();

	int getRemainingLength();
	
	//Rectangular pieces
	int getWidth();

	int getRemainingWidth();

	int getThickness();

	int getRemainingThickness();
	
	//3D printers spools
	String getType();

	float getRemainingWeight();

	float getInitialWeight();

	String getColor();
}
