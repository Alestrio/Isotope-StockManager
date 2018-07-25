/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;

public class RectangularPiece extends AbsMaterial {

    public RectangularPiece() { }

    public RectangularPiece (double length , double width , double thickness , String type , String color , double remainingLength , double remainingWidth , double remainingThickness, double price) {
        this.length.set(length);
        this.width.set(width);
        this.thickness.set(thickness);
        this.type.set(type);
        this.color.set(color);
        this.remainingLength.set(remainingLength);
        this.remainingWidth.set(remainingWidth);
        this.remainingThickness.set(remainingThickness);
        this.price.set(price);
        this.totalPrice.set((this.remainingLength.get() * this.remainingWidth.get() * this.remainingThickness.get())/1000 * this.price.get());
    }

    @Override
    public boolean delete() {

        return db.dbQuery(String.format("DELETE FROM rectangles WHERE length=%s AND width=%s AND thickness=%s AND type=%s AND color=%s AND remaininglength=%s AND " +
                "remainingwidth=%s AND remainingthickness=%s AND price=%s", this.length.get(), this.width.get(), this.thickness.get(), this.type.get(), this.color.get(),
                this.remainingLength.get(), this.remainingWidth.get(), this.remainingThickness.get(), this.price.get()));
    }

    @Override
    public boolean add() {

        return db.dbQuery(String.format("INSERT INTO rectangles (length ,width ,thickness ,type ,color ,remaininglength ,remainingwidth ,remainingthickness, price)" +
                " VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s)", this.length.get(), this.width.get(), this.thickness.get(), this.type.get(), this.color.get(),
                this.remainingLength.get(), this.remainingWidth.get(), this.remainingThickness.get(), this.price.get() ));
    }

    @Override
    public boolean isSimilar() {
        return false;
    }

    public boolean modify(double length , double width , double thickness , String type , String color , double remainingLength , double remainingWidth , double remainingThickness, double price) {
        return db.dbQuery(String.format("UPDATE rectangles SET length=%s AND width=%s AND thickness=%s AND type=%s AND color=%s AND remaininglength=%s AND" +
                "remainingwidth=%s AND remainingthickness=%s AND price=%s WHERE length=%s AND width=%s AND thickness=%s AND type=%s AND color=%s AND remaininglength=%s AND" +
                "remainingwidth=%s AND remainingthickness=%s AND price=%s",length ,width ,thickness ,type ,color ,remainingLength ,remainingWidth ,remainingThickness,price,
                this.length.get(), this.width.get(), this.thickness.get(), this.type.get(), this.color.get(), this.remainingLength.get(), this.remainingWidth.get(),
                this.remainingThickness.get(), this.price.get()));
    }

}
