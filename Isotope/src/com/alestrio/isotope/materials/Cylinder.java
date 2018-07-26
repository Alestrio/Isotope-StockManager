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

    public Cylinder (double diameter , double length , String type , String color , double price , double remainingLength) {
        this.diameter.set(diameter);
        this.length.set(length);
        this.type.set(type);
        this.color.set(color);
        this.price.set(price);
        this.remainingLength.set(remainingLength);
        this.totalPrice.set(price*2*Math.PI*(diameter/2)*remainingLength);
        if(db.getDriverState())
            db.connect();
    }

    @Override
    public void delete() {

        db.dbQuery("DELETE FROM cylindres WHERE diameter =" + this.diameter.get() + " AND length =" + this.length.get() + " AND type ='" + this.type.get() + "'" +
                "AND color ='" + this.color.get() + "' AND price = " + this.price.get() + "AND remaininglength = " + this.remainingLength.get());
    }

    @Override
    public void add() {
        db.dbQuery(String.format("INSERT INTO cylindres (diameter, length, color, type, remainingLength, price) VALUES (%s, %s, \'%s\' , \'%s\' , %s, %s)", this.diameter.get(), this.length.get(), this.color.get(), this.type.get(), this.remainingLength.get(), this.price.get()));
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


    public void modify(double diameter , double length , String type , String color , int qty , double remainingLength) {
        db.dbQuery("UPDATE cylindres SET diameter ="+ diameter + ", length="+ length +", type ='" + type + "', color='" + color + "', price =" + price +", remaininglength =" + remainingLength +"  WHERE diameter = " + this.diameter.get() + "AND length =" + this.length.get() + "AND type='" + this.type.get() +"'" +
                "AND color= '" + this.color.get() + "AND price =" + this.qty.get() + " AND remaininglength =" + this.remainingLength.get());
    }


}
