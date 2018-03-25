package com.alestrio.isotope.materials;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

public
class Cylinder implements Material {

    private DoubleProperty diameter;
    private DoubleProperty length;
    private StringProperty type;
    private StringProperty color;
    private DoubleProperty remainingLength;

    public
    Cylinder (float a ,float b ,String c ,String d) {
        diameter.set(a);
        length.set(b);
        type.set(c);
        color.set(d);
        remainingLength = length;
    }

    @Override
    public
    double getDiameter () {
        return diameter.get();
    }
    @Override
    public
    DoubleProperty getDiameterProperty () {
        return diameter;
    }

    @Override
    public
    double getLength () {
        return length.get();
    }
    @Override
    public
    DoubleProperty getLengthProperty () {
        return length;
    }

    @Override
    public
    double getWidth () {
        return 0;
    }
    @Override
    public
    DoubleProperty getWidthProperty () {
        return null;
    }

    @Override
    public
    double getThickness () {
        return 0;
    }
    @Override
    public
    DoubleProperty getThicknessProperty () {
        return null;
    }

    @Override
    public
    String getType () {
        return type.get();
    }
    @Override
    public
    StringProperty getTypeProperty () {
        return type;
    }

    @Override
    public
    double getRemainingWeight () {
        return 0;
    }
    @Override
    public
    DoubleProperty getRemainingWeightProperty () {
        return null;
    }

    @Override
    public
    String getHead () {
        return null;
    }
    @Override
    public
    StringProperty getHeadProperty () {
        return null;
    }

    @Override
    public
    double getInitialWeight () {
        return 0;
    }
    @Override
    public
    DoubleProperty getInitialWeightProperty () {
        return null;
    }

    @Override
    public
    String getColor () {
        return color.get();
    }
    @Override
    public
    StringProperty getColorProperty () {
        return color;
    }

    @Override
    public
    double getRemainingLength () {
        return (float) remainingLength.get();
    }
    @Override
    public
    DoubleProperty getRemainingLengthProperty () {
        return remainingLength;
    }

    @Override
    public
    double getRemainingWidth () {
        return 0;
    }
    @Override
    public
    DoubleProperty getRemainingWidthProperty () {
        return null;
    }

    @Override
    public
    double getRemainingThickness () {
        return 0;
    }
    @Override
    public
    DoubleProperty getRemainingThicknessProperty () {
        return null;
    }
}
