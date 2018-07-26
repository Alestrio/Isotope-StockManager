/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.materials;

import javafx.collections.ObservableList;

public class RectangularPiece extends AbsMaterial {

    public RectangularPiece() { }

    public RectangularPiece (double length , double width , double thickness , String type , String color , double remainingLength , double remainingWidth , double remainingThickness, double price, int qty) {
        this.length.set(length);
        this.width.set(width);
        this.thickness.set(thickness);
        this.type.set(type);
        this.color.set(color);
        this.remainingLength.set(remainingLength);
        this.remainingWidth.set(remainingWidth);
        this.remainingThickness.set(remainingThickness);
        this.price.set(price);
        this.priceCm.set(this.price.get()/(this.length.get()/10 * this.width.get()/10 * this.thickness.get()/10));
        this.piecePrice.set(this.remainingLength.get()/10 * this.remainingWidth.get()/10 * this.remainingThickness.get()/10 * this.priceCm.get());
        this.qty.set(qty);
        this.totalPrice.set(this.piecePrice.get()*this.qty.get());
        if(db.getDriverState())
            db.connect();
    }

    @Override
    public void delete() {
        db.dbQuery(String.format("DELETE FROM rectangles WHERE length=%s AND width=%s AND thickness=%s AND type=\'%s\' AND color=\'%s\' AND remaininglength=%s AND " +
                "remainingwidth=%s AND remainingthickness=%s AND price=%s AND pricecm = %s, AND qty=%s", this.length.get(), this.width.get(), this.thickness.get(), this.type.get(), this.color.get(),
                this.remainingLength.get(), this.remainingWidth.get(), this.remainingThickness.get(), this.price.get(),this.priceCm.get(), this.qty.get()));
    }

    @Override
    public void add() {
        db.dbQuery(String.format("INSERT INTO rectangles (length ,width ,thickness ,type ,color ,remaininglength ,remainingwidth ,remainingthickness, price, pricecm, qty)" +
                " VALUES (%s, %s, %s, \'%s\', \'%s\', %s, %s, %s, %s, %s, %s)", this.length.get(), this.width.get(), this.thickness.get(), this.type.get(), this.color.get(),
                this.remainingLength.get(), this.remainingWidth.get(), this.remainingThickness.get(), this.price.get(), this.priceCm.get(), this.qty.get()));
    }

    public boolean isSimilar() {
        ObservableList<RectangularPiece> fsol;
        try {
            fsol = db.getDbEntriesRecPieces();
            for(RectangularPiece f : fsol){
                if(f.equals(this))
                    return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void modify(double length , double width , double thickness , String type , String color , double remainingLength , double remainingWidth , double remainingThickness, double price, double priceCm, int qty) {
        db.dbQuery(String.format("UPDATE rectangles SET length=%s AND width=%s AND thickness=%s AND type=\'%s\' AND color=\'%s\' AND remaininglength=%s AND" +
                "remainingwidth=%s AND remainingthickness=%s AND price=%s AND pricecm=%s AND qty=%s WHERE length=%s AND width=%s AND thickness=%s AND type=\'%s\' AND color=\'%s\' AND remaininglength=%s AND" +
                "remainingwidth=%s AND remainingthickness=%s AND price=%s AND pricecm=%s AND qty=%s",length ,width ,thickness ,type ,color ,remainingLength ,remainingWidth ,remainingThickness,price, priceCm, qty,
                this.length.get(), this.width.get(), this.thickness.get(), this.type.get(), this.color.get(), this.remainingLength.get(), this.remainingWidth.get(),
                this.remainingThickness.get(), this.price.get(), this.priceCm.get(), this.qty.get()));
    }

}
