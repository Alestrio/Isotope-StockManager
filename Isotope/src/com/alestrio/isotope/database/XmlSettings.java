/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

public class XmlSettings {
    private ArrayList<Database> DBList;
    private Database db;
    private static XmlHandler handler = new XmlHandler();

    public static ArrayList<Database> parseFile() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            parser.parse("D:\\Documents\\JavaProjects\\Isotope\\Isotope\\src\\com\\alestrio\\isotope\\database\\xml\\databases.xml", handler);

        }
        catch(ParserConfigurationException e){
            e.printStackTrace();
            System.out.println("Erreur de parser");
        }
        catch(SAXException e){
            e.printStackTrace();
            System.out.println("Erreur SAX");
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Impossible de lire le fichier");
        }
        return handler.getArrayOfDatabases();
    }
}
