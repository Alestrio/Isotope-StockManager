/*
 * Copyright (c) 2019.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import com.alestrio.isotope.Logging;
import com.alestrio.isotope.Settings;
import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;

public class JsonDeserializer {
    private String filePath = Settings.getPrimitiveFilePath() + "databases.json";
    private File file = new File(filePath);
    private Logging log = new Logging();
    private PrintWriter printWriter;


    public JsonDeserializer() {
        if (!file.exists()) {
            try {
                file.createNewFile();
                printWriter = new PrintWriter(file);
                printWriter.print("[]");
                printWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
                log.writeLog(e.getMessage());
            }
        }
    }

    public ArrayList<Database> deserialize(){
        ArrayList<Database> adb = new ArrayList<>();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try {
            FileInputStream fis = new FileInputStream(file);
            String fileContent = new String(fis.readAllBytes());
            JsonParser jp = new JsonParser();
            JsonArray ja = jp.parse(fileContent).getAsJsonArray();
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
