/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

public enum PriceCount_type {

    CUBICCM(3),
    SQUARECM(2),
    UNIT(1);

    private int i;

    public int getI() {
        return i;
    }

    PriceCount_type(int i){
        this.i = i;
    }
}
