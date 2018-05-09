/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;

public
class Cylinder extends AbsMaterial {

    public Cylinder() { }

    public Cylinder (double a , double b , String c , String d , int e , double f) {
        this.diameter.set(a);
        this.length.set(b);
        this.type.set(c);
        this.color.set(d);
        this.qty.set(e);
        this.remainingLength.set(f);
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
