/*
 * Copyright (c) 2019.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import flexjson.JSONSerializer;

import java.io.*;

public class JsonSerializer {
    private String filePath = "C:\\Users\\Alexis\\IdeaProjects\\isotope\\Isotope\\src\\com\\alestrio\\isotope\\database\\databases.json";
    private File file = new File(filePath);
    private FileWriter fw;

    public JsonSerializer() {
    }

    public void serialize(Object o){
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Impossible d'ecrire dans le fichier JSON");
        }

        String serializedObject;
        serializedObject = new JSONSerializer().include("columns").serialize(o);

        try {
            fw.write(serializedObject);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Impossible d'ecrire dans le fichier JSON");
        }


    }
}
