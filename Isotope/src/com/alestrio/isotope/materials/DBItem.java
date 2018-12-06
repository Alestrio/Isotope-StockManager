package com.alestrio.isotope.materials;

import com.alestrio.isotope.database.Database;

import java.sql.SQLException;

public class DBItem extends AbsMaterial{
    public Database database;

    public DBItem(Database database) {
        this.database = database;
    }

    @Override
    public void delete() {
        String query = "DELETE FROM " + database.getName() + " WHERE id=" + this.id.get();

        try {
            this.db.dbQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add() {
        String query = "INSERT INTO " + database.getName() + " (";

        //columns names
        if(this.head.get() != null)
            query.concat("head, ");
        if(this.diameter.get() != 0)
            query.concat("diameter, ");
        if(this.length.get() != 0)
            query.concat("length, ");
        if(this.remainingLength.get() != 0)
            query.concat("remaininglength, ");
        if(this.width.get() != 0)
            query.concat("width, ");
        if(this.remainingWidth.get() != 0)
            query.concat("remainingwidth, ");
        if(this.thickness.get() != 0)
            query.concat("thickness, ");
        if(this.remainingThickness.get() != 0)
            query.concat("remainingthickness, ");
        if(this.type.get() != null)
            query.concat("type, ");
        if(this.initialWeight.get() != 0)
            query.concat("initialweight, ");
        if(this.remainingWeight.get() != 0)
            query.concat("remainingweight," );
        if(this.color.get() != null)
            query.concat("color, ");
        if(this.qty.get() != 0)
            query.concat("qty, ");
        if(this.priceCm.get() != 0)
            query.concat("pricecm, ");
        if(this.price.get() != 0)
            query.concat("price, ");
        query = query.substring(0, query.length()-1);
        query.concat(") VALUES (" );

        //values
        if(this.head.get() != null)
            query.concat(this.head.get() + ", ");
        if(this.diameter.get() != 0)
            query.concat(this.diameter.get() + ", ");
        if(this.length.get() != 0)
            query.concat(this.length.get() + ", ");
        if(this.remainingLength.get() != 0)
            query.concat(this.remainingLength.get() + ", ");
        if(this.width.get() != 0)
            query.concat(this.width.get() + ", ");
        if(this.remainingWidth.get() != 0)
            query.concat(this.remainingWidth.get() + ", ");
        if(this.thickness.get() != 0)
            query.concat(this.thickness.get() + ", ");
        if(this.remainingThickness.get() != 0)
            query.concat(this.remainingThickness.get() + ", ");
        if(this.type.get() != null)
            query.concat(this.type.get() + ", ");
        if(this.initialWeight.get() != 0)
            query.concat(this.initialWeight.get() + ", ");
        if(this.remainingWeight.get() != 0)
            query.concat(this.remainingWeight.get() + ", ");
        if(this.color.get() != null)
            query.concat(this.color.get() + ", ");
        if(this.qty.get() != 0)
            query.concat(this.qty.get() + ", ");
        if(this.priceCm.get() != 0)
            query.concat(this.priceCm.get() + ", ");
        if(this.price.get() != 0)
            query.concat(this.price.get() + ", ");
        query = query.substring(0, query.length()-1);

        System.out.println(
                query
        );
        try {
            db.dbQuery(""/*query*/);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean isSimilar() {
        return false;
    }
}
