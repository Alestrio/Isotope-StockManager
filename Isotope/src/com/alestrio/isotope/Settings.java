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

    private Properties p = new Properties();
    FileInputStream in;
    private Properties loadSettings(){
        try {
            in = new FileInputStream("C:\\Users\\Alexis\\IdeaProjects\\isotope\\Isotope\\rsrc\\isotope.properties");
            p.load(in);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    Settings(){ }

    String getDbUrl(){
        p = loadSettings();
        return p.getProperty("url");
    }

    String getDbUser(){
        p = loadSettings();
        return p.getProperty("user");
    }

    String getDbPswd(){
        p = loadSettings();
        return p.getProperty("pswd");
    }
}
