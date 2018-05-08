/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;

public
class Screw extends AbsMaterial {

    public Screw(){ }

    public Screw (double diameter ,double length ,String head ,String type ,String color,int qty, double price) {
        this.diameter.set(diameter);
        this.length.set(length);
        this.head.set(head);
        this.type.set(type);
        this.color.set(color);
        this.qty.set(qty);
        this.price.set(price);
        this.totalPrice.set(qty*price);
    }

    @Override
    public void delete() {
        db.dbQuery("DELETE FROM visserie WHERE diameter = " + this.diameter+"AND  length = " + this.length + "AND type = '" +this.type+"'AND color = '" + this.color+
                "' AND qty =" +this.qty+" AND price =" +this.price);
    }

    @Override
    public void add() {
        db.dbQuery("INSERT INTO visserie (diameter, length, head, type, color, qty, price) VALUES (" + this.diameter + ", " + this.length + ", '" + this.head + "', '" + this.type + "', '" + this.color + "', " + this.qty + ", "+this.price+")");
    }

    @Override
    public void modify() {

    }

    @Override
    public void qtyChange() {
        db.dbQuery("UPDATE visserie SET qty = "+ this.qty +" WHERE diameter =" + this.diameter + " AND length = " + this.length + "AND head = '" + this.head + "' AND type = '" +this.type+"' AND color = '" + this.color + "' AND price =" + this.price);
    }
}
