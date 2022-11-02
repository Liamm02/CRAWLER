package MetaData_Extractor;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

public class FileGenerator {


    public static void generateJsonFile(File folder) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMd");
        String date = dateFormat.format(new Date());
        File f = new File(folder+"\\Documents\\"+date+"\\");
        File[] listOfFiles = f.listFiles();

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile() && FileChecker.checkTextFile(file, folder)) {

               BufferedReader br = FileCollector.readTextFile(file, folder);
               String ID = file.getName().substring(0,file.getName().length()-4);
               LinkedHashMap<String, String> map = MetaDataExtractor.processLinesToMap(br,ID);
               String json = new Gson().toJson(map);
               FileWriter jsonFile = new FileWriter(folder + "\\MetaData\\"+date+"\\"
                       + file.getName().replace(".txt", "")
                       + ".json");
               jsonFile.write(json);
               jsonFile.close();

            }
        }
    }
}
