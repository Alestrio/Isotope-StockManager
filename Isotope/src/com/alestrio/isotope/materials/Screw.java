package com.alestrio.isotope.materials;

import javafx.beans.property.*;

public
class Screw extends AbsMaterial {

    public Screw(){ }

    public Screw (double diameter ,double length ,String head ,String type ,String color,int qty, double price) {
        this.diameter.set(diameter);
        this.length.set(length);
        this.head.set(head);
        this.type.set(type);
        this.color.set(color);
        this.qty.set(qty);
        this.price.set(price);
        this.totalPrice.set(qty*price);
    }

}
