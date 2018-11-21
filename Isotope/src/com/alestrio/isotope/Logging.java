package com.alestrio.isotope;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logging {
    FileOutputStream fos;
    FileWriter f;

    public Logging() {
        try {
            f = new FileWriter(new File("log.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Cannot reach log file : creating new one");
            File file = new File("log.txt");
            try {
                file.createNewFile();
                f = new FileWriter(file);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLog(String s){
        try {
            f.write("#" + new SimpleDateFormat("dd MMMM yyyy 'à' hh:mm:ss").format(new Date()) + " : " +s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
