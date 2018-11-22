/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DbItemProperty {
    //TODO ça ça va dans materials !!!

    private String name;
    private SimpleIntegerProperty integerProperty;
    private SimpleDoubleProperty doubleProperty;
    private SimpleStringProperty simpleStringProperty;
    private int whichProperty;

    DbItemProperty(String name){
        this.name = name;
    }
    DbItemProperty(String name, int i){
        this(name);
        this.integerProperty.set(i);
        this.whichProperty = 1;
    }
    DbItemProperty(String name, double d){
        this(name);
        this.doubleProperty.set(d);
        this.whichProperty = 2;
    }
    DbItemProperty(String name, String s){
        this(name);
        this.simpleStringProperty.set(s);
        this.whichProperty = 3;
    }

    public Object getProperty(){
        switch (whichProperty){
            case(1):
                return integerProperty;
            case(2):
                return doubleProperty;
            case(3):
                return simpleStringProperty;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setIntegerProperty(int integerProperty) {
        this.integerProperty.set(integerProperty);
    }

    public void setDoubleProperty(double doubleProperty) {
        this.doubleProperty.set(doubleProperty);
    }

    public void setSimpleStringProperty(String simpleStringProperty) {
        this.simpleStringProperty.set(simpleStringProperty);
    }
}
