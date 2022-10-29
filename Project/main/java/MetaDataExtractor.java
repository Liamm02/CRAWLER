import java.io.BufferedReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Objects;

public class MetaDataExtractor {


    static LinkedHashMap<String,String> processLinesToMap(BufferedReader br) throws Exception {
        String line;
        int counter = 0;
        String lastKey = "";
        String lastValue = "";
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        while (!Objects.equals(line = br.readLine(), "***")){

            if (line.contains("Title:")){
                counter = 1;
            }

            if (counter == 1){
                if (line.contains("***")) {
                    break;
                }
                if (line.contains(": ")){

                    String[] values = line.split(":");
                    String jsonKey = Arrays.toString(new String[]{values[0]}).replaceAll("[\\[\\](){}]","");
                    String jsonValue = Arrays.toString(new String[]{values[1]}).replaceAll("[\\[\\](){}]","");
                    if (jsonValue.equals("")){
                        jsonValue = "Unknown";
                    }
                    lastKey = jsonKey;
                    lastValue = jsonValue;
                    MetaDataManager.build(map, jsonKey,jsonValue);

                }
                else{
                    String newValue = line.trim();
                    if (!newValue.equals("")){
                        MetaDataManager.modify(map, lastKey, lastValue, newValue);
                        lastValue = lastValue.trim() + " " + newValue.trim();

                    }
                }
            }

        }

        return map;

    }
}
