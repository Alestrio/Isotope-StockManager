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

    private FileInputStream in;
    private Properties p = new Properties();
    private static String primitiveFilePath = ".\\";

    public Settings() {
    }

    private Properties loadProp() {
        try {
            in = new FileInputStream(this.primitiveFilePath + "isotope.properties");
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

    public static String getPrimitiveFilePath() {
        return primitiveFilePath;
    }

    public String getVer() {
        p = loadProp();
        assert p != null;
        return p.getProperty("ver");

    }

    /*-------- FXML Edition --------*/

}
