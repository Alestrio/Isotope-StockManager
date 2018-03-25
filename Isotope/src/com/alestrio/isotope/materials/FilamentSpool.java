package com.alestrio.isotope.materials;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

public
class FilamentSpool implements Material {

    private DoubleProperty diameter;
    private DoubleProperty initialWeight;
    private DoubleProperty initialLength;
    private DoubleProperty remainingWeight;
    private DoubleProperty remainingLength;
    private StringProperty type;
    private StringProperty color;

    public FilamentSpool(float a, float b, float c, String d, String e, float f, float g) {
        diameter.set(a);
        initialWeight.set(b);
        remainingWeight.set(c);
        type.set(d);
        color.set(e);
        initialLength.set(f);
        remainingLength.set(g);
    }

    @Override
    public
    String getHead () {
        return null;
    }

    @Override
    public StringProperty getHeadProperty() {
        return null;
    }

    @Override
    public
    double getDiameter () {
        return diameter.get();
    }

    @Override
    public
    DoubleProperty getDiameterProperty () {
        return null;
    }

    @Override
    public
    double getLength () {
        return initialLength.get();
    }

    @Override
    public
    DoubleProperty getLengthProperty () {
        return initialLength;
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
    public String getType() {
        return type.get();
    }
    @Override
    public StringProperty getTypeProperty() {
        return type;
    }

    @Override
    public
    double getRemainingWeight () {
        return remainingWeight.get();
    }
    @Override
    public
    DoubleProperty getRemainingWeightProperty () {
        return remainingWeight;
    }

    @Override
    public
    double getInitialWeight () {
        return initialWeight.get();
    }
    @Override
    public
    DoubleProperty getInitialWeightProperty () {
        return initialWeight;
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
    public
    double getRemainingLength () {
        return remainingLength.get();
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
