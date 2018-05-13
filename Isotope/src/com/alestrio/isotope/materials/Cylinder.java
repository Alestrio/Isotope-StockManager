/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;

public
class Cylinder extends AbsMaterial {

    public Cylinder() { }

    public Cylinder (double diameter , double length , String type , String color , int qty , double remainingLength) {
        this.diameter.set(diameter);
        this.length.set(length);
        this.type.set(type);
        this.color.set(color);
        this.qty.set(qty);
        this.remainingLength.set(remainingLength);
    }

    @Override
    public boolean delete() {

        return db.dbQuery("DELETE FROM cylindres WHERE diameter =" + this.diameter.get() + " AND length =" + this.length.get() + " AND type ='" + this.type.get() + "'" +
                "AND color ='" + this.color.get() + "' AND qty = " + this.qty.get() + "AND remaininglength = " + this.remainingLength.get());
    }

    @Override
    public boolean add() {

        return db.dbQuery("INSERT INTO cylindres (diameter, length, color, type, remainingLength, qty)" +
                " VALUES " + this.diameter.get() + ", "+ this.length.get() +", '" +
                 this.color.get() + "' , '" + this.type.get() + "' , " + this.remainingLength.get() + ", " + this.qty.get());
    }

    public boolean modify(double diameter , double length , String type , String color , int qty , double remainingLength) {
        if(diameter == 0)
            diameter = this.diameter.get();
        if(length == 0)
            length = this.length.get();
        if(type == null)
            type = this.type.get();
        if(color == null)
            color = this.color.get();
        if(qty == 0)
            qty = this.qty.get();
        if(remainingLength == 0)
            remainingLength = this.remainingLength.get();

        return db.dbQuery("UPDATE cylindres SET diameter ="+ diameter + ", length="+ length +", type ='" + type + "', color='" + color + "', qty =" + qty +", remaininglength =" + remainingLength +"  WHERE diameter = " + this.diameter.get() + "AND length =" + this.length.get() + "AND type='" + this.type.get() +"'" +
                "AND color= '" + this.color.get() + "AND qty =" + this.qty.get() + " AND remaininglength =" + this.remainingLength.get());
    }

    @Override
    public boolean qtyChange(int newQty) {

        return db.dbQuery("UPDATE cylindres SET qty =" + newQty +" WHERE diameter = " + this.diameter.get() + "AND length =" + this.length.get() + "AND type='" + this.type.get() +"'" +
                "AND color= '" + this.color.get() + "AND qty =" + this.qty.get() + " AND remaininglength =" + this.remainingLength.get());
    }
}
