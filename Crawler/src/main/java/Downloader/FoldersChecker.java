package Downloader;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FoldersChecker {

    public static String FoldersChecker(String path) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMd");
        String date = dateFormat.format(new Date());
        File directorio = new File(path+"/Documents/"+date);
        String ruta= String.valueOf(directorio);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
            }
        }
        File directorio_Metadata = new File(path +"/MetaData/"+date);
        if (!directorio_Metadata.exists()) {
            if (directorio_Metadata.mkdirs()) {
            }
        }
        return ruta;
    }
}
