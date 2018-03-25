package com.alestrio.isotope.materials;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.StringProperty;

public
class FilamentSpool implements Material {

    private FloatProperty diameter;
    private FloatProperty initialWeight;
    private FloatProperty initialLength;
    private FloatProperty remainingWeight;
    private FloatProperty remainingLength;
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
    float getDiameter () {
        return diameter.get();
    }

    @Override
    public FloatProperty getDiameterProperty() {
        return null;
    }

    @Override
    public float getLength() {
        return initialLength.get();
    }

    @Override
    public FloatProperty getLengthProperty() {
        return initialLength;
    }

    @Override
    public float getWidth() {
        return 0;
    }

    @Override
    public FloatProperty getWidthProperty() {
        return null;
    }

    @Override
    public float getThickness() {
        return 0;
    }

    @Override
    public FloatProperty getThicknessProperty() {
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
    public float getRemainingWeight() {
        return remainingWeight.get();
    }
    @Override
    public FloatProperty getRemainingWeightProperty() {
        return remainingWeight;
    }

    @Override
    public float getInitialWeight() {
        return initialWeight.get();
    }
    @Override
    public FloatProperty getInitialWeightProperty() {
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
    public float getRemainingLength() {
        return remainingLength.get();
    }
    @Override
    public FloatProperty getRemainingLengthProperty() {
        return remainingLength;
    }

    @Override
    public
    float getRemainingWidth () {
        return 0;
    }

    @Override
    public FloatProperty getRemainingWidthProperty() {
        return null;
    }

    @Override
    public
    float getRemainingThickness () {
        return 0;
    }
    @Override
    public FloatProperty getRemainingThicknessProperty() {
        return null;
    }
}
