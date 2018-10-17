/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import java.sql.SQLException;
import java.util.List;

public class DbItem extends Database {


    static protected void add(){
        //TODO Add something when there is no columns (exception or anything else)
        String addQuery = "INSERT INTO public." + this.name + " (";
        int i = 1;
        int dbNumber = columns.size();
        for(DbColumn c : columns){
            if (i < dbNumber) {
                addQuery = addQuery.concat(c.getName() + " ,");
            } else {
                addQuery = addQuery.concat(c.getName());
            }
            i++;

        }
        i = 1;
        addQuery = addQuery.concat(") VALUES (");
        for(DbColumn c : columns){
            if (i < dbNumber) {
                addQuery = addQuery.concat("\'" + c.tf.getText() + "\' ,");
            } else {
                addQuery = addQuery.concat("\'" + c.tf.getText() + "\'");
            }
            i++;
        }
        addQuery = addQuery.concat(");");
        try {
            db.connect();
            db.dbQuery(addQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
