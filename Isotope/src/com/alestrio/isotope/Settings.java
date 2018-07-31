/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class Settings {

    FileInputStream in;
    private Properties p = new Properties();

    Settings() {
    }

    private Properties loadSettings() {
        try {
            in = new FileInputStream("isotope.properties");
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
        p = loadSettings();
        return p.getProperty("url");
    }

    String getDbUser() {
        p = loadSettings();
        return p.getProperty("user");
    }

    String getDbPswd() {
        p = loadSettings();
        return p.getProperty("pswd");
    }
}
