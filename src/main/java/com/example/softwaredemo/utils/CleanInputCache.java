package com.example.softwaredemo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CleanInputCache extends Thread{
    private InputStream is;
    private String type;

    public CleanInputCache(InputStream is, String type) {
        this.is = is;
        this.type = type;
    }

    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            String tmp = null;
            while ((line = br.readLine()) != null) {
                tmp = type + ">>>" + line;
                System.out.println(new String(tmp.getBytes(StandardCharsets.UTF_8)));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
