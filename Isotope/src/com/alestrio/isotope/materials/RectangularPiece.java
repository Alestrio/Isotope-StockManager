package com.alestrio.isotope.materials;

import javafx.beans.property.*;

public
class RectangularPiece implements Material {

    private SimpleDoubleProperty length = new SimpleDoubleProperty();
    private SimpleDoubleProperty remainingLength;
    private SimpleDoubleProperty width = new SimpleDoubleProperty();
    private SimpleDoubleProperty remainingWidth;
    private SimpleDoubleProperty thickness = new SimpleDoubleProperty();
    private SimpleDoubleProperty remainingThickness;
    private SimpleStringProperty  type  = new SimpleStringProperty();
    private SimpleStringProperty  color = new SimpleStringProperty();
    private SimpleIntegerProperty qty   = new SimpleIntegerProperty();

    public
    RectangularPiece (int a ,int b ,int c ,String d ,String e ,int f) {
        length.set(a);
        width.set(b);
        thickness.set(c);
        type.set(d);
        color.set(e);
        qty.set(f);

        remainingLength = length;
        remainingWidth = width;
        remainingThickness = thickness;
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
