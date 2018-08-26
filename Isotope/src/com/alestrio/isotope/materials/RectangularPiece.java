/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;

import javafx.collections.ObservableList;

import java.sql.SQLException;

public class RectangularPiece extends AbsMaterial {

    public RectangularPiece(double length, double width, double thickness, String type, String color, double remainingLength, double remainingWidth, double remainingThickness, double price, int qty) {
        this.length.set(length);
        this.width.set(width);
        this.thickness.set(thickness);
        this.type.set(type);
        this.color.set(color);
        this.remainingLength.set(remainingLength);
        this.remainingWidth.set(remainingWidth);
        this.remainingThickness.set(remainingThickness);
        this.price.set(price);
        this.priceCm.set(this.price.get() / (this.length.get() / 10 * this.width.get() / 10 * this.thickness.get() / 10));
        this.piecePrice.set(this.remainingLength.get() / 10 * this.remainingWidth.get() / 10 * this.remainingThickness.get() / 10 * this.priceCm.get());
        this.qty.set(qty);
        this.totalPrice.set(this.piecePrice.get() * this.qty.get());
    }

    public RectangularPiece(double length, double width, double thickness, String type, String color, double remainingLength, double remainingWidth, double remainingThickness, double price, int qty, int id) {
        this.id.set(id);
        this.length.set(length);
        this.width.set(width);
        this.thickness.set(thickness);
        this.type.set(type);
        this.color.set(color);
        this.remainingLength.set(remainingLength);
        this.remainingWidth.set(remainingWidth);
        this.remainingThickness.set(remainingThickness);
        this.price.set(price);
        this.priceCm.set(this.price.get() / (this.length.get() / 10 * this.width.get() / 10 * this.thickness.get() / 10));
        this.piecePrice.set(this.remainingLength.get() / 10 * this.remainingWidth.get() / 10 * this.remainingThickness.get() / 10 * this.priceCm.get());
        this.qty.set(qty);
        this.totalPrice.set(this.piecePrice.get() * this.qty.get());
    }

    @Override
    public void delete() {
        db.connect();
        try {
            db.dbQuery(String.format("DELETE FROM \"rectangles\" WHERE id=%s", this.id.get()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }

    @Override
    public void add() {
        db.connect();
        try {
            db.dbQuery(String.format("INSERT INTO \"rectangles\" (length ,width ,thickness ,type ,color ,remaininglength ,remainingwidth ,remainingthickness, price, pricecm, qty)" +
                            " VALUES (%s, %s, %s, \'%s\', \'%s\', %s, %s, %s, %s, %s, %s)", this.length.get(), this.width.get(), this.thickness.get(), this.type.get(), this.color.get(),
                    this.remainingLength.get(), this.remainingWidth.get(), this.remainingThickness.get(), this.price.get(), this.priceCm.get(), this.qty.get()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }

    public boolean isSimilar() {
        ObservableList<RectangularPiece> fsol;
        try {
            fsol = db.getDbEntriesRecPieces();
            for (RectangularPiece f : fsol) {
                if (f.equals(this))
                    return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public void modify(double length, double width, double thickness, String type, String color, double remainingLength, double remainingWidth, double remainingThickness, double price, int qty) {
        this.priceCm.set(price / (length / 10 * width / 10 * thickness / 10));
        db.connect();
        try {
            db.dbQuery(String.format("UPDATE \"rectangles\" SET length=%s, width=%s, thickness=%s, type=\'%s\', color=\'%s\', remaininglength=%s, " +
                    "remainingwidth=%s, remainingthickness=%s, price=%s, pricecm=%s, qty=%s WHERE id=%s", length, width, thickness, type, color, remainingLength, remainingWidth, remainingThickness, price, this.priceCm.get(), qty, this.id.get()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }

}
