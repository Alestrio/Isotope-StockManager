package com.alestrio.isotope.materials;

import javafx.beans.property.*;

public
class FilamentSpool implements Material {

    private SimpleDoubleProperty  diameter        = new SimpleDoubleProperty();
    private SimpleDoubleProperty  initialWeight   = new SimpleDoubleProperty();
    private SimpleDoubleProperty  initialLength   = new SimpleDoubleProperty();
    private SimpleDoubleProperty  remainingWeight = new SimpleDoubleProperty();
    private SimpleDoubleProperty  remainingLength = new SimpleDoubleProperty();
    private SimpleStringProperty  type            = new SimpleStringProperty();
    private SimpleStringProperty  color           = new SimpleStringProperty();
    private SimpleIntegerProperty qty             = new SimpleIntegerProperty();

    public
    FilamentSpool (float a ,float b ,float c ,String d ,String e ,float f ,float g ,int h) {
        diameter.set(a);
        initialWeight.set(b);
        remainingWeight.set(c);
        type.set(d);
        color.set(e);
        initialLength.set(f);
        remainingLength.set(g);
        qty.set(h);
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
    int getQty () {
        return qty.get();
    }

    @Override
    public
    IntegerProperty getQtyProperty () {
        return qty;
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
