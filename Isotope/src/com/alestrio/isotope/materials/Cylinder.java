package com.alestrio.isotope.materials;

public class Cylinder implements Material {

	private int diameter = 0;
	private int length = 0;
	private String type = "";
	private String color = "";
	private int remainingLength = 0;
	
	public Cylinder(int a, int b, String c, String d) {
		diameter = a;
		length = b;
		type = c;
		color = d;
		remainingLength = length;
	}
	
	@Override
	public float getDiameter() {
		return diameter;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
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
	public float getRemainingWeight() {
		return 0;
	}

	@Override
	public String getHead() {
		return null;
	}

	@Override
	public float getInitialWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public int getRemainingLength() {
		// TODO Auto-generated method stub
		return remainingLength;
	}

	@Override
	public int getRemainingWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRemainingThickness() {
		// TODO Auto-generated method stub
		return 0;
	}


}
