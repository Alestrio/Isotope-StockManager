/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;

import java.sql.SQLException;
import java.util.List;

public class Screw extends AbsMaterial {

    public Screw(double diameter, double length, String head, String type, String color, int qty, double price) {
        this.diameter.set(diameter);
        this.length.set(length);
        this.head.set(head);
        this.type.set(type);
        this.color.set(color);
        this.qty.set(qty);
        this.price.set(price);
    }

    public Screw(double diameter, double length, String head, String type, String color, int qty, double price, int id) {
        this.id.set(id);
        this.diameter.set(diameter);
        this.length.set(length);
        this.head.set(head);
        this.type.set(type);
        this.color.set(color);
        this.qty.set(qty);
        this.price.set(price);
        this.totalPrice.set(qty * price);
    }

    @Override
    public void delete() {
        db.connect();
        try {
            db.dbQuery(String.format("DELETE FROM \".visserie\" WHERE id=%s", this.id.get()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }

    @Override
    public void add() {
        db.connect();
        try {
            db.dbQuery(String.format("INSERT INTO \"visserie\" (diameter, length, head, type, color, qty, price) VALUES (%s, %s, '%s', '%s', '%s', %d, %s)", this.diameter.get(), this.length.get(), this.head.get(), this.type.get(), this.color.get(), this.qty.get(), this.price.get()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }

    public void modify(double diameter, double length, String head, String type, String color, int qty, double price) {
        db.connect();
        try {
            db.dbQuery(String.format("UPDATE \"visserie\" SET diameter=%s , length=%s , head=\'%s\' , type=\'%s\' , color=\'%s\' , qty=%d , price=%s WHERE id=%s", diameter, length, head, type, color, qty, price, this.id.get()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }

    public void modify(int qty) {
        db.connect();
        try {
            db.dbQuery(String.format("UPDATE \"visserie\" SET qty=%s WHERE id=%s", qty, this.id.get()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.connect();
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
