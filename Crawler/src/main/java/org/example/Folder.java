package org.example;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Folder {
    public static String creater() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMd");
        String date = dateFormat.format(new Date());
        File directorio = new File("C:/Users/jesus/IdeaProjects/Crawler/Documents/"+date);
        String ruta= String.valueOf(directorio);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            }
        }
        return ruta;
    }
}
