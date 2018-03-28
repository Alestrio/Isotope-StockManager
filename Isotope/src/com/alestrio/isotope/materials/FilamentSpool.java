package com.alestrio.isotope.materials;

import javafx.beans.property.*;

public
class FilamentSpool implements Material {

    private final SimpleDoubleProperty  diameter        = new SimpleDoubleProperty();
    private final SimpleDoubleProperty  initialWeight   = new SimpleDoubleProperty();
    private final SimpleDoubleProperty  remainingWeight = new SimpleDoubleProperty();
    private final SimpleStringProperty  type            = new SimpleStringProperty();
    private final SimpleStringProperty  color           = new SimpleStringProperty();
    private final SimpleIntegerProperty qty             = new SimpleIntegerProperty();

    public
    FilamentSpool (double a ,double b ,double c ,String d ,String e) {
        diameter.set(a);
        initialWeight.set(b);
        remainingWeight.set(c);
        type.set(d);
        color.set(e);
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
        return 0;
    }

    @Override
    public
    DoubleProperty getLengthProperty () {
        return null;
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
