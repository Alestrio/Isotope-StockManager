/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;


import javafx.collections.ObservableList;

public
class Cylinder extends AbsMaterial {

    public Cylinder() { }

    public Cylinder (double diameter , double length , String type , String color , double price , double remainingLength, int qty) {
        this.diameter.set(diameter);
        this.length.set(length);
        this.type.set(type);
        this.color.set(color);
        this.price.set(price);
        this.remainingLength.set(remainingLength);
        this.priceCm.set(this.price.get()/(Math.PI*(this.diameter.get()/2/10)*this.length.get()/10));
        this.piecePrice.set(priceCm.get()*2*Math.PI*(this.diameter.get()/2/10)*this.remainingLength.get()/10);
        this.qty.set(qty);
        this.totalPrice.set(this.piecePrice.get()*this.qty.get());
        if(db.getDriverState())
            db.connect();
    }

    @Override
    public void delete() {

        db.dbQuery(String.format("DELETE FROM cylindres WHERE diameter =%s AND length =%s AND type ='%s'AND color ='%s' AND price = %s AND pricecm =%s AND remaininglength = %s AND qty = %s", this.diameter.get(), this.length.get(), this.type.get(), this.color.get(), this.price.get(), this.priceCm.get(), this.remainingLength.get(), this.qty.get()));
    }

    @Override
    public void add() {
        db.dbQuery(String.format("INSERT INTO cylindres (diameter, length, color, type, remainingLength, price, qty, pricecm) VALUES (%s, %s, \'%s\' , \'%s\' , %s, %s, %s, %s)", this.diameter.get(), this.length.get(), this.color.get(), this.type.get(), this.remainingLength.get(), this.price.get(), this.qty.get(), this.priceCm.get()));
    }

    @Override
    public boolean isSimilar() {
        ObservableList<Cylinder> fsol;
        try {
            fsol = db.getDbEntriesCylinders();
            for(Cylinder f : fsol){
                if(f.equals(this))
                    return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public void modify(double diameter, double length, String type, String color, double remainingLength, int qty, double price) {
        db.dbQuery(String.format("UPDATE cylindres SET diameter =%s, length=%s, type ='%s', color='%s', price =%s, remaininglength =%s, qty=%s  WHERE diameter = %sAND length =%sAND type='%s'AND color= '%sAND price =%d AND remaininglength =%s AND qty = %s AND pricecm =%s", diameter, length, type, color, price, remainingLength, qty, this.diameter.get(), this.length.get(), this.type.get(), this.color.get(), this.qty.get(), this.remainingLength.get(), this.qty.get(), this.priceCm.get()));
    }


}
