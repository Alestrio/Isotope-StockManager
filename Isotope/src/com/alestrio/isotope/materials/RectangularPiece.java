/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;

public
class RectangularPiece extends AbsMaterial {

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

        return false;
    }

    @Override
    public boolean add() {

        return false;
    }

    public void modify() {

    }

    @Override
    public boolean qtyChange() {

        return false;
    }
}
