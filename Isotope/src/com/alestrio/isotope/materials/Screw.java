package com.alestrio.isotope.materials;

import javafx.beans.property.*;

public
class Screw implements Material {

    private final SimpleStringProperty  head     = new SimpleStringProperty();
    private final SimpleDoubleProperty  diameter = new SimpleDoubleProperty();
    private final SimpleDoubleProperty  length   = new SimpleDoubleProperty();
    private final SimpleStringProperty  type     = new SimpleStringProperty();
    private final SimpleStringProperty  color    = new SimpleStringProperty();
    private final SimpleIntegerProperty qty      = new SimpleIntegerProperty();

    public
    Screw (double a ,double b ,String c ,String d ,String e ,int f) {
        this.diameter.set(a);
        this.length.set(b);
        this.head.set(c);
        this.type.set(d);
        this.color.set(e);
        this.qty.set(f);
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
        return 0;
    }

    @Override
    public
    DoubleProperty getRemainingLengthProperty () {
        return null;
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
