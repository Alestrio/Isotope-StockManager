/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;

import java.util.List;

public
class Screw extends AbsMaterial {

    public Screw (double diameter ,double length ,String head ,String type ,String color,int qty, double price) {
        this.diameter.set(diameter);
        this.length.set(length);
        this.head.set(head);
        this.type.set(type);
        this.color.set(color);
        this.qty.set(qty);
        this.price.set(price);
        this.totalPrice.set(qty*price);
        if(db.getDriverState())
            db.connect();
    }

    public Screw (double diameter ,double length ,String head ,String type ,String color,int qty, double price, int id) {
        this.id.set(id);
        this.diameter.set(diameter);
        this.length.set(length);
        this.head.set(head);
        this.type.set(type);
        this.color.set(color);
        this.qty.set(qty);
        this.price.set(price);
        this.totalPrice.set(qty*price);
        if(db.getDriverState())
            db.connect();
    }

    @Override
    public void delete() {
        db.dbQuery(String.format("DELETE FROM visserie WHERE id=%s", this.id.get()));
    }

    @Override
    public void add() {
        db.dbQuery(String.format("INSERT INTO visserie (diameter, length, head, type, color, qty, price) VALUES (%s, %s, '%s', '%s', '%s', %d, %s)", this.diameter.get(), this.length.get(), this.head.get(), this.type.get(), this.color.get(), this.qty.get(), this.price.get()));
    }

    public void modify(double diameter ,double length ,String head ,String type ,String color,int qty, double price) {
        db.dbQuery(String.format("UPDATE visserie SET diameter=%s , length=%s , head=\'%s\' , type=\'%s\' , color=\'%s\' , qty=%d , price=%s WHERE id=%s", diameter, length, head, type, color, qty, price, this.id.get()));
    }

    public boolean isSimilar() {
        List<Screw> screwList = db.getDbEntriesScrew();
        for (Screw f : screwList) {
            if (f.equals(this))
                return true;
        }
        return false;
    }

}
