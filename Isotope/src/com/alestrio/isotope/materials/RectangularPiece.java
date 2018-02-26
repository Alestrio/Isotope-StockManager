package com.alestrio.isotope.materials;

public class RectangularPiece implements Material{

	private int length = 0;
	private int width = 0;
	private int thickness = 0;
	private String type = "";
	
	public RectangularPiece(int a, int b, int c, String d) {
		length = a;
		width = b;
		thickness = c;
		type = d;
	}
	
	@Override
	public String getHead() {
		return null;
	}

	@Override
	public int getDiameter() {
		return 0;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getThickness() {
		// TODO Auto-generated method stub
		return thickness;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public int getRemainingWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInitialWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
