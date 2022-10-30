import java.io.File;

public class FileChecker {

    public static boolean check(File file, File folder){
        File jsonFile = new File(folder + "\\" + file.getName().replace(".txt", "") + ".json");
        if (!jsonFile.exists()){
            return file.getName().endsWith(".txt");
        }else{
            return false;
        }
    }
}
