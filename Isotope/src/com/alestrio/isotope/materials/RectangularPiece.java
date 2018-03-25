package com.alestrio.isotope.materials;

public class RectangularPiece implements Material{

	private int length = 0;
	private int remainingLength = 0;
	private int width = 0;
	private int remainingWidth = 0;
	private int thickness = 0;
	private int remainingThickness = 0;
	private String type = "";
	private String color = "";
	
	public RectangularPiece(int a, int b, int c, String d, String e) {
		length = a;
		width = b;
		thickness = c;
		type = d;
		color = e;
		
		remainingLength = length;
		remainingWidth = width;
		remainingThickness = thickness;
	}
	
	@Override
	public String getHead() {
		return null;
	}

	@Override
	public float getDiameter() {
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
	public float getRemainingWeight() {
		// TODO Auto-generated method stub
		return 0;
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
		return remainingWidth;
	}

	@Override
	public int getRemainingThickness() {
		// TODO Auto-generated method stub
		return remainingThickness;
	}
}
