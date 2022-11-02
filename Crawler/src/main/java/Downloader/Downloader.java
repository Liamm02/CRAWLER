package Downloader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class Downloader {
    public static int download(String ruta, int e) throws IOException {
        try {
            URL fetchWebsite = new URL("https://www.gutenberg.org/files/" + e + "/" + e + "-0.txt");
            File file = new File(ruta + "/" + e + ".txt");
            FileUtils.copyURLToFile(fetchWebsite, file);
            return 1;
        } catch (FileNotFoundException p) {
            return 0;
        }
    }
}
