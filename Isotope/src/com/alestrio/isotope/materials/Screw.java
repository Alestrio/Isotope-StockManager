/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;

import java.util.List;

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
        if(db.getDriverState())
            db.connect();
    }

    @Override
    public boolean delete() {
        return db.dbQuery(String.format("DELETE FROM visserie WHERE diameter = %sAND  length = %sAND type = '%s'AND color = '%s' AND qty =%d AND price =%s", this.diameter.get(), this.length.get(), this.type.get(), this.color.get(), this.qty.get(), this.price.get()));
    }

    @Override
    public boolean add() {
        return db.dbQuery(String.format("INSERT INTO visserie (diameter, length, head, type, color, qty, price) VALUES (%s, %s, '%s', '%s', '%s', %d, %s)", this.diameter.get(), this.length.get(), this.head.get(), this.type.get(), this.color.get(), this.qty.get(), this.price.get()));
    }

    public boolean modify(double diameter ,double length ,String head ,String type ,String color,int qty, double price) {
        return db.dbQuery(String.format("UPDATE visserie SET diameter=%s , length=%s , head=\'%s\' , type=\'%s\' , color=\'%s\' , qty=%d , price=%s WHERE diameter=%s AND length=%s AND head=\'%s\' AND type=\'%s\' AND color=\'%s\' AND qty=%d AND price=%s", diameter, length, head, type, color, qty, price, this.diameter.get(), this.length.get(), this.head.get(), this.type.get(), this.color.get(), this.qty.get(), this.price.get()));
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
