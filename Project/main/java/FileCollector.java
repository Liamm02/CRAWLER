import java.io.*;

public class FileCollector {


    /*public static void main(String[] args) throws Exception {
        File folder = new File("C:\\Users\\krish\\Documents");
        File[] listOfFiles = folder.listFiles();

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (file.getName().endsWith(".txt")){
                    //Get txt files
                    String location = folder + "\\" + file.getName();
                    BufferedReader br = new BufferedReader(new FileReader(location));

                }

            }
        }

    }*/

    public static BufferedReader read(File file, File folder) throws FileNotFoundException {
        String location = folder  + "\\"  + file.getName();
        return new BufferedReader(new FileReader((location)));

    }
}
