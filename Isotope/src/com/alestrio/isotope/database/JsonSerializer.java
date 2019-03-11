/*
 * Copyright (c) 2019.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import com.alestrio.isotope.Logging;
import com.google.gson.*;
import org.apache.commons.lang3.StringEscapeUtils;

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
    private Gson gson;
    private Logging log;


    public JsonSerializer() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                log.writeLog(e.getMessage());
            }
        }
    }

    public void serialize(Object o) {
        gson = new GsonBuilder().setPrettyPrinting().create();
        String serializedObject = "{" + gson.toJson(o).substring(2, gson.toJson(o).length()-2) + "}";
        try {
            fis = new FileInputStream(file);
            String fileContent = new String(fis.readAllBytes());
            jp = new JsonParser();
            ja = jp.parse(fileContent).getAsJsonArray();
            fos = new FileOutputStream(file, false);
            pw = new PrintWriter(fos);
            je = jp.parse(serializedObject);
            ja.add(je);
            String unescapedobject = StringEscapeUtils.unescapeJava(ja.toString());
            JsonArray jatemp = jp.parse(unescapedobject).getAsJsonArray();
            pw.print(gson.toJson(jatemp));
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
            log.writeLog(e.getMessage());
        }

    }
}
