import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonObject;
import org.json.simple.JSONObject;
import java.util.*;

public class MetaDataReader {

    public static void read(String location) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(location));
        String line;

        JsonObject jsonObj = new JsonObject();

        while (!Objects.equals(line = br.readLine(), "***")){
            if (line.contains("***")) {
                break;
            }
            if (line.contains(": ")){
                String[] values = line.split(":");
                System.out.println(Arrays.toString(values));
                String jsonKey = Arrays.toString(new String[]{values[0]}).replaceAll("[\\[\\](){}]","");
                String jsonValue = Arrays.toString(new String[]{values[1]}).replaceAll("[\\[\\](){}]","");
                jsonObj.addProperty(jsonKey,jsonValue.trim());

            }


        }
        System.out.println(jsonObj);
        br.close();
    }
}
