import java.util.LinkedHashMap;

public class MetaDataManager {

    public static void build(LinkedHashMap<String, String> map, String jsonKey, String jsonValue){
        map.put(jsonKey.trim(),jsonValue.trim());

    }
    public static void modify(LinkedHashMap<String, String> map, String lastKey, String lastValue, String jsonValue){
        //System.out.println(lastKey + lastValue+ jsonValue);
        map.replace(lastKey.trim(), lastValue.trim(), lastValue.trim() + " " + jsonValue.trim());
        //System.out.println(map);
    }

}
