/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import javafx.scene.control.TableColumn;
import javafx.scene.paint.Material;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class XmlHandler extends DefaultHandler {
    private String node = "";
    private Database db = new Database();
    private ArrayList<Database> aldb = new ArrayList<>();

    public void startDocument() throws SAXException{
        System.out.println("Parsing XML Document...");
    }

    public void endDocument() throws SAXException{
        System.out.println("Parsing success");
    }

    public void startElement(String namespaceURL, String lname, String qname, Attributes attrs) throws SAXException{
        System.out.println(attrs.getLength());
        if(qname.equals("database")){
            db.setName(attrs.getValue(0));
            for(int i = 1; i < attrs.getLength() - 1; i+=4){
                if(attrs.getValue(i+1).equals("text"))
                    db.addColumn(new DbColumn(attrs.getValue(i), DB_TYPE.TEXT, attrs.getValue(i+2), attrs.getValue(i+3)));
                if(attrs.getValue(i+1).equals("numeric"))
                    db.addColumn(new DbColumn(attrs.getValue(i), DB_TYPE.NUMERIC, attrs.getValue(i+2), attrs.getValue(i+3)));
                if(attrs.getValue(i+1).equals("serial"))
                    db.addColumn(new DbColumn(attrs.getValue(i), DB_TYPE.SERIAL, attrs.getValue(i+2), attrs.getValue(i+3)));
                if(attrs.getValue(i+1).equals("integer"))
                    db.addColumn(new DbColumn(attrs.getValue(i), DB_TYPE.INTEG, attrs.getValue(i+2), attrs.getValue(i+3)));
            }
            aldb.add(db);

            int pctIndex = Integer.parseInt(attrs.getValue(attrs.getLength()-1));

            if(pctIndex == 1)
                db.setPct(PriceCount_type.UNIT);
            if(pctIndex == 2)
                db.setPct(PriceCount_type.SQUARECM);
            if(pctIndex == 3)
                db.setPct(PriceCount_type.CUBICCM);
        }


    }

    public ArrayList<Database> getArrayOfDatabases(){
        return aldb;
    }
}

