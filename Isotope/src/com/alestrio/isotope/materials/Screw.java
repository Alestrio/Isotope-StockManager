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
    public boolean delete() {
        return db.dbQuery(String.format("DELETE FROM visserie WHERE diameter = %sAND  length = %sAND type = '%s'AND color = '%s' AND qty =%d AND price =%s", this.diameter.get(), this.length.get(), this.type.get(), this.color.get(), this.qty.get(), this.price.get()));
    }

    @Override
    public boolean add() {
        return db.dbQuery(String.format("INSERT INTO visserie (diameter, length, head, type, color, qty, price) VALUES (%s, %s, '%s', '%s', '%s', %d, %s)", this.diameter.get(), this.length.get(), this.head.get(), this.type.get(), this.color.get(), this.qty.get(), this.price.get()));
    }

    public boolean modify(double diameter ,double length ,String head ,String type ,String color,int qty, double price) {
        return db.dbQuery(String.format("UPDATE visserie SET diameter= +%s, length= %s , head= %s , type=%s , color=%s , qty=%d , price=%s WHERE diameter= %s , length=%s , head=%s , type= %s , color=%s , qty=%d , price=%s", diameter, length, head, type, color, qty, price, this.diameter.get(), this.length.get(), this.head.get(), this.head.get(), this.color.get(), this.qty.get(), this.price.get()));
    }

    @Override
    public boolean qtyChange() {
        return db.dbQuery(String.format("UPDATE visserie SET qty = %d WHERE diameter =%s AND length = %sAND head = '%s' AND type = '%s' AND color = '%s' AND price =%s", this.qty.get(), this.diameter.get(), this.length.get(), this.head.get(), this.type.get(), this.color.get(), this.price.get()));
    }
}
