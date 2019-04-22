/*
 * Copyright (c) 2019.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope.database;

import com.alestrio.isotope.Logging;
import com.alestrio.isotope.Settings;
import com.google.gson.*;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.*;

public class JsonSerializer {
    private String filePath = Settings.getPrimitiveFilePath() + "databases.json";
    private File file = new File(filePath);
    private Logging log;


    public JsonSerializer() {
        log = new Logging();
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
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String serializedObject = "{" + gson.toJson(o).substring(2, gson.toJson(o).length()-2) + "}";
        try {
            FileInputStream fis = new FileInputStream(file);
            String fileContent = new String(fis.readAllBytes());
            JsonParser jp = new JsonParser();
            JsonArray ja = jp.parse(fileContent).getAsJsonArray();
            FileOutputStream fos = new FileOutputStream(file, false);
            PrintWriter pw = new PrintWriter(fos);
            JsonElement je = jp.parse(serializedObject);
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
