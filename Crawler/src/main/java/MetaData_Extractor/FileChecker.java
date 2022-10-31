package MetaData_Extractor;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileChecker {

    public static boolean check(File file, File folder){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMd");
        String date = dateFormat.format(new Date());
        File jsonFile = new File(folder + "\\MetaData\\"+date+"\\" + file.getName().substring(0, file.getName().length()-3)+"json");
        if (!jsonFile.exists()){
            return file.getName().endsWith(".txt");
        }else{
            return false;
        }
    }
}
