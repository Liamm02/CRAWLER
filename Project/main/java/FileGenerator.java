import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.LinkedHashMap;

public class FileGenerator {


    public static void generate(File folder) throws Exception {
        File[] listOfFiles = folder.listFiles();

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile() && FileChecker.check(folder, file)) {

               BufferedReader br = FileCollector.read(file, folder);

               LinkedHashMap<String, String> map = MetaDataExtractor.processLinesToMap(br);
               String json = new Gson().toJson(map);
               System.out.println(json);
               FileWriter jsonFile = new FileWriter(folder + "\\"
                       + file.getName().replace(".txt", "")
                       + ".json");
               jsonFile.write(json);
               jsonFile.close();

            }
        }
    }
}
