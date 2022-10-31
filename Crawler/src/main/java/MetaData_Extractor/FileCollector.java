package MetaData_Extractor;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileCollector {

    public static BufferedReader read(File file, File folder) throws FileNotFoundException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMd");
        String date = dateFormat.format(new Date());
        String location = folder  + "\\Documents\\"+date+"\\"  + file.getName();
        return new BufferedReader(new FileReader((location)));

    }
}
