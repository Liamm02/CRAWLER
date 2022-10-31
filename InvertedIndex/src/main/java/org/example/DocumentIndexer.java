package org.example;

import org.json.JSONObject;
import java.io.File;
import java.util.*;

public class DocumentIndexer {

    public static void DocumentIndex(HashMap<String, Set<Integer>> Document_map, String doc, String path){

        String jsonPath = path+"Inv_Index.json";

        FileReader fr = new FileReader();
        File file = new File(jsonPath);
        String content = fr.Read_File(file);
        if (content.isEmpty()){
            JSONObject json = new JSONObject();
            for (String key : Document_map.keySet()) {
                HashMap<String, List<Integer>> DOC_LINES = DocLinesRelationCreator.DOCLINESRelationCreator(Document_map,key,doc);
                json.append(key, DOC_LINES);

            }
            FileWriter fw = new FileWriter();
            fw.Json_writer(json,jsonPath);
        } else {
            JSONObject json = new JSONObject(content);
            for (String key : Document_map.keySet()) {
                HashMap<String, List<Integer>> DOC_LINES = DocLinesRelationCreator.DOCLINESRelationCreator(Document_map,key,doc);
                 if (json.has(key)) {
                     if (json.get(key).toString().contains(doc)) {
                         for(Integer index = 0; index<json.getJSONArray(key).length(); index++){
                             if (json.getJSONArray(key).get(index).toString().contains(doc)){
                                 json.getJSONArray(key).remove(index);
                             }
                         }
                         json.append(key, DOC_LINES);
                     } else {
                         json.append(key, DOC_LINES);
                     }
                 }else {
                     json.append(key, DOC_LINES);
                 }
            }
            FileWriter fw = new FileWriter();
            fw.Json_writer(json,jsonPath);
        }
    }

}
