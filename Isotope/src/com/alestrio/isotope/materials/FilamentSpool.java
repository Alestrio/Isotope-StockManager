/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;

public
class FilamentSpool extends AbsMaterial {

    public FilamentSpool() { }

    public
    FilamentSpool (double a ,double b ,double c ,String d ,String e) {
        this.diameter.set(a);
        this.initialWeight.set(b);
        this.remainingWeight.set(c);
        this.type.set(d);
        this.color.set(e);
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
