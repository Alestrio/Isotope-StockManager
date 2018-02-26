package com.alestrio.isotope.materials;

public class FilamentSpool implements Material{

	private int diameter = 0;
	private int initialWeight = 0;
	private int remainingWeight = 0;
	private String type = "";
	
	public FilamentSpool(int a,int b,int c,String d) {
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
	public int getDiameter() {
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
	public int getRemainingWeight() {
		return remainingWeight;
	}

	@Override
	public int getInitialWeight() {
		return initialWeight;
	}

}
