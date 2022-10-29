import java.io.File;

public class FileChecker {

    public static boolean check(File file){
        return file.getName().endsWith(".txt");
    }
}
