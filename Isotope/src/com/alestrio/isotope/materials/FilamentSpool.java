package com.alestrio.isotope.materials;

public class FilamentSpool implements Material{

	private float diameter = 0;
	private int initialWeight = 0;
	private int remainingWeight = 0;
	private String type = "";
	
	public FilamentSpool(float a,int b,int c,String d) {
		diameter = a;
		initialWeight = b;
		remainingWeight = c;
		type = d;
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

}
