/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {

    FileInputStream in;
    private Properties p = new Properties();

    public Settings() {
    }

    private Properties loadProp() {
        try {
            //TODO File path
            in = new FileInputStream(/*".\\isotope.properties"*/
                    /*"D:\\Documents\\JavaProjects\\Isotope\\Isotope\\rsrc\\isotope.properties"*/
                    "C:\\Users\\Alexis\\IdeaProjects\\isotope\\Isotope\\rsrc\\isotope.properties");
            p.load(in);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    String getDbUrl() {
        p = loadProp();
        assert p != null;
        return p.getProperty("url");
    }

    String getDbUser() {
        p = loadProp();
        assert p != null;
        return p.getProperty("user");
    }

    String getDbPswd() {
        p = loadProp();
        assert p != null;
        return p.getProperty("pswd");
    }

    public String getVer() {
        p = loadProp();
        assert p != null;
        return p.getProperty("ver");
    }

    /*-------- FXML Edition --------*/

}
