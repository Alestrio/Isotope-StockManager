package com.alestrio.isotope.materials;

import com.alestrio.isotope.database.Database;
import com.alestrio.isotope.database.PriceCount_type;

import java.sql.SQLException;

import static com.alestrio.isotope.database.PriceCount_type.CUBICCM;
import static com.alestrio.isotope.database.PriceCount_type.SQUARECM;
import static com.alestrio.isotope.database.PriceCount_type.UNIT;

public class DBItem extends AbsMaterial{
    public Database database;

    public DBItem(Database database) {
        db.connect();
        this.database = database;


    }

    @Override
    public void delete() {
        String query = "DELETE FROM " + database.getName().toLowerCase() + " WHERE id=" + this.id.get();

        try {
            System.out.println(query);
            this.db.dbQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add() {
        String query = "INSERT INTO " + database.getName().toLowerCase() + " (";

        //columns names
        if(this.head.get() != null)
            query = query.concat("head, ");
        if(this.diameter.get() != 0)
            query = query.concat("diameter, ");
        if(this.length.get() != 0)
            query = query.concat("length, ");
        if(this.remainingLength.get() != 0)
            query = query.concat("remaininglength, ");
        if(this.width.get() != 0)
            query = query.concat("width, ");
        if(this.remainingWidth.get() != 0)
            query = query.concat("remainingwidth, ");
        if(this.thickness.get() != 0)
            query = query.concat("thickness, ");
        if(this.remainingThickness.get() != 0)
            query = query.concat("remainingthickness, ");
        if(this.type.get() != null)
            query = query.concat("type, ");
        if(this.initialWeight.get() != 0)
            query = query.concat("initialweight, ");
        if(this.remainingWeight.get() != 0)
            query = query.concat("remainingweight," );
        if(this.color.get() != null)
            query = query.concat("color, ");
        if(this.qty.get() != 0)
            query = query.concat("qty, ");
        if(this.priceCm.get() != 0)
            query = query.concat("pricecm, ");
        if(this.price.get() != 0)
            query = query.concat("price, ");
        query = query.substring(0, query.length()-2);
        query = query.concat(") VALUES (" );

        //values
        if(this.head.get() != null)
            query = query.concat("'" +this.head.get() + "', ");
        if(this.diameter.get() != 0)
            query = query.concat(this.diameter.get() + ", ");
        if(this.length.get() != 0)
            query = query.concat(this.length.get() + ", ");
        if(this.remainingLength.get() != 0)
            query = query.concat(this.remainingLength.get() + ", ");
        if(this.width.get() != 0)
            query = query.concat(this.width.get() + ", ");
        if(this.remainingWidth.get() != 0)
            query = query.concat(this.remainingWidth.get() + ", ");
        if(this.thickness.get() != 0)
            query = query.concat(this.thickness.get() + ", ");
        if(this.remainingThickness.get() != 0)
            query = query.concat(this.remainingThickness.get() + ", ");
        if(this.type.get() != null)
            query = query.concat("'" +this.type.get() + "', ");
        if(this.initialWeight.get() != 0)
            query = query.concat(this.initialWeight.get() + ", ");
        if(this.remainingWeight.get() != 0)
            query = query.concat(this.remainingWeight.get() + ", ");
        if(this.color.get() != null)
            query = query.concat("'" + this.color.get() + "', ");
        if(this.qty.get() != 0)
            query = query.concat(this.qty.get() + ", ");
        if(this.priceCm.get() != 0)
            query = query.concat(this.priceCm.get() + ", ");
        if(this.price.get() != 0)
            query = query.concat(this.price.get() + ", ");
        query = query.substring(0, query.length()-2);
        query = query.concat(")");

        System.out.println(
                query
        );
        try {
            db.dbQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean isSimilar() {
        return false;
    }
    public void computeTotalPrice(){
        PriceCount_type pct = database.getPct();
        if(pct.name().equalsIgnoreCase(UNIT.name())){
            this.totalPrice.set(this.qty.get()*this.price.get());
        }
        if(pct.equals(SQUARECM)){
            double area = this.remainingLength.get()*this.remainingWidth.get();
            this.totalPrice.set(area*this.priceCm.get());
        }
        if(pct.equals(CUBICCM)){
            double volume = this.remainingLength.get()*this.remainingWidth.get()*this.remainingThickness.get();
            this.totalPrice.set(volume*this.priceCm.get());
        }
    }
}
