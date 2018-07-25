/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;

import javafx.collections.ObservableList;

public
class FilamentSpool extends AbsMaterial {

    public FilamentSpool() { }

    public FilamentSpool (double diameter ,double initialWeight ,double remainingWeight ,String type ,String color) {
        this.diameter.set(diameter);
        this.initialWeight.set(initialWeight);
        this.remainingWeight.set(remainingWeight);
        this.type.set(type);
        this.color.set(color);
    }

    @Override
    public boolean delete() {
        return db.dbQuery("DELETE FROM bobines WHERE diameter =" + this.diameter.get() + " AND initialweight =" + this.initialWeight.get() + "AND remainingweight =" +
                this.remainingWeight.get() + "AND type ='" + this.type.get() + "' AND color='" + this.color.get() + "'");
    }

    @Override
    public boolean add() {
        return db.dbQuery(String.format("INSERT INTO bobines (diameter, initialweight, remainingweight, type, color) VALUES (%s, %s, %s, %s, %s)", this.diameter.get(), this.initialWeight.get(), this.remainingWeight.get(), this.type.get(), this.color.get()));
    }

    public boolean isSimilar() {
            ObservableList<FilamentSpool> fsol;
        try {
            fsol = db.getDbEntriesSpool();
            for(FilamentSpool f : fsol){
                if(f.equals(this))
                    return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public boolean modify(double diameter ,double initialWeight ,double remainingWeight ,String type ,String color) {
        return db.dbQuery(String.format("UPDATE bobines SET diameter = %s, initialweight = %s, remainingweight = %s, type = %s, color = %s WHERE diameter = %s, initialweight = %s," +
                ", remainingweight = %s, type = %s, color = %s", diameter, initialWeight, remainingWeight, type, color, this.diameter.get(), this.initialWeight.get(), this.remainingWeight.get(), this.type.get(), this.color.get()));
    }

}
