package com.alestrio.isotope.materials;

import com.alestrio.isotope.database.Database;

public class DBItem extends AbsMaterial{
    public Database db;

    public DBItem(Database db) {
        this.db = db;
    }

    @Override
    public void delete() {
        String query = "DELETE FROM " + db.getName() + " WHERE id=" + this.id.get() + ", ";
        if(this.head.get() != null)
            query.concat("head='" + this.head.get()+"' ");
        if(this.diameter.get() != 0)
            query.concat("diameter=" + diameter.get() + " ");
        if(this.length.get() != 0)
            query.concat("length=" + length.get() + " ");
        if(this.remainingLength.get() != 0)
            query.concat("remaininglength=" + this.remainingLength.get() + " ");
        if(this.width.get() != 0)
            query.concat("width=" + this.width.get() + " ");
        if(this.remainingWidth.get() != 0)
            query.concat("remainingwidth=" + this.remainingWidth.get() + " ");
        if(this.thickness.get() != 0)
            query.concat("thickness=" + this.thickness.get() + " ");
        if(this.remainingThickness.get() != 0)
            query.concat("remainingthickness=" + this.remainingThickness.get() + " ");
        if(this.type.get() != null)
            query.concat("type=" + this.type.get() + " ");
        if(this.initialWeight.get() != 0)
            query.concat("initialweight=" + this.initialWeight.get() + " ");
        if(this.remainingWeight.get() != 0)
            query.concat("remainingweight=" + this.remainingWeight.get() + " ");
        if(this.color.get() != null)
            query.concat("color=" + this.color.get() + " ");
        if(this.qty.get() != 0)
            query.concat("qty=" + this.qty.get() + " ");
        if(this.priceCm.get() != 0)
            query.concat("pricecm=" + this.priceCm.get() + " ");
        if(this.price.get() != 0)
            query.concat("price=" + this.price.get() + " ");

        //TODO finish this object
    }

    @Override
    public void add() {

    }

    @Override
    public boolean isSimilar() {
        return false;
    }
}
