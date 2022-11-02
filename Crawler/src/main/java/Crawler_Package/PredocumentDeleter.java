package Crawler_Package;

import MetaData_Extractor.FileCollector;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PredocumentDeleter {

    public static void deletePredocument(String path) throws IOException {
        File folder = new File(path);

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMd");
        String date = dateFormat.format(new Date());
        File f = new File(folder+"\\Documents\\"+date+"\\");
        File[] listOfFiles = f.listFiles();

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            String DocName = file.getName();

            String doc = Files.readString(Path.of(file.toURI()));

            file.delete();

            String[] SplitedDoc = doc.split("\\*\\*\\*");
            File fnew = new File(folder+"\\Documents\\"+date+"\\"+DocName);
            FileWriter f2 = new FileWriter(fnew, false);
            if (SplitedDoc.length==1){
                f2.write(SplitedDoc[0]);
            }
            else {
                f2.write(SplitedDoc[2]);
            }
            f2.close();
        }


    }

}
