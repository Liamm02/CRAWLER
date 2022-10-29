import java.io.*;

public class FileCollector {

    public static BufferedReader read(File file, File folder) throws FileNotFoundException {
        String location = folder  + "\\"  + file.getName();
        return new BufferedReader(new FileReader((location)));

    }
}
