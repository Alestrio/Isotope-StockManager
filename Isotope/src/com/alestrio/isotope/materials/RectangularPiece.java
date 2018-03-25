package com.alestrio.isotope.materials;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.StringProperty;

public class RectangularPiece implements Material{

    private FloatProperty length;
    private FloatProperty remainingLength;
    private FloatProperty width;
    private FloatProperty remainingWidth;
    private FloatProperty thickness;
    private FloatProperty remainingThickness;
    private StringProperty type;
    private StringProperty color;
	
	public RectangularPiece(int a, int b, int c, String d, String e) {
        length.set(a);
        width.set(b);
        thickness.set(c);
        type.set(d);
        color.set(e);
		
		remainingLength = length;
		remainingWidth = width;
		remainingThickness = thickness;
	}
	
	@Override
	public String getHead() {
		return null;
	}

    @Override
    public StringProperty getHeadProperty() {
        return null;
    }

	@Override
	public float getDiameter() {
		return 0;
	}

    @Override
    public FloatProperty getDiameterProperty() {
        return null;
    }

	@Override
    public float getLength() {
        return length.get();
    }

    @Override
    public FloatProperty getLengthProperty() {
		return length;
	}

	@Override
    public float getWidth() {
        return width.get();
    }

    @Override
    public FloatProperty getWidthProperty() {
		return width;
	}

	@Override
    public float getThickness() {
        return thickness.get();
    }

    @Override
    public FloatProperty getThicknessProperty() {
		return thickness;
	}

	@Override
	public String getType() {
        return type.get();
    }

    @Override
    public StringProperty getTypeProperty() {
		return type;
	}

	@Override
	public float getRemainingWeight() {
		return 0;
	}

    @Override
    public FloatProperty getRemainingWeightProperty() {
        return null;
    }

	@Override
	public float getInitialWeight() {
		return 0;
	}

    @Override
    public FloatProperty getInitialWeightProperty() {
        return null;
    }

	@Override
    public String getColor() {
        return color.get();
    }

    @Override
    public StringProperty getColorProperty() {
        return color;
    }

	@Override
    public float getRemainingLength() {
        return remainingLength.get();
    }

    @Override
    public FloatProperty getRemainingLengthProperty() {
		return remainingLength;
	}

	@Override
    public float getRemainingWidth() {
        return remainingWidth.get();
    }

    @Override
    public FloatProperty getRemainingWidthProperty() {
		return remainingWidth;
	}

	@Override
    public float getRemainingThickness() {
        return remainingThickness.get();
    }

    @Override
    public FloatProperty getRemainingThicknessProperty() {
		return remainingThickness;
	}
}
