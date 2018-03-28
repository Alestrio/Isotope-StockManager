package com.alestrio.isotope.materials;

import javafx.beans.property.*;

public
class RectangularPiece implements Material {

    private SimpleDoubleProperty length             = new SimpleDoubleProperty();
    private SimpleDoubleProperty remainingLength    = new SimpleDoubleProperty();
    private SimpleDoubleProperty width              = new SimpleDoubleProperty();
    private SimpleDoubleProperty remainingWidth     = new SimpleDoubleProperty();
    private SimpleDoubleProperty thickness          = new SimpleDoubleProperty();
    private SimpleDoubleProperty remainingThickness = new SimpleDoubleProperty();
    private SimpleStringProperty type               = new SimpleStringProperty();
    private SimpleStringProperty color              = new SimpleStringProperty();

    public
    RectangularPiece (double a ,double b ,double c ,String d ,String e ,double g ,double h ,double i) {
        length.set(a);
        width.set(b);
        thickness.set(c);
        type.set(d);
        color.set(e);
        remainingLength.set(g);
        remainingWidth.set(h);
        remainingThickness.set(i);
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
        return 0;
    }
    @Override
    public
    DoubleProperty getDiameterProperty () {
        return null;
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
        return width.get();
    }
    @Override
    public
    DoubleProperty getWidthProperty () {
        return width;
    }

    @Override
    public
    double getThickness () {
        return thickness.get();
    }
    @Override
    public
    DoubleProperty getThicknessProperty () {
        return thickness;
    }

    @Override
    public
    String getType () {
        return type.get();
    }
    @Override
    public StringProperty getTypeProperty() {
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
    double getInitialWeight () {
        return 0;
    }
    @Override
    public
    DoubleProperty getInitialWeightProperty () {
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
    public
    int getQty () {
        return 0;
    }

    @Override
    public
    IntegerProperty getQtyProperty () {
        return null;
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
        return remainingWidth.get();
    }
    @Override
    public
    DoubleProperty getRemainingWidthProperty () {
        return remainingWidth;
    }

    @Override
    public
    double getRemainingThickness () {
        return remainingThickness.get();
    }
    @Override
    public
    DoubleProperty getRemainingThicknessProperty () {
        return remainingThickness;
    }
}
