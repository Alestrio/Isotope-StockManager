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
    private final SimpleDoubleProperty  price     = new SimpleDoubleProperty();
    private final SimpleDoubleProperty  totalPrice = new SimpleDoubleProperty();


    public
    Screw (double diameter ,double length ,String head ,String type ,String color,int qty, double price) {
        this.diameter.set(diameter);
        this.length.set(length);
        this.head.set(head);
        this.type.set(type);
        this.color.set(color);
        this.qty.set(qty);
        this.price.set(price);
        this.totalPrice.set(qty*price);
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
    public double getPrice() {
        return price.get();
    }

    public double getTotalPrice(){
        return totalPrice.get();
    }

    @Override
    public DoubleProperty getPriceProperty() {
        return price;
    }

    public DoubleProperty getTotalPriceProperty(){
        return totalPrice;
    }

    public void setQty(int qty) {
        this.qty.set(qty);
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
