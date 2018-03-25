package com.alestrio.isotope.materials;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.StringProperty;

public
class Screw implements Material {

    private StringProperty head;
    private FloatProperty diameter;
    private FloatProperty length;
    private StringProperty type;
    private StringProperty color;

    public
    Screw (float a ,int b ,String c ,String d ,String e) {
        diameter.set(a);
        length.set(b);
        head.set(c);
        type.set(d);
        color.set(e);
    }

    @Override
    public
    String getHead () {
        return head.get();
    }
    @Override
    public StringProperty getHeadProperty() {
        return head;
    }

    @Override
    public float getDiameter() {
        return diameter.get();
    }
    @Override
    public FloatProperty getDiameterProperty() {
        return diameter;
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
    public
    float getRemainingWeight () {
        return 0;
    }
    @Override
    public FloatProperty getRemainingWeightProperty() {
        return null;
    }

    @Override
    public
    float getInitialWeight () {
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
        return 0;
    }

    @Override
    public FloatProperty getRemainingLengthProperty() {
        return null;
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
