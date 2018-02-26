package com.alestrio.isotope.materials;

public class Screw implements Material{

	private String head = "";
	private int diameter = 0;
	private int length = 0;
	private String type = "";
	
	public Screw(int a, int b, String c, String d) {
		diameter = a;
		length = b;
		head = c;
		type = d;
		
	}
	
	@Override
	public String getHead() {
		return head;
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
	public float getInitialWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}


}
