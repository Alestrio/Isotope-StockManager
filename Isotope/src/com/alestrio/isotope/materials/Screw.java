package com.alestrio.isotope.materials;

import javafx.beans.property.*;

public
class Screw extends AbsMaterial {

    public Screw(){
        this.diameter.set(0);
        this.length.set(0);
        this.head.set(null);
        this.type.set(null);
        this.color.set(null);
        this.qty.set(0);
        this.price.set(0);
        this.totalPrice.set(0);
    }

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
