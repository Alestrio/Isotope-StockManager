/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;

import javafx.beans.property.*;

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

}
