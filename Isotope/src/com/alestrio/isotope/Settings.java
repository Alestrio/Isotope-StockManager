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

    public Settings() {
    }

    private Properties loadSettings() {
        try {
            in = new FileInputStream(".\\isotope.properties" /*"C:\\Users\\Alexis\\IdeaProjects\\isotope\\Isotope\\rsrc\\isotope.properties"*/); // Evidemment, le bon FilePath parce que sinon, dans le cul la balayette !!
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
        try {
            assert p != null;
            return p.getProperty("url");
        }
        catch(NullPointerException e){
            System.out.println("Fichier de configuration invalide");
            return null;
        }
    }

    String getDbUser() {
        p = loadSettings();
        try {
            assert p != null;
            return p.getProperty("user");
        }
        catch(NullPointerException e){
            System.out.println("Fichier de configuration invalide");
            return null;
        }
    }

    String getDbPswd() {
        p = loadSettings();
        try {
            assert p != null;
            return p.getProperty("pswd");
        }
        catch(NullPointerException e){
            System.out.println("Fichier de configuration invalide");
            return null;
        }
    }

    public String getVer() {
        p = loadSettings();
        return p.getProperty("ver");
    }
}
