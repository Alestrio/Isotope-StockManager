package com.alestrio.isotope.materials;

import javafx.beans.property.*;

public abstract class AbsMaterial {

    protected SimpleStringProperty head = new SimpleStringProperty();
    protected SimpleDoubleProperty diameter = new SimpleDoubleProperty();
    protected SimpleDoubleProperty length = new SimpleDoubleProperty();
    protected SimpleDoubleProperty remainingLength = new SimpleDoubleProperty();
    protected SimpleDoubleProperty width = new SimpleDoubleProperty();
    protected SimpleDoubleProperty remainingWidth = new SimpleDoubleProperty();
    protected SimpleDoubleProperty thickness = new SimpleDoubleProperty();
    protected SimpleDoubleProperty remainingThickness = new SimpleDoubleProperty();
    protected SimpleStringProperty type = new SimpleStringProperty();
    protected SimpleDoubleProperty initialWeight = new SimpleDoubleProperty();
    protected SimpleDoubleProperty remainingWeight = new SimpleDoubleProperty();
    protected SimpleStringProperty color = new SimpleStringProperty();
    protected SimpleIntegerProperty qty = new SimpleIntegerProperty();
    protected SimpleDoubleProperty price = new SimpleDoubleProperty();
    protected SimpleDoubleProperty totalPrice = new SimpleDoubleProperty();

    //Screws
    String getHead (){
        return this.head.get();
    }

    StringProperty getHeadProperty(){
        return this.head;
    }

    //Tubes or cylinders / screws
    double getDiameter (){
        return this.diameter.get();
    }

    DoubleProperty getDiameterProperty (){
        return this.diameter;
    }

    double getLength (){
        return this.length.get();
    }

    DoubleProperty getLengthProperty (){
        return this.length;
    }

    double getRemainingLength (){
        return this.remainingLength.get();
    }

    DoubleProperty getRemainingLengthProperty (){
        return this.remainingLength;
    }

    //Rectangular pieces
    double getWidth (){
        return this.width.get();
    }

    DoubleProperty getWidthProperty (){
        return this.width;
    }

    double getRemainingWidth (){
        return this.remainingWidth.get();
    }

    DoubleProperty getRemainingWidthProperty (){
        return this.width;
    }

    double getThickness (){
        return this.thickness.get();
    }

    DoubleProperty getThicknessProperty (){
        return this.thickness;
    }

    double getRemainingThickness (){
        return this.remainingThickness.get();
    }

    DoubleProperty getRemainingThicknessProperty (){
        return this.remainingThickness;
    }

    //3D printers spools
    String getType (){
        return this.type.get();
    }

    StringProperty getTypeProperty(){
        return this.type;
    }

    double getRemainingWeight (){
        return this.remainingWeight.get();
    }

    DoubleProperty getRemainingWeightProperty (){
        return this.remainingWeight;
    }

    double getInitialWeight (){
        return this.initialWeight.get();
    }

    DoubleProperty getInitialWeightProperty (){
        return this.initialWeight;
    }

    String getColor (){
        return this.color.get();
    }

    StringProperty getColorProperty(){
        return this.color;
    }

    int getQty (){
        return this.qty.get();
    }

    IntegerProperty getQtyProperty (){
        return this.qty;
    }

    double getPrice(){
        return this.price.get();
    }

    DoubleProperty getPriceProperty(){
        return this.price;
    }

    double getTotalPrice(){
        return this.totalPrice.get();
    }

    DoubleProperty getTotalPriceProperty(){
        return this.totalPrice;
    }

    public void setDiameter(double diameter) {
        this.diameter.set(diameter);
    }

    public void setLength(double length) {
        this.length.set(length);
    }

    public void setRemainingLength(double remainingLength) {
        this.remainingLength.set(remainingLength);
    }

    public void setWidth(double width) {
        this.width.set(width);
    }

    public void setRemainingWidth(double remainingWidth) {
        this.remainingWidth.set(remainingWidth);
    }

    public void setThickness(double thickness) {
        this.thickness.set(thickness);
    }

    public void setRemainingThickness(double remainingThickness) {
        this.remainingThickness.set(remainingThickness);
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public void setInitialWeight(double initialWeight) {
        this.initialWeight.set(initialWeight);
    }

    public void setRemainingWeight(double remainingWeight) {
        this.remainingWeight.set(remainingWeight);
    }

    public void setColor(String color) {
        this.color.set(color);
    }

    public void setQty(int qty) {
        this.qty.set(qty);
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice.set(totalPrice);
    }

    public void setHead(String head) {

        this.head.set(head);
    }
}
