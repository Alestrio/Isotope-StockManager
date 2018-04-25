package com.alestrio.isotope.materials;

import javafx.beans.property.*;

public
class RectangularPiece extends AbsMaterial {

    public RectangularPiece() {
        this.length.set(0);
        this.width.set(0);
        this.thickness.set(0);
        this.type.set(null);
        this.color.set(null);
        this.remainingLength.set(0);
        this.remainingWidth.set(0);
        this.remainingThickness.set(0);
        this.price.set(0);
    }

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
    }

}
