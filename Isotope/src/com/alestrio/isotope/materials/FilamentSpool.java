package com.alestrio.isotope.materials;

import javafx.beans.property.*;

public
class FilamentSpool extends AbsMaterial {

    public FilamentSpool() {
        this.diameter.set(0);
        this.initialWeight.set(0);
        this.remainingWeight.set(0);
        this.type.set(null);
        this.color.set(null);
    }

    public
    FilamentSpool (double a ,double b ,double c ,String d ,String e) {
        this.diameter.set(a);
        this.initialWeight.set(b);
        this.remainingWeight.set(c);
        this.type.set(d);
        this.color.set(e);
    }

}
