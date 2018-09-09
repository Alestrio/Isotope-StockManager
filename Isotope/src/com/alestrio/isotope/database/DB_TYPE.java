/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

public enum DB_TYPE {

    INTEG("integer"),
    TEXT("text"),
    NUMERIC("numeric"),
    SERIAL("serial");

    private String s;

    DB_TYPE(String s){
        this.s = s;
    }

    String getType(){
        return s;
    }

}
