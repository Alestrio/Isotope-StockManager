/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;

import com.alestrio.isotope.DB;
import javafx.beans.property.*;

public abstract class AbsMaterial {

    protected SimpleIntegerProperty id = new SimpleIntegerProperty(0);
    protected SimpleStringProperty head = new SimpleStringProperty(null);
    protected SimpleDoubleProperty diameter = new SimpleDoubleProperty(0);
    protected SimpleDoubleProperty length = new SimpleDoubleProperty(0);
    protected SimpleDoubleProperty remainingLength = new SimpleDoubleProperty(0);
    protected SimpleDoubleProperty width = new SimpleDoubleProperty(0);
    protected SimpleDoubleProperty remainingWidth = new SimpleDoubleProperty(0);
    protected SimpleDoubleProperty thickness = new SimpleDoubleProperty(0);
    protected SimpleDoubleProperty remainingThickness = new SimpleDoubleProperty(0);
    protected SimpleStringProperty type = new SimpleStringProperty(null);
    protected SimpleDoubleProperty initialWeight = new SimpleDoubleProperty(0);
    protected SimpleDoubleProperty remainingWeight = new SimpleDoubleProperty(0);
    protected SimpleStringProperty color = new SimpleStringProperty(null);
    protected SimpleIntegerProperty qty = new SimpleIntegerProperty(0);
    protected SimpleDoubleProperty price = new SimpleDoubleProperty(0);
    protected SimpleDoubleProperty priceCm = new SimpleDoubleProperty(0);
    protected SimpleDoubleProperty totalPrice = new SimpleDoubleProperty(0);
    protected SimpleDoubleProperty piecePrice = new SimpleDoubleProperty(0);
    DB db = new DB();


    void AbsMaterial(){
        db.connect();
    }
    //Screws
    public String getHead() {
        return this.head.get();
    }

    public void setHead(String head) {
        this.head.set(head);
    }

    public StringProperty getHeadProperty() {
        return this.head;
    }

    //Tubes or cylinders / screws
    public double getDiameter() {
        return this.diameter.get();
    }

    public void setDiameter(double diameter) {
        this.diameter.set(diameter);
    }

    public DoubleProperty getDiameterProperty() {
        return this.diameter;
    }

    public double getLength() {
        return this.length.get();
    }

    public void setLength(double length) {
        this.length.set(length);
    }

    public DoubleProperty getLengthProperty() {
        return this.length;
    }

    public double getRemainingLength() {
        return this.remainingLength.get();
    }

    public void setRemainingLength(double remainingLength) {
        this.remainingLength.set(remainingLength);
    }

    public DoubleProperty getRemainingLengthProperty() {
        return this.remainingLength;
    }

    //Rectangular pieces
    public double getWidth() {
        return this.width.get();
    }

    public void setWidth(double width) {
        this.width.set(width);
    }

    public DoubleProperty getWidthProperty() {
        return this.width;
    }

    public double getRemainingWidth() {
        return this.remainingWidth.get();
    }

    public void setRemainingWidth(double remainingWidth) {
        this.remainingWidth.set(remainingWidth);
    }

    public DoubleProperty getRemainingWidthProperty() {
        return this.width;
    }

    public double getThickness() {
        return this.thickness.get();
    }

    public void setThickness(double thickness) {
        this.thickness.set(thickness);
    }

    public DoubleProperty getThicknessProperty() {
        return this.thickness;
    }

    public double getRemainingThickness() {
        return this.remainingThickness.get();
    }

    public void setRemainingThickness(double remainingThickness) {
        this.remainingThickness.set(remainingThickness);
    }

    public DoubleProperty getRemainingThicknessProperty() {
        return this.remainingThickness;
    }

    //3D printers spools
    public String getType() {
        return this.type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public StringProperty getTypeProperty() {
        return this.type;
    }

    public double getRemainingWeight() {
        return this.remainingWeight.get();
    }

    public void setRemainingWeight(double remainingWeight) {
        this.remainingWeight.set(remainingWeight);
    }

    public DoubleProperty getRemainingWeightProperty() {
        return this.remainingWeight;
    }

    public double getInitialWeight() {
        return this.initialWeight.get();
    }

    public void setInitialWeight(double initialWeight) {
        this.initialWeight.set(initialWeight);
    }

    public DoubleProperty getInitialWeightProperty() {
        return this.initialWeight;
    }

    public String getColor() {
        return this.color.get();
    }

    public void setColor(String color) {
        this.color.set(color);
    }

    public StringProperty getColorProperty() {
        return this.color;
    }

    public int getQty() {
        return this.qty.get();
    }

    public void setQty(int qty) {
        this.qty.set(qty);
    }

    public IntegerProperty getQtyProperty() {
        return this.qty;
    }

    public double getPrice() {
        return this.price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public DoubleProperty getPriceProperty() {
        return this.price;
    }

    public double getTotalPrice() {
        return this.totalPrice.get();
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice.set(totalPrice);
    }

    public DoubleProperty getTotalPriceProperty() {
        return this.totalPrice;
    }

    public abstract void delete();

    public abstract boolean isSimilar();

    public double getPriceCm() {
        return priceCm.get();
    }

    public void setPriceCm(double priceCm) {
        this.priceCm.set(priceCm);
    }

    public SimpleDoubleProperty priceCmProperty() {
        return priceCm;
    }

    public DB getDb() {
        return db;
    }

}