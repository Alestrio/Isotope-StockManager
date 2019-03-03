/*
 * Copyright (c) 2019.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import com.google.gson.*;


import java.io.*;

public class JsonSerializer {
    private String filePath = "C:\\Users\\Alexis\\IdeaProjects\\isotope\\Isotope\\src\\com\\alestrio\\isotope\\database\\databases.json";
    private File file = new File(filePath);
    private PrintWriter pw;
    private FileOutputStream fos;
    private FileInputStream fis;
    private JsonArray ja;
    private JsonParser jp;
    private JsonElement je;
    private JsonSerializer js;
    private Gson gson;

    public JsonSerializer() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void serialize(Object o) {
        gson = new Gson();
        String serializedObject = gson.toJson(o);
        try {
            fos = new FileOutputStream(file, true);
            pw = new PrintWriter(fos);
            fis = new FileInputStream(file);
            js = new JsonSerializer();
            String fileContent = new String(fis.readAllBytes());
            ja = jp.parse(fileContent).getAsJsonArray();
            ja.add(serializedObject);
            pw.print(ja.getAsString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
