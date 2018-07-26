/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;

import javafx.collections.ObservableList;

public
class FilamentSpool extends AbsMaterial {

    public FilamentSpool (double diameter ,double initialWeight ,double remainingWeight ,String type ,String color, int qty, double price) {
        this.diameter.set(diameter);
        this.initialWeight.set(initialWeight);
        this.remainingWeight.set(remainingWeight);
        this.type.set(type);
        this.color.set(color);
        this.qty.set(qty);
        this.price.set(price);
        //price/g in this case
        this.priceCm.set(this.price.get()/this.initialWeight.get());
        this.piecePrice.set(this.priceCm.get()*this.remainingWeight.get());
        this.totalPrice.set(this.piecePrice.get()*this.qty.get());
        if(db.getDriverState())
            db.connect();
    }

    public FilamentSpool (double diameter ,double initialWeight ,double remainingWeight ,String type ,String color, int qty, double price, int id) {
        this.id.set(id);
        this.diameter.set(diameter);
        this.initialWeight.set(initialWeight);
        this.remainingWeight.set(remainingWeight);
        this.type.set(type);
        this.color.set(color);
        this.qty.set(qty);
        this.price.set(price);
        //price/g in this case
        this.priceCm.set(this.price.get()/this.initialWeight.get());
        this.piecePrice.set(this.priceCm.get()*this.remainingWeight.get());
        this.totalPrice.set(this.piecePrice.get()*this.qty.get());
        if(db.getDriverState())
            db.connect();
    }

    @Override
    public void delete() {
        db.dbQuery(String.format("DELETE FROM bobines WHERE diameter =%s AND initialweight =%sAND remainingweight =%s AND type ='%s' AND color='%s' AND qty=%s AND price=%s AND pricecm=%s", this.diameter.get(), this.initialWeight.get(), this.remainingWeight.get(), this.type.get(), this.color.get(), this.qty.get(), this.price.get(), this.priceCm.get()));
    }

    @Override
    public void add() {
        db.dbQuery(String.format("INSERT INTO bobines (diameter, initialweight, remainingweight, type, color, qty, price, pricecm) VALUES (%s, %s, %s, \'%s\', \'%s\', %s, %s, %s)", this.diameter.get(), this.initialWeight.get(), this.remainingWeight.get(), this.type.get(), this.color.get(), this.qty.get(), this.price.get(), this.priceCm.get()));
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


    public void modify(double diameter ,double initialWeight ,double remainingWeight ,String type ,String color, int qty, double price) {
        db.dbQuery(String.format("UPDATE bobines SET diameter = %s, initialweight = %s, remainingweight = %s, type = %s, color = %s, qty=%s, price=%s, WHERE diameter = %s, initialweight = %s," +
                ", remainingweight = %s, type = %s, color = %s, qty=%s, price=%s, pricecm=%s", diameter, initialWeight, remainingWeight, type, color, qty, price, this.diameter.get(), this.initialWeight.get(), this.remainingWeight.get(), this.type.get(), this.color.get(), this.qty.get(), this.price.get(), this.priceCm.get()));
    }

}
