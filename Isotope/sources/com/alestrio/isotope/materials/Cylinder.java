package com.alestrio.isotope.materials;

public class Cylinder implements Material {

	private int diameter = 0;
	private int length = 0;
	private String type = "";
	
	public Cylinder(int a, int b, String c) {
		diameter = a;
		length = b;
		type = c;
	}
	
	@Override
	public int getDiameter() {
		return diameter;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public int getxDimension() {
		return 0;
	}

	@Override
	public int getyDimension() {
		return 0;
	}

	@Override
	public int getThickness() {
		return 0;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public int getRemainingLenght() {
		return 0;
	}

	@Override
	public String getHead() {
		return null;
	}

}
