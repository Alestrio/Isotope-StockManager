/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.xml.sax.SAXException;

import org.jdom2.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlSettings {
    private ArrayList<Database> DBList;
    private Database db;
    private static XmlHandler handler = new XmlHandler();
    private static String localFilePath = "D:\\Documents\\JavaProjects\\Isotope\\Isotope\\src\\com\\alestrio\\isotope\\database\\xml\\databases.xml";
    private Document document;
    private Element root;

    public static ArrayList<Database> parseFile() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            parser.parse(localFilePath, handler);

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

    public void addDatabase(Database database){
        SAXBuilder sxb = new SAXBuilder();
        try {
            document = sxb.build(new File(localFilePath));
        } catch (JDOMException e) {
            e.printStackTrace();
            System.out.println("JDOMException");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");
        }
        root = document.getRootElement();
        Element xmlDatabase = new Element("database");
        List<DbColumn> columns = database.getColumns();
        xmlDatabase.setAttribute("name", database.getName());
        int i = 1;
        for(DbColumn c : columns){
            xmlDatabase.setAttribute("c"+i+"name", c.getName());
            xmlDatabase.setAttribute("c"+i+"type", c.getDbt().getType());
            xmlDatabase.setAttribute("c"+i+"prop", c.getProperty());
            xmlDatabase.setAttribute("c"+i+"dispname", c.getDisplayName());
        }
        xmlDatabase.setAttribute("pct", Integer.toString(database.getPct().getI()));

        XMLOutputter out = new XMLOutputter();
        try {
            out.output(xmlDatabase, new FileWriter(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
