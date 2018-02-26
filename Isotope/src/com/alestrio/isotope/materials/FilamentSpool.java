package com.alestrio.isotope.materials;

public class FilamentSpool implements Material{

	private float diameter = 0;
	private int initialWeight = 0;
	private int remainingWeight = 0;
	private String type = "";
	private String color = "";
	
	public FilamentSpool(float a,int b,int c,String d, String e) {
		diameter = a;
		initialWeight = b;
		remainingWeight = c;
		type = d;
		color = e;
	}
	
	@Override
	public String getHead() {
		return null;
	}

	@Override
	public float getDiameter() {
		return diameter;
	}

	@Override
	public int getLength() {
		return 0;
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
		return remainingWeight;
	}

	@Override
	public float getInitialWeight() {
		return initialWeight;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public int getRemainingLength() {
		// TODO Auto-generated method stub
		return 0;
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
