package com.alestrio.isotope.materials;

public class Screw implements Material{

	private String head = "";
	private int diameter = 0;
	private int length = 0;
	
	public Screw(int a, int b, String c) {
		diameter = a;
		length = b;
		head = c;
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
		return null;
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


}
