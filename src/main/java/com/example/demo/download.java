package com.example.demo;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;

public class download {
//    public static void main(String[] args) throws IOException {
//        String url = "https://gist.githubusercontent.com/hajda14/8da0b313b0503b0faee7a8d7fe63d9ca/raw/2eb3eb138e8307af00c0c64f20c97e3c802d54a2/testlog";
//        downloadUsingStream(url, "/testLog.txt");
//    }

    public static String downloadUsingStream(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[2048];
        int count = 0;
        while ((count = bis.read(buffer,0,2048)) != -1){
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
        return file;
    }


}
