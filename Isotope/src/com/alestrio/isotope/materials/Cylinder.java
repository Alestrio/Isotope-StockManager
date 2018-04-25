package com.alestrio.isotope.materials;

import javafx.beans.property.*;

public
class Cylinder extends AbsMaterial {

    public Cylinder() {
        this.diameter.set(0);
        this.length.set(0);
        this.type.set(null);
        this.color.set(null);
        this.qty.set(0);
        this.remainingLength.set(0);
    }

    public Cylinder (double a , double b , String c , String d , int e , double f) {
        this.diameter.set(a);
        this.length.set(b);
        this.type.set(c);
        this.color.set(d);
        this.qty.set(e);
        this.remainingLength.set(f);
    }

}
