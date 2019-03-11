/*
 * Copyright (c) 2019.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import com.google.gson.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class JsonDeserializer {
    private FileInputStream fis;
    private JsonArray ja;
    private JsonParser jp;
    private String filePath = "C:\\Users\\Alexis\\IdeaProjects\\isotope\\Isotope\\src\\com\\alestrio\\isotope\\database\\databases.json";
    private File file = new File(filePath);


    public JsonDeserializer() {
    }

    public ArrayList<Database> deserialize(){
        ArrayList<Database> adb = new ArrayList<>();
        Gson gson = new Gson();
        try {
            fis = new FileInputStream(file);
            String fileContent = new String(fis.readAllBytes());
            jp = new JsonParser();
            ja = jp.parse(fileContent).getAsJsonArray();
            for(JsonElement jo : ja){
                adb.add(gson.fromJson(jo, Database.class));
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }


        return adb;
    }
}
